package com.schoolproject.rmats.model;

import org.hibernate.annotations.Type;

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

    @Column(name = "is_processed", columnDefinition="TINYINT(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isProcessed;

    @Column(name = "current_status")
    private String status;
    private String carrier;

    @Column(name = "tracking_number")
    private String trackingNumber;
    private String model;

    @Column(name = "new_serial_number")
    private String serialNumber;

    @Column(name = "shipper_comment")
    private String comment;
    public void setReplacementId(Integer replacementId) {
        this.replacementId = replacementId;
    }

    public ReplacementUnit() {
    }

    public ReplacementUnit(Integer replacementId, Boolean isProcessed, String status, String carrier, String trackingNumber, String model, String serialNumber, String comment) {
        this.replacementId = replacementId;
        this.isProcessed = isProcessed;
        this.status = status;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.model = model;
        this.serialNumber = serialNumber;
        this.comment = comment;
    }


    public Boolean isProcessed() {
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

    public void setProcessed(Boolean processed) {
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

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public Integer getReplacementId() {
        return replacementId;
    }
}
