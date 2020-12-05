package javaio;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ReaderWriter {

    public static List<Athlete> readAthletes(String source)
    {
        List<Athlete> aList = new ArrayList<>();
        Path path = Paths.get(source);
        List<String> inputLines = new ArrayList<>();

        try{
            inputLines = Files.readAllLines(path);
        }catch(IOException ex){
            ex.printStackTrace();
        }

        for(String line: inputLines)
        {
            String[] ln = line.split(",");

            String str = ln[4] + ln[5] + ln[6];

            int count = (int) str.chars().filter(ch -> ch == 'o').count();

            String[] time = ln[3].split(":");

            Duration mins = Duration.ofMinutes(Integer.parseInt(time[0]));
            float sec = mins.getSeconds();
            float finalTime1 = sec + Integer.parseInt(time[1]);
            float finalTime2 = finalTime1 + count * 10;
            int ft = (int)finalTime2;

            Athlete at = new Athlete(Integer.parseInt(ln[0]), ln[1], ln[2], ln[3], count * 10, ft);

            aList.add(at);

        }

        return aList;
    }

    public static void writeAthletes(List<String> aList)
    {
        BufferedWriter bw = null;
        try {
            File dir = new File("src/main/resources/output");
            dir.mkdir();
            File file = new File(dir, "output_winners.csv");
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for(String a: aList)
                bw.write(a + "\n");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try {
                if(bw!=null)
                    bw.close();
            } catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }

    }
}
