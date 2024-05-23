package 哈希;

import java.util.HashMap;
import java.util.HashSet;

public class 两数之和 {
    /**
     * 一次for循环解法
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{i, hashTable.get(target - nums[i])};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 两次for循环，不够优美
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i]) && hashTable.get(target - nums[i]) != i) {
                return new int[]{i, hashTable.get(target - nums[i])};
            }
        }
        return new int[0];
    }
}
