package model;
import java.io.Serializable;
import java.time.YearMonth; // year, month


public class payment implements Serializable {
    private int paymentID;
    private int orderID;
    private int userID;
    private String cardName;
    private String cardNumber;
    private YearMonth expiry;
    private String cvc;

    public payment(){};

    public payment(
        int paymentID,
        int orderID,
        int userID,
        String cardName,
        String cardNumber,
        YearMonth expiry,
        String cvc) {
            this.orderID = orderID;
            this.userID = userID;
            this.cardName = cardName;
            this.cardNumber = cardNumber;
            this.expiry = expiry;
            this.cvc = cvc;      
        }
    public int getPaymentID() {
        return paymentID;
    }
    
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public YearMonth getExpiry() {
        return expiry;
    }

    public void setExpiry(YearMonth expiry) {
        this.expiry = expiry; 
    }

    public String getExpiryAsString() {
        return expiry.toString(); // Convert YearMonth to "YYYY-MM" string format
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}


