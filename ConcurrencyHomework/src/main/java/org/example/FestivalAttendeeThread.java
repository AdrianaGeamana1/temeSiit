package org.example;

import java.util.Random;

public class FestivalAttendeeThread extends Thread{
    private FestivalGate gate;
    private TicketType ticketType;

    public FestivalAttendeeThread(FestivalGate gate,TicketType ticketType){
        this.gate=gate;
        this.ticketType=ticketType;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public void run() {
        TicketType ticketTypeForRun=this.getTicketType();
        if(this.validateTicket(ticketTypeForRun)) {
            this.gate.addData(ticketTypeForRun);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public boolean validateTicket(TicketType tkt) {
        for (TicketType t : TicketType.values()){
            if (tkt.getId().equals(t.getId())) {
                return true;
            }
        }
        return false;
    }
}
