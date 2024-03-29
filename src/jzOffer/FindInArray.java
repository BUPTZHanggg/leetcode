package jzOffer;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-27
 *
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInArray {

    public boolean Find(int target, int [][] array) {
        if (array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
