package dao;

import entity.Book;
import utils.DBUtilPre;

import java.sql.*;
import java.util.*;

/**
 * @author Komorebi
 * @date 2022.05.05.20:06
 */
public class BookDao {
    DBUtilPre conn = new DBUtilPre();
    //查询图书列表
    public List<Book> findAll(){
        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from book_t";
        String[] params = {};
        ResultSet rs = conn.executeQueryRS(sql,params);
        Book book = null;
        try {
            while(rs.next()){
                book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setBookName(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeAll();
        }

        return bookList;
    }
    //图书新增方法
    public boolean addBook(String bookname,String author,String price){
        boolean result = false;
        String sql = "insert into book_t(bookname,author,price) value(?,?,?)";
        String[] params = {bookname,author,price};
        int colnum = conn.executeUpdate(sql,params);
        if(colnum!=0){
            result=true;
        }
        return result;
    }

    /**
     * 查询总记录数
     * @return
     */
    public int findTotalCount() {
        String sql = "select count(bookID) from book_t";
        return conn.executeQuery(sql);
    }

    /**
     * 分页查询每页数据
     * @param start
     * @param rows
     * @return
     */
    public List<Book> findByPage(int start, int rows) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from book_t limit ?,?";
        ResultSet rs = conn.executeQueryRS(sql,start,rows);
        try{
            while(rs.next()){
                Book book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setBookName(rs.getString("bookname"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.closeAll();
        }
        return list;
    }
}
