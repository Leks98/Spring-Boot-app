package com.example.app.model;


import java.util.Date;

public class Numerator {

    private int value;
    private Date additionDate;
    private boolean isPalindrome;

    public Date getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(Date additionDate) {
        this.additionDate = additionDate;
    }

    public boolean getIsPalindrome() {
        return isPalindrome;
    }

    public void setIsPalindrome(boolean palindrome) {
        isPalindrome = palindrome;
    }

    public Numerator() {
        this.additionDate = new Date(System.currentTimeMillis());
    }

    public Numerator(int value, boolean isPalindrome) {
        this.value = value;
        this.additionDate = new Date(System.currentTimeMillis());
        this.isPalindrome=isPalindrome;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}