package leblanc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * LC344
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-05
 */
public class L4_Str_E1_ReverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<String> allAvailableIdcs = new ArrayList<>();
        allAvailableIdcs.add("aliyun");
        allAvailableIdcs.add("tencent");
        System.out.println(allAvailableIdcs);
        Collections.shuffle(allAvailableIdcs, new Random(System.currentTimeMillis()));
        System.out.println(allAvailableIdcs);
    }
}
