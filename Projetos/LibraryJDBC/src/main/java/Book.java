public class Book {

    private String title;
    private String author;
    private AvailableStatus available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = AvailableStatus.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public AvailableStatus getAvailable() {
        return available;
    }

    public void setAvailable(AvailableStatus available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author +
                ", Status: " + available;
    }
}