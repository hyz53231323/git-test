package shucheng;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File f = new File("D:\\test.txt");
        ArrayList list = new ArrayList();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("----欢迎来到智慧书城----");
            System.out.println("-----1.展示书籍-------");
            System.out.println("-----2.上架书籍-------");
            System.out.println("-----3.删除书籍-------");
            System.out.println("-----4.退出系统-------");

            int sb= sc.nextInt();

            if (sb ==1){
                if(f.exists()){
                    FileInputStream f1 = new FileInputStream(f);
                    ObjectInputStream f2 = new ObjectInputStream(f1);

                    ArrayList list1 = (ArrayList) f2.readObject();

                    for(int i=0;i<=list1.size()-1;i++){
                        Book B =(Book)list1.get(i);
                        System.out.println(B.getId()+"--"+B.getName()+"---"+B.getAuthor());
                    }
                }else{
                    System.out.println("还没有新书籍");
                }

            }

            if (sb ==2){

                Book book = new Book();

                System.out.println("请输入书籍编号：");
                int a= sc.nextInt();
                book.setId(a);
                System.out.println("请输入书籍名称：");
                String b =sc.next();
                book.setName(b);
                System.out.println("请输入书籍作者：");
                String c = sc.next();
                book.setAuthor(c);
                list.add(book);

                FileOutputStream file = new FileOutputStream(f);
                ObjectOutputStream file1 = new ObjectOutputStream(file);
                file1.writeObject(list);
            }

            if(sb ==3){
                System.out.println("请输入要删除的书籍编号:");
                int a=sc.nextInt();
                FileInputStream f1 = new FileInputStream(f);
                ObjectInputStream f2 = new ObjectInputStream(f1);
                ArrayList list2 = (ArrayList) f2.readObject();


                for(int i=0;i<=list2.size()-1;i++){
                    Book b = (Book)list2.get(i);
                    if(a==b.getId()){
                        list2.remove(i);
                        break;
                    }
                }
                FileOutputStream file = new FileOutputStream(f);
                ObjectOutputStream file1 = new ObjectOutputStream(file);
                file1.writeObject(list2);
                file1.close();

            }

            if(sb ==4){
                break;
            }
        }

    }
}

