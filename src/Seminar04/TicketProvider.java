package Seminar04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {
    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    /**
     * Реализует поиск билетов в рамках некой базы данных по ID клиента и дате.
     * @param clientID - ID клиента;
     * @param date -  текущая дата;
     * @return коллекцию билетов.
     */
    public Collection<Ticket> searchTickets(int clientID, Date date){
        Collection<Ticket> tickets = new ArrayList<>();

        //TODO: Предусловие
        if (database.getTickets().isEmpty()){
            throw new RuntimeException("No available tickets. The Database is empty.");
        }
        if (clientID < 1){
            throw new RuntimeException("Incorrect clientID. Try again :) ");
        }

        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerID() == clientID && ticket.getDate().equals(date)){
                tickets.add(ticket);
            }
        }
        //TODO: Инвариант
        validateCollection(tickets);

        //TODO: Постусловие
        if (tickets.isEmpty()){
            throw new RuntimeException("No available tickets for you.");
        }
        return tickets;
    }

    /**
     * Позволяет совершить покупку через обращение к PaymentProvider.
     * @param clientID - ID клиента;
     * @param cardNo - номер банковской карты клиента;
     * @return - булевое значение true/false.
     */
    public boolean buyTicket(int clientID, String cardNo){
        int orderID = database.createTicketOrder(clientID);
        double amount = database.getTicketAmount();

        //TODO: Предусловие
        if (orderID < 1){
            throw new RuntimeException("Incorrect orderID.");
        }
        //Например, нам известно, что билет не может стоить меньше 35 денежных едениц.
        if (amount < 35){
            throw new RuntimeException("The price is incorrect.");
        }

        return paymentProvider.buy(orderID, cardNo, amount);
    }

    /**
     * Реализует проверку корректности и валидности QRCode.
     * @param qrcode - QRCode билета;
     * @return - булевое значение true/false.
     */
    public boolean checkTicket(String qrcode){

        //TODO: Предуслвоие
        if (qrcode.length() < 4){
            throw new RuntimeException("Incorrect QRCode.");
        }

        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                return true;
            }
        }
        return false;
    }

    private void validateCollection(Collection<Ticket> tic){
        if (tic.size() == 0){
            throw new RuntimeException("No available tickets.");
        }
    }
}
