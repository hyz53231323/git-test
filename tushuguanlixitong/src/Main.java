import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;




public class Main  {

    private static List<Book> LIST ;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("正在初始化图书管理系统");
        load();
        Scanner scanner = new Scanner(System.in);
        System.out.println("====图书管理系统====");
        while (true) {

            System.out.println("1. 录入书籍信息");
            System.out.println("2. 查阅书籍信息");
            System.out.println("3. 删除书籍信息");
            System.out.println("4. 修改书籍信息");
            System.out.println("5. 退出系统");
            System.out.println("==================");


            switch(scanner.nextInt()) {
                case 1:
                    insert(scanner);
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    delete(scanner);
                    break;
                case 4:
                    modify(scanner);
                    break;
                case 5:
                    System.out.println("正在保存数据...");
                    save();
                    System.out.println("感谢你的使用！");
                    return;

            }
        }
    }

    public static void delete(Scanner scanner){
        System.out.println("请输入你要删除的书籍id编号：");
        scanner.nextLine();
        int index = scanner.nextInt();
        scanner.nextLine();
        if(index > LIST.size()-1 || index < 0){
            System.out.println("没有对应的书籍");
        }else {
            LIST.remove(index);
            System.out.println("删除成功");
        }

    }

    public static void modify(Scanner scanner){
        System.out.println("请输入你要修改的书籍id编号：");
        scanner.nextLine();
        int index = scanner.nextInt();
        scanner.nextLine();
        while(index > LIST.size()-1 || index < 0){
            System.out.println("没有对应的书籍,请重输");
            index = scanner.nextInt();
            scanner.nextLine();
        }
            System.out.println("请输入书籍的名字、价格、作者");
            Book book = LIST.get(index);
            book.setTitle(scanner.nextLine());
            book.setPrice(scanner.nextInt());
            scanner.nextLine();
            book.setAuthor(scanner.nextLine());

            System.out.println("修改成功");

    }

    private static  void load() throws FileNotFoundException {
        File file = new File("data");
        if(file.exists()){
            try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))){
                LIST=(List<Book>)stream.readObject();

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            LIST=new LinkedList<>();
        }

    }
    private static void insert(Scanner scanner) {
        System.out.println("录入书籍信息：书名、价格、作者");

        scanner.nextLine();
        String title = scanner.nextLine();
        int price = scanner.nextInt();

        scanner.nextLine();
        String author = scanner.nextLine();

        Book book = new Book(title,price,author);
        LIST.add(book);
        System.out.println("书籍添加成功："+book);

    }

    private static void save(){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data"))){
         stream.writeObject(LIST);
         stream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void list(){
        for(int i=0; i<LIST.size(); i++){
            System.out.println(i+" "+LIST.get(i));
        }
    }


}