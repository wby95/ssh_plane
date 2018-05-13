package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.Booking;
import com.zhbit.entity.PageBean;
import com.zhbit.entity.User;
import com.zhbit.service.UserService;
import com.zhbit.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wby on 2018/5/2.
 */
public class UserAction extends ActionSupport {
   private String page;
   private String rows;
   private User user;
   @Autowired
   private UserService userService;
    private JSONObject jsonObject;

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

    public String list1() throws Exception {
          //����easyUi�������� ҳ����&ÿҳ�ļ�¼��
          PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
          List <User> bookingList = userService.queryUserList(user, pageBean);
          long total = userService.getUserCount(user);

        JsonConfig config = new JsonConfig();
       // config.setExcludes(new String[]{" user"});//��ȥuser����

        JSONArray rows = JSONArray.fromObject(bookingList,config);

        JSONObject result = jsonObject;
          //����easyui���ܽ�����rows json����&total �ܵļ�¼��
          result.put("rows", rows);
          result.put("total", total);
          System.out.println(user.toString());
          ResponseUtil.write(ServletActionContext.getResponse(), result);
          return null;

      }








}
