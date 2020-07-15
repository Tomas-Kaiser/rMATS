package com.schoolproject.rmats.model;

import javax.persistence.*;

@Entity
@Table(name = "faulties", schema = "sql_rmats")
public class FaultyUnit {
    @Id
    @Column(name = "faulty_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String model;

    @Column(name = "serial_number")
    private String serialNumber;
    public FaultyUnit() {
    }
    public FaultyUnit(Integer id, String model, String serialNumber) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
