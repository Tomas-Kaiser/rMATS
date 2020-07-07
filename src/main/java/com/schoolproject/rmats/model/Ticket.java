package com.schoolproject.rmats.model;


import java.util.Date;

public class Ticket {
    private int id;
    private ReplacementUnit replacementUnit;
    private FaultyUnit faultyUnit;
    private Date raiseDate;
    private String comment;

    public Ticket(int id, Date raiseDate, String comment, FaultyUnit faultyUnit, ReplacementUnit replacementUnit) {
        this.id = id;
        this.raiseDate = raiseDate;
        this.comment = comment;
        this.faultyUnit = faultyUnit;
        this.replacementUnit = replacementUnit;
    }

    public int getId() {
        return id;
    }

    public ReplacementUnit getReplacementUnit() {
        return replacementUnit;
    }

    public FaultyUnit getFaultyUnit() {
        return faultyUnit;
    }

    public Date getRaiseDate() {
        return raiseDate;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReplacementUnit(ReplacementUnit replacementUnit) {
        this.replacementUnit = replacementUnit;
    }

    public void setFaultyUnit(FaultyUnit faultyUnit) {
        this.faultyUnit = faultyUnit;
    }

    public void setRaiseDate(Date raiseDate) {
        this.raiseDate = raiseDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
