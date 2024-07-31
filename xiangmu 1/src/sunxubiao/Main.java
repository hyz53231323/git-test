package sunxubiao;

import sunxubiao.ArrayList;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("aaa",0);
        list.add("bbb",1);
        list.add("ccc",2);
        list.remove(2);
        System.out.println(list);
        list.get(1);
    }




}