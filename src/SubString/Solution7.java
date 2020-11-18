package SubString;

/**
 * @description: 7.整数反转
 * @author: Yuner
 * @create: 2020-11-18 16:59
 **/
public class Solution7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x/10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}
