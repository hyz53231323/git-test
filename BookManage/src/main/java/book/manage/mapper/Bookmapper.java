package book.manage.mapper;

import book.manage.entity.Book;
import book.manage.entity.Borrow;
import book.manage.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Bookmapper {
    @Insert("insert into student(name, sex, grade) values(#{name},#{sex},#{grade})")
    int addStudent(Student student);

    @Insert("insert into book(bid, title, `desc`, price) values(#{bid},#{title},#{desc} ,#{price})")
    int addBook(Book book);

    @Insert("insert into borrow(sid,bid) values(#{sid},#{bid})")
    int addBorrow(@Param("sid")int sid, @Param("bid") int bid);
@Results({
        @Result(column = "id",property = "id",id = true),
        @Result(column = "sid",property = "student",one = @One(select = "getStudentBysid")),
        @Result(column = "bid",property = "book",one = @One(select = "getBookBybid"))
})
@Select("select * from borrow")
    List<Borrow> getBorrowList();

@Select("select * from student")
    List<Student>getStudentList();

@Select("select * from book")
 List<Book>getBookList();

@Select("select * from student where sid = #{sid}")
    Student getStudentBysid(int sid);

    @Select("select * from book where bid = #{bid}")
    Book getBookBybid(int bid);


}
