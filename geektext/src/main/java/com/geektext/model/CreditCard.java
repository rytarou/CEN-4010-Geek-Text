package com.geektext.usercreation;

import org.springframework.data.annotation.Transient;

public class CreditCard {
    
    private String cardHolderName;
    private String cardNumber;
    private String expirationDate;
    
    @Transient // Indicate that we should not store CVV in the database
    private String cvv;
    
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        // Only store last 4 digits for display; encrypt full number elsewhere if needed
        this.cardNumber = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
