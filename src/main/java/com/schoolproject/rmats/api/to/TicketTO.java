package com.schoolproject.rmats.api.to;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.util.Date;

public class TicketTO {
    private final Date raiseDate;

    @Size(min = 0, max = 500)
    private final String CustComment;

    @JsonCreator
    public TicketTO(@JsonProperty("custComment") String custComment) {
        this.raiseDate = new Date();
        CustComment = custComment;
    }

    public Date getRaiseDate() {
        return raiseDate;
    }

    public String getCustComment() {
        return CustComment;
    }
}
