package com.schoolproject.rmats.model;

import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String password;
    private int enabled;
    private List<Ticket> ticketList;
    private Address address;

    public Customer(int id, String firstName, String lasstName, String companyName, String phoneNumber, String email, String password, int enabled, Address address, List<Ticket> ticketList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lasstName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.ticketList = ticketList;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public Address getAddress() {
        return address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
