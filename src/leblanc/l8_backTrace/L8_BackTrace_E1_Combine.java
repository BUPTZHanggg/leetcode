package leblanc.l8_backTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 1 <= n <= 20     1 <= k <= n
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-03-13
 */
public class L8_BackTrace_E1_Combine {

    public static void main(String[] args) {
        L8_BackTrace_E1_Combine cl = new L8_BackTrace_E1_Combine();
        List<List<Integer>> combine = cl.combine(4, 2);
        System.out.println(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combine(path, res, 1, n , k);
        return res;
    }

    private void combine(List<Integer> path, List<List<Integer>> res, int index, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combine(path, res, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
