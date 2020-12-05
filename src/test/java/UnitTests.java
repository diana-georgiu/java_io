import javaio.*;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import java.io.IOException;
import java.util.*;

public class UnitTests {

    @Test
    public void testReadAthletes()
    {
        List<Athlete> outcomeList = ReaderWriter.readAthletes("src/main/resources/input.csv");
        String outcomeString = outcomeList.toString();

        List<String> expectedLines = new ArrayList<>();

        try{
            expectedLines = Files.readAllLines(Paths.get("src/main/resources/expected_all.csv"));
        }catch(IOException ex){
            ex.printStackTrace();
        }

        String expectedString = expectedLines.toString();

        Assert.assertEquals(outcomeString, expectedString);
    }

    @Test
    public void testWriteWinners()
    {
        //compare the content of the output file containing the winners with the file containing the expected result

        List<String> actualLines = new ArrayList<>();
        try{
            actualLines = Files.readAllLines(Paths.get("src/main/resources/output/output_winners.csv"));
        }catch(IOException ex){
            ex.printStackTrace();
        }

        List<String> expectedLines = new ArrayList<>();
        try{
            expectedLines = Files.readAllLines(Paths.get("src/main/resources/expected_winners.csv"));
        }catch(IOException ex){
            ex.printStackTrace();
        }

        Assert.assertEquals(actualLines, expectedLines);
    }
}
