package test;

import lombok.Data;

@Data
public class Student {
    int sid;
    String name;
    String sex;
    Teacher teacher;
}
