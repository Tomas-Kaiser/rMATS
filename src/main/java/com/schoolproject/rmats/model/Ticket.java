package com.schoolproject.rmats.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets", schema = "sql_rmats")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "raise_date")
    private Date raiseDate;
    @Column(name = "cust_comment")
    private String comment;

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getRaiseDate() {
        return raiseDate;
    }

    public void setRaiseDate(Date raiseDate) {
        this.raiseDate = raiseDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
