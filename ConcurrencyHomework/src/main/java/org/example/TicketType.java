package org.example;

public enum TicketType {
    FULL("FULL","F001"),FULL_VIP("FULL_VIP","FV002"),FREE_PASS("FREE_PASS","FP003"),ONE_DAY("ONE_DAY","OD004"),ONE_DAY_VIP("ONE_DAY_VIP","ODV005");
    private String name;
    private String id;

    TicketType(String name,String id) {
        this.name = name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
