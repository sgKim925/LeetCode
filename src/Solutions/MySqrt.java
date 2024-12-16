package Solutions;

public class MySqrt {
    /*
     * 牛顿迭代法用于求解函数零点
     * 求x^(1/2)  等价于求x^2 = C的零点
     * 令 f(x) = x^2 - C
     * 初始化x0 = C; 确保x_{i+1} < x_{i}
     * x_{i+1} = 1/2 * (x_i + C/x_i)
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

}
