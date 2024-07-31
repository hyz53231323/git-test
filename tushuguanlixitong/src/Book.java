import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private int price;
    private String author;

    public Book(String title, int price, String author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "书名《" +title+"》 "+"价格："+price+"元 作者："+author;

    }
}
