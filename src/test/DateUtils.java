package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-12-28
 */
public class DateUtils {

    public static final ThreadLocal<SimpleDateFormat> sdfThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public static Date parseByThreadLocal(String stringDate) throws ParseException {
        return sdfThreadLocal.get().parse(stringDate);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 30; i++) {
            //模拟并发场景下通过SimpleDateFormat处理时间的场景
            new Thread(() -> {
                try {
                    System.out.println(parseByThreadLocal("2022-12-28 11:20:30"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread" + i).start();
        }
    }
}
