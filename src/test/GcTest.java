package test;

/**
 * 测试MinorGC、MajorGC、FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */
public class GcTest {

    public static void main(String[] args) {
        GcTest test = new GcTest();
        long userId = 100011;
        int num = 10;
        test.setStr("aaa");
    }

    private void setStr(String str) {
        str += "aaa";
        System.out.println("方法里的" + str);
    }

    private void setUserAge(User user) {
        user.setAge(28);
        System.out.println("方法里的" + user.getAge());
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
