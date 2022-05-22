package service.impl;

import dao.BookDao;
import entity.Book;
import entity.PageBean;
import service.UserService;

import java.util.List;

/**
 * @author Komorebi
 * @date 2022.05.19.18:04
 */
public class UserServiceImpl implements UserService {

    @Override
    public PageBean<Book> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);


        //1.创建空的PageBean对象
        PageBean<Book> pb = new PageBean<Book>();

        //3.调用dao查询总记录数
        BookDao dao = new BookDao();
        int totalCount  = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //5.计算总页码
        int totalPage = (int) Math.ceil(totalCount*1.0/rows);
        pb.setTotalPage(totalPage);

        // if(currentPage <= 0){
        //     currentPage=1;
        // }
        // if(currentPage >totalPage){
        //     currentPage=totalPage;
        // }
        //2.设置参数
        pb.setCurrentPage(currentPage);//移到最后
        pb.setRows(rows);

        //4.调用dao查询list集合
        int start = (currentPage-1)*rows;
        List<Book> list = dao.findByPage(start,rows);
        pb.setList(list);


        return pb;
    }
}
