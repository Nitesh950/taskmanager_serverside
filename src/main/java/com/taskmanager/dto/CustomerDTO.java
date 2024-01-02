package com.taskmanager.dto;

import java.time.LocalDate;


public class CustomerDTO {

    private Integer customerId;
    private String emailId;
    private String name;
    private String password;
    private LocalDate dateOfBirth;

    public CustomerDTO(){

    }

    public CustomerDTO(Integer customerId, String emailId, String name, String password, LocalDate dateOfBirth) {
        super();
        this.customerId = customerId;
        this.emailId = emailId;
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
