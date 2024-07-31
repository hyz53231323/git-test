public class Student extends Person implements  Cloneable{
     public String name;
    public int age;
    public String sex;

    public Student(String name, int age, String sex) {
        super(name, age, sex);
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    void study(){
        System.out.println("我在学习");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {   //提升clone方法的访问权限
        return super.clone();
    }//因为底层是C++实现，我们直接调用父类的实现就可以了

    @Override
    public String toString() {
        return "姓名："+name+" "+"年龄"+age+"性别"+sex;
    }

    private Status status;   //类型变成刚刚定义的枚举类

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
