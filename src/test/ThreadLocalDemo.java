package test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-12-27
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        House house = new House();
        for(int i = 1;i <= 5;i++){
            new Thread(()->{
                try {
                    int size = new Random().nextInt(5) + 1;
                    System.out.println(Thread.currentThread().getName() + "\t"+"expect count：" + size);
                    for(int j = 1;j <= size;j ++){
                        house.saleHouse();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t"+"real count：" + house.getCount());
                } finally {
                    house.remove(); //回收ThreadLocal中当前现成的副本值
                }
            },"Thread" + i).start();
        }
    }
}

class House{
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);

    public void saleHouse(){
        threadLocal.set(threadLocal.get() + 1);
    }

    public int getCount() {
        return threadLocal.get();
    }

    public void remove() {
        threadLocal.remove();
    }
}