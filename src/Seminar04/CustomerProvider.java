package Seminar04;

public class CustomerProvider {
    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password){
        return database.getCustomers().stream().findFirst().get();
    }
}
