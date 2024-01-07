package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class FestivalGate {
    private Queue<TicketType>gateList;
    private boolean available=false;

    public FestivalGate() {
        this.gateList =new PriorityQueue<>();
    }

    public synchronized void addData(TicketType t) {
        while (available) {
            try{wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        gateList.add(t);
        available=true;
        notifyAll();


    }

    public synchronized Queue<TicketType> getGateList() {
        while (!available){
            try {
                wait();
            }catch (InterruptedException e){
               e.printStackTrace();
            }

        }
        available=false;
        notifyAll();
        return gateList;
    }
}

