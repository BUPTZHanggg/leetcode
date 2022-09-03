package leblanc.l5_stackAndQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC347
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-08-24
 */
public class L5_StackAndQueue_E7_TopKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        L5_StackAndQueue_E7_TopKFrequent cl = new L5_StackAndQueue_E7_TopKFrequent();
        System.out.println(Arrays.toString(cl.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        //小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll().getKey();
        }
        return res;
    }
}
