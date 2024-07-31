public class devide {
    public static int test(int a, int b) {
        if(b == 0)
            throw new RuntimeException("被除数不能为0");  //使用throw关键字来抛出异常
        return a / b;
    }
}
