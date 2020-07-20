package com.schoolproject.rmats.api.transition.object;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ReplacementTO {
    @Positive
    private Integer ticketId;

    private String carrier;
    @Size(min = 7)
    private String trackingNumber;
    private String model;
    @Size(min = 7)
    private String newSerialNumber;
    private String comment;

    @JsonCreator
    public ReplacementTO(@JsonProperty("ticketId") Integer ticketId,
                         @JsonProperty("carrier") String carrier,
                         @JsonProperty("trackingNumber") String trackingNumber,
                         @JsonProperty("model") String model,
                         @JsonProperty("newSerialNumber") String newSerialNumber,
                         @JsonProperty("comment") String comment) {
        this.ticketId = ticketId;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.model = model;
        this.newSerialNumber = newSerialNumber;
        this.comment = comment;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNewSerialNumber() {
        return newSerialNumber;
    }

    public void setNewSerialNumber(String newSerialNumber) {
        this.newSerialNumber = newSerialNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
