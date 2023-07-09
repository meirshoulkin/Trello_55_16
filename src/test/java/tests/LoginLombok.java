package tests;

import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLombok extends TestBase{

    @Test
    public void positiveLoginTest(){
        UserLombok userLombok = UserLombok.builder().email("or220719@gmail.com").password("12345%QWqw").build();
        logger.info("Test login posit1----"+userLombok.getEmail()+""+userLombok.getPassword());
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(userLombok);
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']")));
        logger.info("Logged----");

    }
    @Test
    public void negativePasswordLoginTest(){
        UserLombok userLombok = UserLombok.builder().email("or220719@gmail.com").password("12345%QWqw").build();
        logger.info("");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7"));
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        Assert.assertTrue(app.getUserHelper()
                .isElementPresent(By.xpath("//span[contains(text(),'Incorrect email address and / or password. If you ')]")));

    }
}
