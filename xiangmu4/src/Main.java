import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;


public class Main {

    public  static void main(String [] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                timer.cancel();  //结束
            }
        }, 1000);
    }
}


