package com.stackroute.RestFul.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String firstName;
    private String lastName;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String model;
    private String engine;
    private String driver;
    private String commercial;
    private String outstate;
    private String marketValue;
    private String date;
    private String message;
    private Integer taskId;
    private double finalQuoteAmount;

   // private Double finalQuoteAmount;
    //private Integer age;

    public User() {
    }

    public User(String title, String firstName, String lastName, String phone, String address1, String address2, String city, String state, String model, String engine,
                String driver, String commercial, String outstate, String marketValue, String date, String message, Integer taskId, Integer id, double finalQuoteAmount ) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.model = model;
        this.engine = engine;
        this.driver = driver;
        this.commercial = commercial;
        this.outstate = outstate;
        this.marketValue = marketValue;
        this.date = date;
        this.message=message;
        this.taskId = taskId;
        this.id = id;
        this.finalQuoteAmount=finalQuoteAmount;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public String getOutstate() {
        return outstate;
    }

    public void setOutstate(String outstate) {
        this.outstate = outstate;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getFinalQuoteAmount() {
        return finalQuoteAmount;
    }

    public void setFinalQuoteAmount(double finalQuoteAmount) {
        this.finalQuoteAmount = finalQuoteAmount;
    }



    @Override
    public String toString() {
        return "User{" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", driver='" + driver + '\'' +
                ", commercial='" + commercial + '\'' +
                ", outstate='" + outstate + '\'' +
                ", marketValue='" + marketValue + '\'' +
                ", date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", taskId=" + taskId +
                ", id=" + id +
                "finalQuoteAmount=" + finalQuoteAmount +
                '}';
    }
}
