package test;

import static test.TestEnum.aaaabbbb;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-08-26
 */
public class User implements Cloneable{

    public static void main(String[] args) {
        String property = System.getProperty("java.class.path");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        if (clone instanceof User) {
            ((User) clone).setAge(10);
        }
        return clone;
    }


    protected volatile int age;

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
