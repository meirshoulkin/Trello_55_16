package tests;

import models.Board;
import models.BoardLombok;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationLombok extends TestBase{
    @BeforeMethod
    public void preConditions(){
        if(!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))){
            app.getUserHelper().login();
        }
    }
    @Test
    public void boardCreationTest() {
        BoardLombok boardLombok = BoardLombok.builder().name("AAAA").build();
        app.getUserHelper().pause(1000);
        //  int before = app.getBoardHelper().NumberBoards();
        app.getBoardHelper().pressCreateButton();
        app.getUserHelper().pause(3000);
        app.getBoardHelper().fillBoardForm(boardLombok);
        app.getBoardHelper().submitCreate();
        app.getUserHelper().pause(3000);
        app.getBoardHelper().pressBoard();
        app.getUserHelper().pause(2000);
        int after = app.getBoardHelper().NumberBoards();
        app.getUserHelper().pause(3000);
    }
}
