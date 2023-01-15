package ua.edu.sumdu.ponomarenko.models;

public class OrderAccount {
    //order_customer_fk
    private Orders orderCustomerFK;
    //account_executor_fk
    private Account accountExecutorFK;

    public OrderAccount() {
    }

    public OrderAccount(Orders orderCustomerFK, Account accountExecutorFK) {
        this.orderCustomerFK = orderCustomerFK;
        this.accountExecutorFK = accountExecutorFK;
    }

    public Orders getOrderCustomerFK() {
        return orderCustomerFK;
    }

    public void setOrderCustomerFK(Orders orderCustomerFK) {
        this.orderCustomerFK = orderCustomerFK;
    }

    public Account getAccountExecutorFK() {
        return accountExecutorFK;
    }

    public void setAccountExecutorFK(Account accountExecutorFK) {
        this.accountExecutorFK = accountExecutorFK;
    }
}
