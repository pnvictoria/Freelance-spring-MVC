package ua.edu.sumdu.ponomarenko.models;

public class Orders {
    private int orderId;
    private String titleOrder;
    private String descriptionOrder;
    private int price;
    private int account;

    public Orders() {
    }

    public Orders(int orderId) {
        this.orderId = orderId;
    }

    public Orders(int orderId, String titleOrder, String descriptionOrder,
                  int price, int account) {
        this.orderId = orderId;
        this.titleOrder = titleOrder;
        this.descriptionOrder = descriptionOrder;
        this.price = price;
        this.account = account;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTitleOrder() {
        return titleOrder;
    }

    public void setTitleOrder(String titleOrder) {
        this.titleOrder = titleOrder;
    }

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    public void setDescriptionOrder(String descriptionOrder) {
        this.descriptionOrder = descriptionOrder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", titleOrder='" + titleOrder + '\'' +
                ", descriptionOrder='" + descriptionOrder + '\'' +
                ", price=" + price +
                ", account=" + account +
                '}';
    }
}
