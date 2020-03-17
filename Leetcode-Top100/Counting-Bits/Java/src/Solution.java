
class Solution {
    public int[] countBits(int num) {
        int res[] = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int tmp = i;
            int count = 0;
            while (tmp != 0) {
                tmp &= (tmp - 1);
                count ++;
                if (res[tmp] != 0) {
                    count += res[tmp];
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }
}