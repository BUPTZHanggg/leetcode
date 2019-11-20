package medium;

public class StringtoInteger {

    public static int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
        int beginIndex = 0;//记录第一个非空字符的位置
        for (char c : str.toCharArray()){
            if (c != ' ')
                break;
            beginIndex++;
        }
        if (beginIndex == str.length())//字符串都为空字符
            return 0;
        char beginChar = str.charAt(beginIndex);
        if (beginChar != '-' && beginChar != '+' && !(beginChar >= '0' && beginChar <= '9')){//无效
            return 0;
        }
        boolean positive = true;//是否为正数
        int result = 0;
        /*
         * 程序走到这里说明第一个非空字符是有效的，对第一个非空字符进行处理
         */
        if (beginChar == '-'){
            positive = false;
        }else if (beginChar >= '0' && beginChar <= '9'){
            result = result * 10 + (beginChar - 48);
        }
        /*
         * 程序主体部分
         */
        for (int i = beginIndex + 1;i < str.length();i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                int tmp = str.charAt(i) - 48;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7))
                    return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tmp > 8))
                    return Integer.MIN_VALUE;
                result = result * 10 + tmp * (positive ? 1 : -1);
            }else {
                return result;//碰到无效字符直接返回
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi(" 2147483648"));
    }

}
