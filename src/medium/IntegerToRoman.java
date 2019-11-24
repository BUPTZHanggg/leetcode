package medium;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 0;
        while (num != 0){
            if (flag == 3){//千位存在
                for (int i = 0;i < num;i++){
                    result.insert(0, 'M');
                }
                return result.toString();
            }
            int mod = num % 10;
            if (flag == 0){
                String s = append(mod, 'I', 'V', 'X');
                result.insert(0, s);
            }else if (flag == 1){
                String s = append(mod, 'X', 'L', 'C');
                result.insert(0, s);
            }else if (flag == 2){
                String s = append(mod, 'C', 'D', 'M');
                result.insert(0, s);
            }
            num /= 10;
            flag++;
        }
        return result.toString();
    }

    public static String append(int num, char symbol1, char symbol2, char symbol3){
        if (num == 0){
            return "";
        }else if (num >= 1 && num <= 3){
            StringBuilder tmp = new StringBuilder();
            for (int i = 0;i < num;i++){
                tmp.append(symbol1);
            }
            return tmp.toString();
        }else if (num == 4){
            return new StringBuilder().append(symbol1).append(symbol2).toString();
        }else if (num == 9){
            return new StringBuilder().append(symbol1).append(symbol3).toString();
        }else {
            StringBuilder tmp = new StringBuilder();
            tmp.append(symbol2);
            for (int i = 0;i < num - 5;i++){
                tmp.append(symbol1);
            }
            return tmp.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3588));
    }
}
