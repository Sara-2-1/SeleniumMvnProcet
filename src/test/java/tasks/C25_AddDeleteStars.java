package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C25_AddDeleteStars extends TestBase {

    /*
        Go to https://claruswaysda.github.io/addDeleteStar.html
        Create a method to add given number of stars
        Create a method to delete given numbers of stars
        Create a method to verify the given number of stars deleted
    */

    @Test
    void addDeleteStarsTest() {

//        Go to https://claruswaysda.github.io/addDeleteStar.html
        driver.get("https://claruswaysda.github.io/addDeleteStar.html");

        int addedStars = addStars(5);
        int deletedStars = deleteStars(2);
        assert remainingStarsValidate(addedStars, deletedStars);

    }

    //        Create a method to add given number of stars
    int addStars(int numOfStars) {
        WebElement starButton = driver.findElement(By.id("push-button"));
        for (int i = 0; i < numOfStars; i++) {
            starButton.click();
        }
        return numOfStars;
    }

    //        Create a method to delete given numbers of stars
    int deleteStars(int numOfStars) {
        WebElement deleteButton = driver.findElement(By.id("delete-button"));
        for (int i = 0; i < numOfStars; i++) {
            deleteButton.click();
        }
        return numOfStars;
    }

    //        Create a method to verify the given number of stars deleted
    boolean remainingStarsValidate(int addedStars, int deletedStars) {
        return addedStars - deletedStars == driver.findElements(By.xpath("//div[@class='star']")).size();
    }


}
