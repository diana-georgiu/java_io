package javaio;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Athlete> lst = ReaderWriter.readAthletes("src/main/resources/input.csv");
        SkiBiathlon ski = new SkiBiathlon(lst);

        List<Athlete> myList, winnersList;
        ski.orderByFinalTime();

        myList = ski.assignStandings();

        winnersList = ski.getWinners(myList);

        ski.printWinners(winnersList);
        }

}
