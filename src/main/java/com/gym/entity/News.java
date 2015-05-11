package com.gym.entity;

import java.sql.Timestamp;

/**
 * Created by Nout on 16/03/2015.
 */
public class News {
    private int id;
    private Timestamp orderDate;
    private String header;
    private String content;
    private int admin_id;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }


    public News() {

    }

    public News(int id, Timestamp date, String content, String header, int admin_id) {
        this.id = id;
        this.orderDate = date;
        this.content = content;
        this.header = header;
        this.admin_id = admin_id;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

}
