package model;
import java.io.Serializable;
<<<<<<< HEAD
import java.time.LocalDate; // year, month, day
=======
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
import java.time.YearMonth; // year, month


public class payment implements Serializable {
<<<<<<< HEAD
    private int orderID;
    private int cardNumber;
    private YearMonth expiry;
    private String cvc;
    private String status;
    private LocalDate date;
    private String currency;
=======
    private int paymentID;
    private int orderID;
    private int userID;
    private String cardName;
    private String cardNumber;
    private YearMonth expiry;
    private String cvc;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

    public payment(){};

    public payment(
<<<<<<< HEAD
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
=======
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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

<<<<<<< HEAD
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
=======
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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        this.cardNumber = cardNumber;
    }

    public YearMonth getExpiry() {
        return expiry;
    }

    public void setExpiry(YearMonth expiry) {
<<<<<<< HEAD
        this.expiry = expiry;
=======
        this.expiry = expiry; 
    }

    public String getExpiryAsString() {
        return expiry.toString(); // Convert YearMonth to "YYYY-MM" string format
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
<<<<<<< HEAD

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
=======
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
}


