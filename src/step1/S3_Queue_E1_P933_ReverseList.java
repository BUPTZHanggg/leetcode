package step1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你实现 RecentCounter 类：
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-23
 */
public class S3_Queue_E1_P933_ReverseList {

    private final Queue<Integer> queue = new LinkedList<>();

    public S3_Queue_E1_P933_ReverseList() {

    }

    public int ping(int t) {
        int timeBound = t - 3000;
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < timeBound) {
            queue.poll();
        }
        return queue.size();
    }
}
