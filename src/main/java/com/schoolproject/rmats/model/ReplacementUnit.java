package com.schoolproject.rmats.model;

import javax.persistence.*;

@Entity
@Table(name = "replacements", schema = "sql_rmats")
public class ReplacementUnit {
    @Id
    @Column(name = "replacement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "isProcessed", columnDefinition = "TINYINT")
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Transient
    private Boolean isProcessed;
    @Column(name = "current_status")
    private String status;
    private String carrier;
    @Column(name = "tracking_number")
    private Integer trackingNumber;
    private String model;
    @Column(name = "new_serial_number")
    private String serialNumber;
    @Column(name = "shipper_comment")
    private String comment;

    public ReplacementUnit() {
    }

    public ReplacementUnit(Integer id, Boolean isProcessed, String status, String carrier, Integer trackingNumber, String model, String serialNumber, String comment) {
        this.id = id;
        this.isProcessed = isProcessed;
        this.status = status;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.model = model;
        this.serialNumber = serialNumber;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
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

    public Integer getTrackingNumber() {
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

    public void setId(Integer id) {
        this.id = id;
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

    public void setTrackingNumber(Integer trackingNumber) {
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
