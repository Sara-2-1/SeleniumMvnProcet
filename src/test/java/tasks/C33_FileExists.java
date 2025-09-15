package tasks;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C33_FileExists {


    @Test
    void fileExistsTest() {

        boolean isFileExist = Files.exists(Path.of(System.getProperty("user.dir") + "/files/test_doc.txt"));
        System.out.println("isFileExist = " + isFileExist);
        assert isFileExist;
    }

}
