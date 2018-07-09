public class Posting {

    private String authorName;
    private String message;
    // missing field: timestamp;

    public Posting(String authorName, String message) {
        this.authorName = authorName;
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getMessage() {
        return message;
    }
}