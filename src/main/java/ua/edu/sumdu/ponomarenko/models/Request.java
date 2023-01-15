package ua.edu.sumdu.ponomarenko.models;

public class Request {
    private int requestId;
    private int account;
    private Orders order;
    private String requestDescription;

    public Request() {
    }

    public Request(int account) {
        this.account = account;
    }

    public Request(int requestId, int account, Orders order, String requestDescription) {
        this.requestId = requestId;
        this.account = account;
        this.order = order;
        this.requestDescription = requestDescription;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", account=" + account +
                ", order=" + order +
                ", requestDescription='" + requestDescription + '\'' +
                '}';
    }
}
