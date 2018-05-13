package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.PageBean;
import com.zhbit.entity.User;
import com.zhbit.service.UserService;
import com.zhbit.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private BaseDAO baseDAO;
    @Override
    public List<User> queryUserList(User user, PageBean pageBean) {
        List<Object> param=new LinkedList<Object>();
        StringBuffer hql=new StringBuffer("from User");

        if(user!=null){
            if(StringUtil.isNotEmpty(user.getUserName())){
                hql.append(" and userName like ? ");
                param.add("%"+user.getUserName()+"%");
            }
        }
        if(pageBean!=null){
            return baseDAO.find(hql.toString().replaceFirst("and", "where"), param, pageBean);
        }else{
            return null;
        }
    }

    @Override
    public Long getUserCount(User user) {
        List<Object> param=new LinkedList<Object>();
        StringBuffer hql=new StringBuffer("select count(*) from Booking");
        if(user!=null){
            if(StringUtil.isNotEmpty(user.getUserName())){
                hql.append(" and userName like ? ");
                param.add("%"+user.getUserName()+"%");
            }
        }
        return baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
    }

    @Override
    public void delete(User user) {
        baseDAO.delete(user);
    }

    @Override
    public User getUserById(int id) {
        System.out.println(id+"ididididi");
        User user= (User) baseDAO.get(User.class,id);
        System.out.println(user+"useruuuuuuuuu");
        return user;
    }
}
