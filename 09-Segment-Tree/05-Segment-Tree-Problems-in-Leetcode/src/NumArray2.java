class NumArray2 {
    private int[] sum;
    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        for (int j = i + 1; i < sum.length; i++) {
            sum[j] += val;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}