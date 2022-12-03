package Seminar04;

import java.util.Date;

public class MobileApp {

    private final Customer customer;
    private final TicketProvider ticketProvider;

    public MobileApp(CustomerProvider customerProvider, TicketProvider ticketProvider) {
        customer = customerProvider.getCustomer("Spice", "0001");
        this.ticketProvider = ticketProvider;
    }

    public void searchTicket(Date date){
        customer.setTickets(ticketProvider.searchTickets(customer.getId(), new Date()));
    }

    public boolean buyTicket(String cardNo){
        return ticketProvider.buyTicket(customer.getId(), "1111333377772200");
    }
}
