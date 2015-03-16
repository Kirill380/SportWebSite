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

    public News() {

    }

    public News(int id, Timestamp date, String content, String header) {
        this.id = id;
        this.orderDate = date;
        this.content = content;
        this.header = header;
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

    public void setId(int id) {
        this.id = id;
    }
}
