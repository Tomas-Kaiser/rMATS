package com.schoolproject.rmats.model;

import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lasstName;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Ticket> ticketList;
    private List<Address> addressList;

    public Customer(int id, String firstName, String lasstName, String companyName, String phoneNumber, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lasstName = lasstName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasstName() {
        return lasstName;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public String getCompanyName() {
        return companyName;
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

    public void setLasstName(String lasstName) {
        this.lasstName = lasstName;
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

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


}
