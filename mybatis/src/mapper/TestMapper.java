package mapper;

import org.apache.ibatis.annotations.Insert;
import test.Student;

public interface TestMapper {
    @Insert("insert into student(name, sex) values(#{name}, #{sex})")
    int addStudent(Student student);
}
