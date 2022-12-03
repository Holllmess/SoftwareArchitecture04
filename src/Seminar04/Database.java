package Seminar04;

import java.util.ArrayList;
import java.util.Collection;

public class Database {

    private static int counter;
    private Collection<Customer> customers = new ArrayList<>();
    private Collection<Ticket> tickets = new ArrayList<>();

    public int createTicketOrder(int clientID){
        return ++counter;
    }

    public double getTicketAmount(){
        return 45;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }
}
