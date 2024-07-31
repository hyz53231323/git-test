package book.manage;

import book.manage.entity.Book;
import book.manage.entity.Student;
import book.manage.sql.SqlUtil;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

@Log
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));

            while (true) {
                System.out.println("====================");
                System.out.println("1.录入学生信息");
                System.out.println("2.录入书籍信息");
                System.out.println("3.添加借阅信息");
                System.out.println("4.查询借阅信息");
                System.out.println("5.查询学生信息");
                System.out.println("6.查询书籍信息");
                System.out.println("输入您想要的操作,输入其他任意数字退出：");

                int input;
                try {
                    input = scanner.nextInt();

                } catch (Exception e) {
                    return;
                }
                scanner.nextLine();
                switch (input) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        addBook(scanner);
                        break;
                    case 3:
                        addBorrow(scanner);
                        break;
                    case 4:
                        showBorrow();
                        break;
                    case 5:
                        getStudentList();
                        break;
                    case 6:
                        getBookList();
                        break;
                    default:
                        return;
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void getStudentList(){
        SqlUtil.doSqlwork(bookmapper -> {
            bookmapper.getStudentList().forEach(System.out::println);
        });
    }

    public static void getBookList(){
        SqlUtil.doSqlwork(bookmapper -> {
            bookmapper.getBookList().forEach(System.out::println);
        });
    }

    public static void showBorrow(){
        SqlUtil.doSqlwork(bookmapper -> {
            bookmapper.getBorrowList().forEach(System.out::println);

        });
    }
    public static void addBorrow(Scanner scanner){
        System.out.println("请输入学生id：");
        int sid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入书籍id");
        int bid = scanner.nextInt();
        scanner.nextLine();
        SqlUtil.doSqlwork(bookmapper -> {
            int i = bookmapper.addBorrow(sid,bid);
            if(i>0){
                System.out.println("借阅信息添加成功!");
            }
        });

    }
    public static void addStudent(Scanner scanner){

        System.out.println("请输入学生名字：");
        String name=scanner.nextLine();
        System.out.println("请输入学生性别(男/女)：");
        String sex=scanner.nextLine();
        System.out.println("请输入学生年级：");
        String grade=scanner.nextLine();
        int g = Integer.parseInt(grade);
        Student student = new Student(name,sex,g);
        SqlUtil.doSqlwork(mapper->{
           int i = mapper.addStudent(student);
           if(i>0){
               System.out.println("学生信息录入成功!");
               log.info("新添加了一条学生信息!"+student);
           }
        } );



    }

    public static void addBook(Scanner scanner){

        System.out.print("请输入书籍号：");
        String bid =scanner.nextLine();
        int i = Integer.parseInt(bid);


        System.out.print("请输入书籍名称：");
        String title=scanner.nextLine();

        System.out.print("请输入书籍简介：");
        String desc =scanner.nextLine();

        System.out.print("请输入书籍价格：");
        double price =scanner.nextDouble();
        scanner.nextLine();

        Book book= new Book(i,title,desc,price);
        SqlUtil.doSqlwork(mapper->{
            int k = mapper.addBook(book);
            if(k>0){
                System.out.println("书籍信息录入成功!");
                log.info("新添加了一条书籍信息!"+book);
            }
        } );



    }
}

