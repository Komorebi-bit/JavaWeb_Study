package service;

import entity.Book;
import entity.PageBean;

/**
 * @author Komorebi
 * @date 2022.05.19.18:05
 */
public interface UserService {
    /**
     * 分页查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<Book> findUserByPage(String currentPage, String rows);
}
