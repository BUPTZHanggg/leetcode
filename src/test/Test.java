package test;

import java.net.InetAddress;
import java.net.URL;
import java.security.Provider;
import java.util.Iterator;
import java.util.ServiceLoader;

import sun.security.ec.CurveDB;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-08-12
 */
public class Test {

    static {
        System.out.println("Test类的初始化");
    }

    public static final String a = new String("111");

    public static void main(String[] args) {
        String s2 = Long.toBinaryString(Long.MAX_VALUE);
        System.out.println(s2.length());
        long l = Long.parseLong("111111111111111111111111111111111111111111", 2);
        String s = Long.toBinaryString(-1L);
        System.out.println(s);
        String s1 = Long.toBinaryString(~(-1L << 5));
        System.out.println(s1);
        ServiceLoader<Inter1> services = ServiceLoader.load(Inter1.class);
        Iterator<Inter1> iterator = services.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getClass());
        }
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取系统类加载器的上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader); //sun.misc.Launcher$ExtClassLoader@5cad8086

        //获取扩展类加载器的上层：获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);//null

        //对于用户自定义类来说：默认使用系统类加载器进行加载
        //两次获取系统类加载器的值都相同，说明系统类加载器是全局唯一的
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        //Java的核心类库都是使用引导类加载器进行加载的。
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1); //null

        System.out.println("**********启动类加载器**************");
        //获取BootstrapClassLoader能够加载的api的路径
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:引导类加载器
        ClassLoader classLoader2 = Provider.class.getClassLoader();
        System.out.println(classLoader2); //null

        System.out.println("***********扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(":")) {
            System.out.println(path);
        }

        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:扩展类加载器
        ClassLoader classLoader3 = CurveDB.class.getClassLoader();
        System.out.println(classLoader3);//sun.misc.Launcher$ExtClassLoader@1540e19d
    }
}
