package org.example;

public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (!this.gate.getGateList().isEmpty()&&this.gate.getGateList().size()<100) {

            int countOfFullTickets = 0;
            int countOfFullVipTickets = 0;
            int countOfFreePassTickets = 0;
            int countOfOneDayTickets = 0;
            int countOfOneDayVipTickets = 0;
            int totalPeople = 0;
            for (TicketType t : this.gate.getGateList()) {
                if (t.getName().equals("FULL")) {
                    totalPeople++;
                    countOfFullTickets++;
                }
                if (t.getName().equals("FULL_VIP")) {
                    totalPeople++;
                    countOfFullVipTickets++;
                }
                if (t.getName().equals("FREE_PASS")) {
                    totalPeople++;
                    countOfFreePassTickets++;
                }
                if (t.getName().equals("ONE_DAY")) {
                    totalPeople++;
                    countOfOneDayTickets++;
                }
                if (t.getName().equals("ONE_DAY_VIP")) {
                    totalPeople++;
                    countOfOneDayVipTickets++;
                }
            }
            System.out.println(totalPeople + " people entered");
            System.out.println(countOfFullTickets + " have full tickets");
            System.out.println(countOfFullVipTickets + " have full vip tickets");
            System.out.println(countOfFreePassTickets + " have free pass tickets");
            System.out.println(countOfOneDayTickets + " have one day tickets");
            System.out.println(countOfOneDayVipTickets + " have one day vip tickets");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}

