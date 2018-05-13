package com.zhbit.service;

import com.zhbit.entity.Booking;
import com.zhbit.entity.PageBean;
import com.zhbit.entity.User;

import java.util.List;

/**
 * Created by wby on 2018/5/2.
 */
 public interface UserService {


    public List <User> queryUserList(User user, PageBean pageBean);

    public Long getUserCount(User user);



    public void delete(User user);




    public User getUserById(int id);
}
