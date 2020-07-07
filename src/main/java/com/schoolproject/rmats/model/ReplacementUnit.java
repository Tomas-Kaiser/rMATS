package com.schoolproject.rmats.model;

public class ReplacementUnit {
    private int id;
    private int isProcessed;
    private String status;
    private String carrier;
    private String trackingNumber;
    private String model;
    private String serialNumber;
    private String comment;

    public ReplacementUnit(int id, int isProcessed, String status, String carrier, String trackingNumber, String model, String serialNumber, String comment) {
        this.id = id;
        this.isProcessed = isProcessed;
        this.status = status;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.model = model;
        this.serialNumber = serialNumber;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public int isProcessed() {
        return isProcessed;
    }

    public String getStatus() {
        return status;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProcessed(int processed) {
        isProcessed = processed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
