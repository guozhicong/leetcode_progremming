package 哈希;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 字母异位词分组 {
    int[][] sum;
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        sum = new int[length][26];

        List<List<String>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                sum[i][strs[i].charAt(j) - 97]++;
            }
        }

        List<String> list;
        for (int i = 0; i < strs.length; i++) {
            list = new ArrayList<>();
            if (!set.contains(i)) {
                list.add(strs[i]);
            } else {
                continue;
            }

            for (int j = i + 1; j < strs.length; j++) {
                if (isEqual(i, j)) {
                    set.add(j);
                    list.add(strs[j]);
                }
            }

            res.add(list);
        }

        return res;
    }

    private boolean isEqual(int i, int j) {
        for (int k = 0; k < 26; k++) {
            if (sum[i][k] != sum[j][k]) return false;
        }
        return true;
    }
}
