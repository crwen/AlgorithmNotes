class NumArray {
    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums) {
        if(nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }
    
    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("ERROR");
        }
        return segmentTree.query(i, j);
    }
}