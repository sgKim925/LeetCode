package Solutions;

public class MyPow {
    
    public double myPow(double x, int n) {
        if(x==0||n==Integer.MIN_VALUE) return 0;
        if(n<0) return 1/myPow(x, -n);
        if(n==1) return x;
        if(n==0) return 1;
        // x^8 = x^4 * x^4
        // x^9 = x^4 * x^5
        double ans=1;
        double y = myPow(x, n/2);
        if((n&1)==0) { //even
            ans = y * y; // 不同于myPow(x, n/2) * myPow(x, n/2)， 后者为递归两次
        } else {
            ans = x * y * y;
        }
        return ans;
    }
}
