package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wby on 2018/5/2.
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    private int id;
    @Column(length=20)
    private String userName;
    @Column(length=20)
    private String password;
    @OneToMany(mappedBy="user",targetEntity = Booking.class ,fetch=FetchType.EAGER)
    private Set<Booking>bookingSet=new HashSet <>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set <Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set <Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", bookingSet=" + bookingSet +
                '}';
    }
}
