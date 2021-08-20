
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObject {
    private Connection con;
    static{
        try {
            // loading driver only once into the ram 
            // jvm will internally create the object of driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public DataAccessObject(){
         //connecting to the database
         String url = "jdbc:mysql://localhost:3306/library";
         String user = "root";
         String password = "safu05";
        try {
            con = DriverManager.getConnection(url, user, password);
           
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertBookinDataBase(String title,String author,String language,String pages,String type){
        // ? means we will insert the values later    
        String query = "insert into book(title,author,language,pages,type) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,title);
            ps.setString(2,author);
            ps.setString(3,language);
            ps.setString(4,pages);
            ps.setString(5,type);
            //execute DML query
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try {
                //closing connection
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
// Retrieve the Data from the DataBase    
    public ArrayList<Book> SelectBooks(){
        ArrayList<Book> book = new ArrayList<>();
        String query = "select * from book";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            //execute the DQL query
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String title = rs.getString(1);
                String author = rs.getString(2);
                String language = rs.getString(3);
                String pages = rs.getString(4);
                String type = rs.getString(5);
                book.add(new Book(title, author, language, pages, type));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return book;
    }        
}
        

