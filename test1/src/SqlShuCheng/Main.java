package SqlShuCheng;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("---- 欢迎来到智慧书城----");
            System.out.println("-----1.根据编号查询书籍---");
            System.out.println("-----2.查询所有书籍------");
            System.out.println("-----3.删除指定编号书籍---");
            System.out.println("-----4.退出系统-----  --");

            int sb= sc.nextInt();

            if (sb ==1){
                System.out.println("请输入编号：");
                int id = sc.nextInt();
                findBookById(id);
            }

            if (sb ==2){
                findAllBook();
            }

            if(sb ==3){
                System.out.println("请输入编号：");
                int id = sc.nextInt();
                deleteById(id);

            }

            if(sb ==4){
                break;
            }
        }

    }
    public  static void  findBookById(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","Y20011022B");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book where id = " + id);
        while(resultSet.next()){
            System.out.println("编号="+resultSet.getInt("id")+" 书名="+resultSet.getString("name")+" 作者="+resultSet.getString("author")+" 价格="+resultSet.getDouble("price"));

        }
        statement.close();
        connection.close();
    }

    public static void findAllBook() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","Y20011022B");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book ");
        while(resultSet.next()){
            System.out.println("编号="+resultSet.getInt("id")+" 书名="+resultSet.getString("name")+" 作者="+resultSet.getString("author")+" 价格="+resultSet.getDouble("price"));
        }
        statement.close();
        connection.close();
    }

    public static void deleteById(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","Y20011022B");
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from book where id ="+ id);

        statement.close();
        connection.close();
    }

}

