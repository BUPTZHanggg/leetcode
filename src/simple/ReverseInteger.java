package simple;

public class ReverseInteger {

    public static int reverse(int x) {
        int factorDiv = 1;
        int result = 0;
        int abs = x > 0 ? x : x * -1;
        boolean loop = true;
        while (loop){
            int tmp = (x / factorDiv) % 10;
            result = result * 10 + tmp;
            factorDiv *= 10;
            if (factorDiv > abs){
                loop = false;
            }
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && tmp > 7));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1534236469 * 10));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
