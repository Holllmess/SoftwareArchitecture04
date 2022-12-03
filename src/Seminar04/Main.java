package Seminar04;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Core core = new Core();

        MobileApp mobileApp = new MobileApp(core.getCustomerProvider(), core.getTicketProvider());
        mobileApp.searchTicket(new Date());
        mobileApp.buyTicket("4444111144441111");

        BusStation busStation = new BusStation(core.getTicketProvider());
        busStation.checkQRcode("simpleQRCode");
    }
}
