package leblanc.l3_hashtable;

/**
 * LC383
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-22
 */
public class L3_HashTable_E6_CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            map[c - 'a']--;
        }
        for (int num : map) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
