package javaio;
import java.util.*;
import java.util.stream.Collectors;

public class SkiBiathlon {

    private List<Athlete> atList;

    public SkiBiathlon(List<Athlete> aList)
    {
        atList = aList;
    }

    public void orderByFinalTime()
    {
        Collections.sort(atList,
                        Comparator.comparing(Athlete::getFinalTime));
    }

    //assign a place to each athlete, cover also the case when several athletes are on the same place
    public List<Athlete> assignStandings()
    {
        int time = atList.get(0).getFinalTime();
        int st = 1;

        for(Athlete a: atList)
        {
            if (time == a.getFinalTime())
                a.setStanding(st);
            else
            {
                time = a.getFinalTime();
                st ++;
                a.setStanding(st);
            }
        }

        List<Athlete> copy = atList.stream().collect(Collectors.toList());
        return copy;
    }

    //return a list with the athletes on the first 3 places
    public List<Athlete> getWinners(List<Athlete> aList)
    {
        List<Athlete> resList = new ArrayList<>();
        for(Athlete a : aList)
        {
            int st = a.getStanding();
            if ((st == 1) || (st == 2) || (st == 3))
                resList.add(a);
        }
        return resList;
    }

    //print winners to the console and into a file & returns a list of strings
    public List<String> printWinners(List<Athlete> aList)
    {
        List<String> resList = new ArrayList<>();
       for(Athlete a: aList)
       {
           if(a.getStanding() == 1)
               resList.add("Winner: " + a);

           if(a.getStanding() == 2)
               resList.add("Runner-up: " + a);

           if(a.getStanding() == 3)
               resList.add("Third place: " + a);

       }

        resList.forEach(System.out::println);

       //call the function to write to the output file
        ReaderWriter.writeAthletes(resList);

        return resList;
    }
}
