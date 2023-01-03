package test;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GcTest {

    private int a;
    private static int b;
    private static final int c = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
            System.out.println("被打断之后");
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
//        Thread.currentThread().interrupt();
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "--------副线程come in");
//            int result = ThreadLocalRandom.current().nextInt(10);//产生随机数
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return result;
//        }, threadPool).thenApply(res -> {
//            System.out.println(Thread.currentThread().getName() + "--------then");
//            return  res + 1;
//        }).whenComplete((v, e) -> {//没有异常,v是值，e是异常
//            if (e == null) {
//                System.out.println("------------------计算完成，更新系统updataValue" + v + Thread.currentThread().getName());
//            }
//        }).exceptionally(e -> {//有异常的情况
//            e.printStackTrace();
//            System.out.println("异常情况" + e.getCause() + "\t" + e.getMessage());
//            return null;
//        });
//        threadPool.shutdown();
    }
    public static long ipToLong(String strIp) {

        String[]ip = strIp.split("\\.");

        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);

    }

    public static String longToIP(long longIp){
        StringBuffer sb = new StringBuffer("");
        //直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        //将高8位置0，而后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        //将高16位置0，而后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        //将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "-----come in call() ----异步执行");
        return "hello Callable 返回值";
    }
}

