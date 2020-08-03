package com.schoolproject.rmats.model;

import javax.persistence.*;

@Entity
@Table(name = "replacements", schema = "sql_rmats")
public class ReplacementUnit {
    @Id
    @Column(name = "replacement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replacementId;

    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @Column(name = "current_status")
    private String status;
    private String carrier;

    @Column(name = "tracking_number")
    private String trackingNumber;
    private String model;

    @Column(name = "new_serial_number")
    private String newSerialNumber;

    @Column(name = "shipper_comment")
    private String comment;
    public void setReplacementId(Integer replacementId) {
        this.replacementId = replacementId;
    }

    public ReplacementUnit() {
    }

    public ReplacementUnit(Integer replacementId, Boolean isProcessed, String status, String carrier, String trackingNumber, String model, String serialNumber, String comment) {
        this.replacementId = replacementId;
        this.status = status;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.model = model;
        this.newSerialNumber = serialNumber;
        this.comment = comment;
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

    public String getNewSerialNumber() {
        return newSerialNumber;
    }

    public String getComment() {
        return comment;
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

    public void setNewSerialNumber(String serialNumber) {
        this.newSerialNumber = serialNumber;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getReplacementId() {
        return replacementId;
    }
}
