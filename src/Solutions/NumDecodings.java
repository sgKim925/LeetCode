package Solutions;

public class NumDecodings {
    // 动态规划问题
    // 本质为当前s[i]能否组成一个个体 + s[i-1, i]能否组成一个个体
    // 对应的状态转移方程为 f[i] = f[i-1]; // 本身能从f[i-1]转移而来
    // f[i] += f[i-2]  同时还能从f[i-2]转移过来
    public int numDecodings(String s) {
        int n = s.length();
        String ss = " " + s;
        char[] arr = ss.toCharArray();
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i=1; i<=n; i++) {
            int a = arr[i]-'0';
            int b = a + (arr[i-1]-'0')*10;
            if(a>=1 && a<=9) f[i] = f[i-1];
            if(b>=10 && b<=26) f[i] += f[i-2];
        }
        return f[n];
    }
}