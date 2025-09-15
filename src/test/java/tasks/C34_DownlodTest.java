package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase ;

import java.nio.file.Files;
import java.nio.file.Path;

public class C34_DownlodTest extends TestBase  {
     /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on download
    Verify that 'QAProgram.png' file is downloaded
    */

    @Test
    void downloadTest() throws InterruptedException {
//        Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

//        Click on download
        driver.findElement(By.xpath("//a[@class ='download-btn']")).click();
        Thread.sleep(3000);


//        Verify that 'QAProgram.png' file is downloaded
        boolean isFile = Files.exists(Path.of("/Users/sarahali/Downloads/QAProgram.png"));
        System.out.println("isFile = " + isFile);
        Thread.sleep(3000);
        System.out.println("isFile = " + isFile);
        assert isFile;

    }




}
