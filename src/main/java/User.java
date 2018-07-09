import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<User> subscriptions;

    public User(String name) {
        this.name = name;
        this.subscriptions = new ArrayList<User>();
        this.subscriptions.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubscription(User followeeToAdd) {
        subscriptions.add(followeeToAdd);
    }

    public ArrayList<User> getSubscriptions() {
        return subscriptions;
    }
}