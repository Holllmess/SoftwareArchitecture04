package Seminar04;

public class BusStation {

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public boolean checkQRcode(String qrcode){
        return ticketProvider.checkTicket(qrcode);
    }
}
