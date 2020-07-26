package com.schoolproject.rmats.api.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class FaultyTO {

    @Positive
    private final Integer ticketId;

    @Size(min = 3, max = 20)
    private final String model;

    @Size(min = 5, max = 20)
    private final String serialNumber;

    @JsonCreator
    public FaultyTO(@JsonProperty("ticketId") int ticketId, @JsonProperty("model") String model, @JsonProperty("serialNumber") String serialNumber) {
        this.ticketId = ticketId;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getTicketId() {
        return ticketId;
    }
}
