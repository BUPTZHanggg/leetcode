package leblanc.l3_hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * LC202
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 1 <= n <= 231 - 1
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-18
 */
public class L3_HashTable_E3_IsHappy {

    public static void main(String[] args) {
        L3_HashTable_E3_IsHappy cl = new L3_HashTable_E3_IsHappy();
        System.out.println(cl.getNewNum(1));
        System.out.println(cl.isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while (n != 1 && !sumSet.contains(n)) {
            sumSet.add(n);
            n = getNewNum(n);
        }
        return n == 1;
    }

    private int getNewNum(int n) {
        int res = 0;
        while (n > 0) {
            int curr = n % 10;
            res += curr * curr;
            n /= 10;
        }
        return res;
    }
}
