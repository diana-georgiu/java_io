package javaio;

public class Athlete {
    private Integer number;
    private String name;
    private String country;
    private String time;
    private int penalties;
    private int finalTime;
    private int standing;

    public Athlete(Integer number, String name, String country, String time, int penalties, int finalTime) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.penalties = penalties;
        this.finalTime = finalTime;
    }

    public int getFinalTime()
    {
        return this.finalTime;
    }

    public String getStringFinalTime()
    {
        float m1 = finalTime / 60;
        int min = (int) m1;
        int sec = finalTime - min * 60;
        String res = min + ":" + sec;

        return res;
    }

    public int getStanding() { return standing; }

    public void setStanding(int standing)
    {
        this.standing = standing;
    }

    @Override
    public String toString() {
        return  "{" +
                " number = " + number +
                " name = '" + name +
                "' country = '" + country +
                "' final time = " + getStringFinalTime() +
                " (actual time = " + time +
                ", penalties = " + penalties + " seconds )" +
                " }";
    }
}
