package SRP;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getSummary(){
        return this.title + " by " + this.author;
    }
}
