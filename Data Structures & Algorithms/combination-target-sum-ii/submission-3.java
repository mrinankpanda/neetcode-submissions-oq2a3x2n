class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> sub = new ArrayList<>();  

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, 0, candidates, target);
        return res;
    }

    private void backtrack (int j, int total, int[] cands, int target) {
        if (total == target) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = j; i < cands.length; i++) {
            if (total + cands[i] > target) break;
            if (i > j && cands[i-1] == cands[i]) continue; 
            sub.add(cands[i]);
            backtrack(i + 1, total + cands[i], cands, target);
            sub.remove(sub.size() - 1);
        }
    }
}
