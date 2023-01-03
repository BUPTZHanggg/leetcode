package test;

import java.util.Random;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-21
 */
public interface Inter1 {

    public static final int c = new Random().nextInt();

    public static final Thread t = new Thread() {
        {
//            System.out.println("Compare接口的初始化");
        }
    };

    default boolean fly() {
        return c > 5;
    }
}
