package JUC;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-11-21
 */
public class DoubleCheck {

    private volatile static DoubleCheck instance;

    private DoubleCheck() {}

    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

    public static DoubleCheck getInstance0() {
        return DoubleCheckHolder.instance;
    }

    private static class DoubleCheckHolder {
        private static DoubleCheck instance = new DoubleCheck();
    }
}
