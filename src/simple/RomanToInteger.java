package simple;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int result = 0;
        for(int i = s.length() - 1;i >= 0;i--){
            char tmp = s.charAt(i);
            switch (tmp){
                case 'I':
                    result++;
                    break;
                case 'V':
                    if (i - 1>= 0 && s.charAt(i - 1) == 'I'){
                        result += 4;
                        i--;
                    }else {
                        result += 5;
                    }
                    break;
                case 'X':
                    if (i - 1>= 0 && s.charAt(i - 1) == 'I'){
                        result += 9;
                        i--;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    if (i - 1>= 0 && s.charAt(i - 1) == 'X'){
                        result += 40;
                        i--;
                    }else {
                        result += 50;
                    }
                    break;
                case 'C':
                    if (i - 1>= 0 && s.charAt(i - 1) == 'X'){
                        result += 90;
                        i--;
                    }else {
                        result += 100;
                    }
                    break;
                case 'D':
                    if (i - 1>= 0 && s.charAt(i - 1) == 'C'){
                        result += 400;
                        i--;
                    } else {
                        result += 500;
                    }
                    break;
                case 'M':
                    if (i - 1>= 0 && s.charAt(i - 1) == 'C'){
                        result += 900;
                        i--;
                    }else {
                        result += 1000;
                    }
                    break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}

