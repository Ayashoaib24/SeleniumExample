package org.example.pages;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Base {
    @FindBy(xpath="//*[@id=\"nav-signin-tooltip\"]/a")
    WebElement signInButton;

    @FindBy(id="ap_email")
    WebElement phone;
    @FindBy(id="ap_password")
    WebElement password;

    @FindBy(id="continue")
    WebElement continueButton;
    @FindBy(id="signInSubmit")
    WebElement submitButton;
    public Login(WebDriver driver){
        super(driver);
        URL = "https://www.amazon.eg/";
        initElements(this);
        this.visit();
    }

    private void setSignInButton(){
        performWaitForElement(signInButton);
        signInButton.click();
    }
    private void setPhone(String emailText){
        performWaitForElement(phone);
        phone.sendKeys(emailText);
    }

    private void setContinue(){
        performWaitForElement(continueButton);
        continueButton.click();
    }

    private void setPassword(String passwordText){
        performWaitForElement(password);
        password.sendKeys(passwordText);
    }

    private void enterToLogin(){
        performWaitForElement(submitButton);
        submitButton.click();
    }


    /**
     * This POM method will be exposed in test case to log in  the application
     * @param email: user registered email
     * @param password: user registered password
     */

    public void login(String email,String password){
        this.setSignInButton();
        this.setPhone(email);
        this.setContinue();
        this.setPassword(password);
        this.enterToLogin();
    }

    public Home loginChaining(String phone,String password){
        this.setSignInButton();
        this.setPhone(phone);
        this.setContinue();
        this.setPassword(password);
        this.enterToLogin();
        return new Home(driver);
    }

}