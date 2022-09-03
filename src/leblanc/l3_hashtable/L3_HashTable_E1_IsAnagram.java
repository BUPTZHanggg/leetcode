package leblanc;

/**
 * LC242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-14
 */
public class L3_HashTable_E1_IsAnagram {

    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            map[index]++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            map[index]--;
        }
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }
}
