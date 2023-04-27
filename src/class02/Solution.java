package class02;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static  List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] indices = new int[len];
        int[] newIndices = new int[len];
        for (int i = 0; i < len; i++)
            indices[i] = i;
        mergeSort(nums, res, indices, newIndices, 0, len - 1);
        List<Integer> list = new ArrayList<>(len);
        for (int r : res) {
            list.add(r);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{2, 0, 2,1}));
    }
    static void mergeSort(int[] nums, int[] res, int[] indices, int[] newIndices, int l, int r) {
        if (l == r) return;
//        for (int i = l; i <= r; i++)
//            temp[i] = indices[i];

        int m = l + (r - l >> 1);
        mergeSort(nums, res, indices, newIndices, l, m);
        mergeSort(nums, res, indices, newIndices, m + 1, r);
        int[] cache = new int[r - l + 1];
        int i, j;
        int count = 0;
        for (i = l, j = m + 1; i <= m; ) {
            while (j <= r && nums[j] < nums[i]) {
                //后面的小于前面的
                newIndices[count + l] = indices[j];
//                indices[count + l] = temp[j]; //更新index
                cache[count] = nums[j]; // j 到下一个位置
                count++;
                j++;
            }
            //i位置
            cache[count] = nums[i];
            newIndices[count + l] = indices[i];
            res[newIndices[count + l ]] += j - m - 1;
            i++;
            count++;
        }
        System.arraycopy(cache, 0, nums, l, count);
        System.arraycopy(newIndices, l, indices, l, count);
    }
}
