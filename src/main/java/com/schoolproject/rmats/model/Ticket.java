package com.schoolproject.rmats.model;


import java.util.Date;

public class Ticket {
    private int id;
    private ReplacementUnit replacementUnit;
    private FaultyUnit faultyUnit;
    private Date raiseDate;
    private String comment;

    public Ticket(int id, ReplacementUnit replacementUnit, FaultyUnit faultyUnit, Date raiseDate) {
        this.id = id;
        this.replacementUnit = replacementUnit;
        this.faultyUnit = faultyUnit;
        this.raiseDate = new Date();
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
        this.replacementUnit = new ReplacementUnit();
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
