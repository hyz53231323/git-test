package mapper;

import entity.Book;

import java.util.List;

public interface bookMapper {
    public abstract List selectAllBook();
    Book selectOneBook(String name);

    int insertBook(Book book);

    int deleteBookById(int id);

    int updateBook(int id,double price);
}
