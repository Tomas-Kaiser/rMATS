package com.schoolproject.rmats.model;

public class ReplacementUnit {
    private int id;
    private Boolean isProccessed;
    private String status;
    private String carrier;
    private String trackingNumber;
    private String model;
    private String serialNumber;
    private String comment;

    public int getId() {
        return id;
    }

    public Boolean getProccessed() {
        return isProccessed;
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

    public void setProccessed(Boolean proccessed) {
        isProccessed = proccessed;
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
