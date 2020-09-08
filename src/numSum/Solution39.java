package numSum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 39组合总和
 * @author: Yuner
 * @create: 2020-09-08 20:13
 **/
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {

        if(target < 0) {
            return;
        }

        if(target == 0) {
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            dfs(candidates, i, len, target - candidates[i], path, res);

            path.removeLast();
        }

    }
}
