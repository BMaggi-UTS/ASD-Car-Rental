package model;
import java.io.Serializable;
import java.time.LocalDate; // year, month, day
import java.time.YearMonth; // year, month


public class payment implements Serializable {
    private int orderID;
    private int cardNumber;
    private YearMonth expiry;
    private String cvc;
    private String status;
    private LocalDate date;
    private String currency;

    public payment(){};

    public payment(
        int orderID,
        int cardNumber,
        YearMonth expiry,
        String cvc,
        String status,
        LocalDate date,
        String currency) {
            this.orderID = orderID;
            this.cardNumber = cardNumber;
            this.expiry = expiry;
            this.cvc = cvc;
            this.status = status;
            this.date = date;
            this.currency = currency;
            
        }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public YearMonth getExpiry() {
        return expiry;
    }

    public void setExpiry(YearMonth expiry) {
        this.expiry = expiry;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}


