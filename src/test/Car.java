package test;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-14
 */
public interface Car {

    public static final Thread t = new Thread() {
        {
            System.out.println("Compare接口的初始化");
        }
    };
//
//    default boolean canFly() {
//        return false;
//    }
}
