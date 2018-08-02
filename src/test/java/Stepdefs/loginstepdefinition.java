package Stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.hook;

public class loginstepdefinition {
    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String arg0) throws Throwable {
       System.setProperty("webdriver.chrome.driver","C:\\SDET University\\Software\\chromedriver.exe");
        hook.driver = new ChromeDriver();
        hook.driver.get("https://dev.giftrt.com/login/");
        //throw new PendingException();
    }

    @And("^I click on Login \"([^\"]*)\"$")
    public void iClickOnLogin(String arg0) throws Throwable {
        hook.driver.findElement(By.linkText("Login")).click();
        //throw new PendingException();
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void iEnterEmail(String email) throws Throwable {
        hook.driver.findElement(By.id("email")).sendKeys(email);
        //throw new PendingException();
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password) throws Throwable {
        hook.driver.findElement(By.cssSelector("#password")).sendKeys(password);
        //throw new PendingException();
    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String arg0) throws Throwable {
        hook.driver.findElement(By.cssSelector("#login-form > div.buttons-holder.text-center > button")).click();
       // throw new PendingException();
    }

    @Then("^I should be signed in$")
    public void iShouldBeSignedIn() throws Throwable {
       // Assert.assertTrue(hook.driver.findElement(By.cssSelector("body > div.wrapper > nav.top-bar.animate-dropdown.hidden-xs > div > div > div.col-xs-12.col-sm-7.no-margin > ul > li.dropdown > a")).isDisplayed());
       String message = hook.driver.findElement(By.cssSelector("body > div.wrapper > nav.top-bar.animate-dropdown.hidden-xs > div > div > div.col-xs-12.col-sm-7.no-margin > ul > li.dropdown > a")).getText();
        System.out.println("CONFIRMATION: " + message);
        hook.driver.close();
        // throw new PendingException();
    }

    @And("^I enter invalid password \"([^\"]*)\"$")
    public void iEnterInvalidPassword(String invalid) throws Throwable {
        hook.driver.findElement(By.cssSelector("#password")).sendKeys(invalid);

        // throw new PendingException();
    }

    @Then("^error \"([^\"]*)\" is diplayed$")
    public void errorIsDiplayed(String arg0) throws Throwable {
       String message = hook.driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]")).getText();
               System.out.println("CONFIRMATION:" + message);
               hook.driver.close();
        //throw new PendingException();
    }



}
