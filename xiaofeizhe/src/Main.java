import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
//因为集合类不支持多线程，所以要加锁；
    private static final Queue<Object> queue = new LinkedList<>();

    public static void main(String[] args) {
        new Thread(Main::add,"厨师1").start();
        new Thread(Main::add,"厨师2").start();
        new Thread(Main::take,"顾客1").start();
        new Thread(Main::take,"顾客2").start();
        new Thread(Main::take,"顾客3").start();

    }

    private static void add(){
        while(true) {
            try {
                Thread.sleep(3000);
                synchronized (queue){
                    String name = Thread.currentThread().getName();
                    System.out.println(new Date() + " " + name + "出餐了");
                    queue.add(new Object());
                    queue.notifyAll();
                }
           } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    private static void take(){
        while(true) {
            try {
                synchronized (queue){
                    while(queue.isEmpty())
                        queue.wait();
                    queue.poll();
                    String name = Thread.currentThread().getName();
                    System.out.println(new Date() + " " + name + "拿到了，正在享用！");
                }
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}