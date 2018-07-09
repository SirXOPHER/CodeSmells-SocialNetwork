import java.util.ArrayList;

public class Context {

    private ArrayList<User> userList;
    private ArrayList<Posting> postingList;

    public Context() {
        this.userList =  new ArrayList<User>();
        this.postingList = new ArrayList<Posting>();
    }

    public void addUser(String userName) {
        boolean existing = false;
        if (!userList.isEmpty()) {
            for (User u : userList) {
                if (u.getName().equals(userName)) {
                    existing = true;
                    break;
                }
            }
        }
        if (!existing) {
            userList.add(new User(userName));
        }
    }

    public void addPosting(String authorName, String messageContent) {
        postingList.add(new Posting(authorName, messageContent));
    }

    public void readPostings(String userName) {
        boolean existing = false;
        if (!userList.isEmpty()) {
            for (User u : userList) {
                if (u.getName().equals(userName)) {
                    existing = true;
                    break;
                }
            }
        }
        if (!existing) {
            System.out.println(invalidInputMessenger(userName, 1));
        } else {
            for (int index = postingList.size() - 1; index >= 0; index--) {
                if(postingList.get(index).getAuthorName().equals(userName)) {
                    System.out.println(postingList.get(index).getMessage() +
                            " (" + "Timestamp not implemented yet!" + ")");
                }
            }
        }
    }

    public void follow(String userName, String followeeName) {
        boolean existing = false;
        if (!userList.isEmpty()) {
            for (User u : userList) {
                if (u.getName().equals(userName)) {
                    existing = true;
                    break;
                }
            }
        }
        boolean existingFollowee = false;
        if (!userList.isEmpty()) {
            for (User u : userList) {
                if (u.getName().equals(userName)) {
                    existingFollowee = true;
                    break;
                }
            }
        }
        if (!existing) {
            System.out.println(invalidInputMessenger(userName, 1));
        } else if (!existingFollowee) {
            System.out.println(invalidInputMessenger(userName, 2));
        } else {
            User subscriber = null;
            User followee = null;
            for (User u : userList) {
                if (u.getName().equals(userName)) {
                    subscriber = u;
                }
                if (u.getName().equals(followeeName)) {
                    followee = u;
                }
            }
            subscriber.addSubscription(followee);
        }
    }

    public void printWall(String userName) {
        // not yet implemented
    }

    public String invalidInputMessenger(String userName, int errorCase) {
        String message;
        switch (errorCase) {
            // case 1: invalid user
            case 1:  message = "User \"" + userName + "\" doesn't exist yet." +
                    " Users are created as they post their first message.";
                break;
            // case 2: invalid followee
            case 2:  message = "User \"" + userName + "\" can't be followed as she/he doesn't exist yet." +
                    " Users are created as they post their first message.";
                break;
            default: message = "Undefined error";
                break;
        }
        return message;
    }
}