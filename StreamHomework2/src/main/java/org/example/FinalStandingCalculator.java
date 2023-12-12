package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalStandingCalculator {
    private final List<AthletesResults>list=new ArrayList<>();
    public int getTotalPenalty(String firstShootingRange,String secondShootingRange,String thirdShootingRange) {
        int totalPenalty=0;
        char penalty='o';
        for(int i=0;i<firstShootingRange.length();i++) {
            if (firstShootingRange.charAt(i) == penalty) {
                totalPenalty += 10;
            }
        }
        for(int i=0;i<secondShootingRange.length();i++){
            if(secondShootingRange.charAt(i)==penalty){
                totalPenalty+=10;
            }
        }
        for(int i=0;i<thirdShootingRange.length();i++) {
            if (thirdShootingRange.charAt(i) == penalty) {
                totalPenalty += 10;
            }
        }
        return totalPenalty;
    }
    public String getFinalStanding(String skiTimeResult,int totalPenalty){
        String[]minSec=skiTimeResult.split(":");
        int min=Integer.parseInt(minSec[0]);
        int sec=Integer.parseInt(minSec[1]);
        sec+=totalPenalty;
        if(sec>60){
            int modulo=sec/60;
            min=min+modulo;
            sec=sec%60;
        }
        String min2=Integer.toString(min);
        String sec2=Integer.toString(sec);
        return min2+":"+sec2;

    }
    public List<AthletesResults> parsingInput(String path)throws IOException {
        BufferedReader bufferedReader=null;
        try{
            bufferedReader=new BufferedReader(new FileReader(path));
            String line;
            while((line= bufferedReader.readLine())!=null){
                String[]strings=line.split(",");
                int athleteNumber=Integer.parseInt(strings[0]);
                String athleteName=strings[1];
                String countryCode=strings[2];
                String skiTimeResult=strings[3];
                String firstShootingRange=strings[4];
                String secondShootingRange=strings[5];
                String thirdShootingRange=strings[6];
                int totalPenalty=this.getTotalPenalty(firstShootingRange,secondShootingRange,thirdShootingRange);
                String finalStanding=this.getFinalStanding(skiTimeResult,totalPenalty);
                list.add(new AthletesResults(athleteNumber,athleteName,skiTimeResult,finalStanding,totalPenalty));

            }

        }finally {
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }
      return list;
    }
    @SuppressWarnings({"supress"})
    public void printFinalResults() {
        Collections.sort(list);
        Winners[] winners = Winners.values();
        for (int i = 0; i < winners.length; i++) {
            System.out.println(winners[i].getName() + " - " + list.get(i).getAthleteName() + " " + list.get(i).getFinalStanding() + " (" + list.get(i).getSkiTimeResult() + " + " + list.get(i).getTotalPenalty() + ")");
        }
    }

}


