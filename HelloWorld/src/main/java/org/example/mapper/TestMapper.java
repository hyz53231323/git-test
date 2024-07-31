package org.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.entity.Student;

public interface TestMapper {
    @Select("select * from student where sid = #{sid}")
    public Student getStudentbysid(int sid);
}
