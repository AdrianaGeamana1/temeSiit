package org.example;

public class AthletesResults implements Comparable<AthletesResults>{
    private int athleteNumber;
    private String athleteName;

    private String skiTimeResult;

    private String finalStanding;
    private int totalPenalty;

    public AthletesResults(int athleteNumber,String athleteName, String skiTimeResult, String finalStanding, int totalPenalty) {
        this.athleteNumber=athleteNumber;
        this.athleteName = athleteName;
        this.skiTimeResult = skiTimeResult;
        this.finalStanding = finalStanding;
        this.totalPenalty = totalPenalty;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }
@Deprecated
    public String getFinalStanding() {
        return finalStanding;
    }

    public int getTotalPenalty() {return totalPenalty;}
    public int compareTo(AthletesResults other) {
        String[]str1=this.finalStanding.split(":");
        String[]str2=other.finalStanding.split(":");
        if (Integer.parseInt(str1[0])<Integer.parseInt(str2[0])) {
            return -1;
        }
        if (Integer.parseInt(str1[0])==Integer.parseInt(str2[0])&&Integer.parseInt(str1[1])<Integer.parseInt(str2[1])) {
            return -1;
        }
        if (Integer.parseInt(str1[0])>Integer.parseInt(str2[0])) {
            return 1;
        }
        if (Integer.parseInt(str1[0])==Integer.parseInt(str2[0])&&Integer.parseInt(str1[1])>Integer.parseInt(str2[1])) {
            return 1;
        }

        return 0;
    }
}
