package Solutions;

import java.util.HashMap;
import java.util.Map;

public class IsScramble {
    // private boolean check(String s1, String s2) {
    //     // 检查词频
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(char c: s1.toCharArray()) {
    //         map.put(c, map.getOrDefault(c,0)+1);
    //     }
    //     int required = map.keySet().size();
    //     int formed =0;
    //     for(char c: s2.toCharArray()) {
    //         if(map.containsKey(c)) {
    //             map.put(c, map.get(c)-1);
    //         } else {
    //             return false;
    //         }
    //         if(map.get(c)==0) formed++;
    //         if(map.get(c)<0) return false;
    //     }
    //     return required==formed;
    // }

    public boolean isScrambleTLE(String s1, String s2) {
        /*
         * 递归暴力搜索解法 会超时
         */
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        if(!check(s1, s2)) return false;

        int n=s1.length();
        for(int split=1; split<n; split++) {
            // 若split==0 则会出现s1 == s1Second的情况 会死循环

            // s1 分割成 s1[0, split) [split, n)
            // s2.      s2[0, split) [split, n)
            //          s2[0, n-split) [n-split, n)
            String s1First = s1.substring(0, split);
            String s1Second = s1.substring(split, n);
            String s2First = s2.substring(0, split);
            String s2Second = s2.substring(split, n);
            if(
                isScrambleTLE(s1First, s2First) &&
                isScrambleTLE(s1Second, s2Second)
            ) return true;
            s2First = s2.substring(0, n-split);
            s2Second = s2.substring(n-split, n);
            if(
                isScrambleTLE(s1First, s2Second) &&
                isScrambleTLE(s1Second, s2First)
            ) return true;
        }
        return false;
    }
   
    /*
        记忆化搜索
        -1 ，0， 1 三种状态，初始化0为未计算
    */
    private int[][][] f; 
    String s1; String s2;

    private boolean check(String _s1, String _s2) {
        // check frequency
        Map<Character, Integer> map = new HashMap<>();
        for(char c: _s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int required = map.keySet().size();
        int formed = 0;
        for(char c: _s2.toCharArray()) {
            if(map.containsKey(c)) {
                int count = map.get(c);
                if(count==1) formed++;
                if(count==0) return false;
                map.put(c, count-1);
            } else {
                return false;
            }
        }
        return formed==required;
    }

    private boolean backTracking(int i, int j, int length) {
        if(f[i][j][length]!=0) return f[i][j][length]==1; // 当前状态被计算过

        if(s1.substring(i, i+length).equals(s2.substring(j, j+length))) {
            f[i][j][length] = 1; return true;
        }

        if(!check(s1.substring(i, i+length), s2.substring(j, j+length))) {
            f[i][j][length] = -1; return false;
        }

        for(int k=1; k<length; k++) {
            if(
                backTracking(i, j, k) &&
                backTracking(i+k, j+k, length-k)
            ) {
                f[i][j][length] = 1;
                return true;
            }

            if(
                backTracking(i, j+length-k , k) &&
                backTracking(i+k, j , length-k)
            ) {
                f[i][j][length] = 1;
                return true;
            }
        }
        f[i][j][length] = -1;
        return false;
    }
    
    public boolean isScramble(String _s1, String _s2) {
        s1 = _s1; s2 = _s2;
        if(s1.equals(s2)) return true;
        if(!check(s1, s2)) return false;
        int n = s1.length();
        if(s2.length()!=n) return false;
        f = new int[n][n][n+1];
        return backTracking(0, 0, n);
    }

}
