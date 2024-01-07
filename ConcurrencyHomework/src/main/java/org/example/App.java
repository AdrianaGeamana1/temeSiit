package org.example;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        Random random = new Random();
        TicketType[] ticketTypes = TicketType.values();
        List<FestivalAttendeeThread> threadList = Stream.iterate(1, i -> i + 1)
                    .limit(100)
                    .map(e -> {
                        TicketType t = ticketTypes[random.nextInt(ticketTypes.length)];
                        return new FestivalAttendeeThread(gate,t);
                    })
                    .collect(Collectors.toList());
        FestivalStatisticsThread festivalStatisticsThread=new FestivalStatisticsThread(gate);
        threadList.forEach(e -> e.start());
        festivalStatisticsThread.start();
       threadList.forEach(e -> {
           try {
               e.join();
           } catch (InterruptedException ex) {
               throw new RuntimeException(ex);
           }
       });
       festivalStatisticsThread.join();

    }
}
