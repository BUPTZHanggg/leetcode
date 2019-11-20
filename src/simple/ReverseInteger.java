package simple;

public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;
        int abs = x > 0 ? x : x * -1;
        while (x != 0){
            int tmp = x % 10;
            x /= 10;
            if (result > 0x7fffffff / 10)
                return 0;//如果走了这个分支说明下面result乘10后必然溢出 直接返回0
            if (result == 0x7fffffff / 10 && tmp > 0x7fffffff % 10)
                return 0;//result乘10之后除了个位都与最大值一致 因此tmp大于最大值的个位则溢出
            if (result < 0x80000000 / 10)
                return 0;//负数同样
            if (result == 0x80000000 / 10 && tmp < 0x80000000 % 10)
                return 0;
            result = result * 10 + tmp;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
