package com.zhbit.action;


import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.Booking;
import com.zhbit.entity.PageBean;
import com.zhbit.entity.User;
import com.zhbit.service.BookingService;
import com.zhbit.service.UserService;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingAction extends ActionSupport {

    private Booking booking;
    private String page;
    private String rows;
    private Booking booking1;
    private String ids;
    public Booking getBooking1() {
        return booking1;
    }

    public void setBooking1(Booking booking1) {
        this.booking1 = booking1;
    }

    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserService userService;


    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String execute() {

        return SUCCESS;
    }

    /**
     * 展现所有用户订票的情况
     *
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        //接收easyUi传过来的 页码数&每页的记录数
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        List <Booking> bookingList = bookingService.queryBooingList(booking, pageBean);
        long total = bookingService.getBookingCount(booking);

        JsonConfig jsonConfig = new JsonConfig();


        jsonConfig.registerJsonValueProcessor(User.class, new ObjectJsonValueProcessor(new String[]{"id","userName"}, User.class));
        JSONArray rows=JSONArray.fromObject(bookingList, jsonConfig);


        JSONObject result = new JSONObject();

        //返回easyui所能解析的rows json数组&total 总的记录数
        result.put("rows", rows);
        result.put("total", total);
        ResponseUtil.write(ServletActionContext.getResponse(), result);
        return null;
    }


    /**
     * 更该后保存
     * @return
     * @throws Exception
     */
    public String saveBooking() throws Exception {
        bookingService.saveBooking(booking1);

        System.out.println(booking1.getSex()+"444444444444444444444");
        JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
    }

    /**
     * 删除
     * @return
     * @throws Exception
     */
	public String deleteBooking()throws Exception{
		JSONObject result=new JSONObject();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
           Booking booking=bookingService.getBookingById(Integer.parseInt(idsStr[i]));
            System.out.println(booking.toString()+"yyyyyyyyyyyyyyy");
           bookingService.delete(booking);



        }
		result.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}


}