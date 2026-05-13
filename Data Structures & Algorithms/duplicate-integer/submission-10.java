class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        for (int i : nums) {
            if (ans.contains(i)) {
                return true;
            } else {
                ans.add(i);
            }
        }
        return false;
    }
}