package com;

public class PaymentDTO {
    private int paymentId;
    private String patientName;
    private Double amout;
    private String type;
    private String date;

    public PaymentDTO(int paymentId, String patientName, Double amout, String type, String date) {
        this.paymentId = paymentId;
        this.patientName = patientName;
        this.amout = amout;
        this.type = type;
        this.date = date;
    }

    public PaymentDTO(String patientName, Double amout, String type, String date) {
        this.patientName = patientName;
        this.amout = amout;
        this.type = type;
        this.date = date;
    }

    public PaymentDTO(){}

    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public Double getAmout() {
        return amout;
    }
    public void setAmout(Double amout) {
        this.amout = amout;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
