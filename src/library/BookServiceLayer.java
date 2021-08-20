
package library;

import java.util.ArrayList;
public class BookServiceLayer {
    public void addBook(String title,String author,String language,String pages,String type){
          title = title.toLowerCase();
          author = author.toLowerCase();
          language = language.toLowerCase();
          type = type.toLowerCase();
          new DataAccessObject().insertBookinDataBase(title, author, language, pages, type);
    }
    public static ArrayList<Book> getBookInfo(){
        return new DataAccessObject().SelectBooks();  
    }
}
