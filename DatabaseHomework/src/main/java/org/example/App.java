package org.example;

import dao.RoomFareDao;
import model.Accommodation;
import model.RoomFare;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Accommodation accommodation=new Accommodation("apartment","double_bed",5,"1 tv,1 bathroom,AC,2 beds");
        RoomFare roomFare =new RoomFare(500.23,"peak_season");
        RoomFare roomFare2 =new RoomFare(350.23,"off_peak_season");
        RoomFare roomFare3 =new RoomFare(550.23,"special_events");
        RoomFare roomFare4=new RoomFare(300.23,"day_of_the_week");
        RoomFare roomFare5=new RoomFare(200.23,"advance_booking");
        List<RoomFare>roomFareList=new ArrayList<>();
        roomFareList.add(roomFare);
        roomFareList.add(roomFare2);
        roomFareList.add(roomFare3);
        roomFareList.add(roomFare4);
        roomFareList.add(roomFare5);

        Test test=new Test();
        test.insertTest(accommodation,roomFareList);
        UnitTest unitTest=new UnitTest();
        unitTest.interrogateUnitTest();
    }
}