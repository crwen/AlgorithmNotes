
**[题目传送门](https://leetcode.com/problems/hamming-distance/)**

**题目描述**


两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 2^31.


**示例:**
```html
输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
```

由题目可以清晰地直到，这题只需要求两个数异或之后得到的数组中有多少个 1，所以问题就转换为了一个数的二进制中有多少个 1.

**方法一**

使用 api 中的方法 `Integer.bitCount(x ^ y)`
```java
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
```

**方法二**

每次与 1 相与，判断结果是不是 1。

```java
public class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int ret = 0;
        while (res > 0) {
            if ( (res & 1) == 1 ) {
                ret ++;
            }
            res >>= 1;
        }
        return ret;
    }
}
```
 注意，由于题目说明了两个数都是整数，所以可以使用这种方法。但是如果求一个负数的二进制 1 的个数 该方法不适用（负数的补码=正数源码除符号位取法 + 1）

 **方法三**

将 n 与 n - 1 相与，可以消除一个 1

```html
n:      1111 1000
n-1:    1111 0111
        ---------
        1111 0000
```

 ```java
public class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int ret = 0;
        while (res > 0) {
            ret ++;
            res &= (res - 1);
        }
        return ret;
    }
}
 ```