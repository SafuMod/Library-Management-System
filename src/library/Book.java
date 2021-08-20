
package library;
public class Book {
    private String title;
    private String author;
    private String language;
    private String pages;
    private String type;

    public Book(String title, String author, String language, String pages, String type) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.pages = pages;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public String getPages() {
        return pages;
    }

    public String getType() {
        return type;
    }
    
    
}
