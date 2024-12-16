package Solutions;

import java.util.LinkedList;
import java.util.List;

public class FullJustify {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        int n = words.length;
        int l=0; int r=0; int width=0;
        while(l<n) {
            if(r==n) {
                // 最后一行 
                StringBuilder builder = new StringBuilder();
                for(int i=l; i<r-1; i++) {
                    builder.append(words[i]);
                    builder.append(" ");
                }
                builder.append(words[r-1]);
                int length = maxWidth - builder.length();
                builder.append(" ".repeat(length));
                ans.add(builder.toString());
                l = r;

            } else if(words[r].length() + width + r -l <= maxWidth) {
                width += words[r].length(); r++;
            } else {
                if(l==r-1) {
                    // 只有一个词 左对齐
                    StringBuilder builder = new StringBuilder();
                    builder.append(words[l]);
                    int length = maxWidth - builder.length();
                    builder.append(" ".repeat(length));
                    ans.add(builder.toString());
                } else {
                    // 左右对齐
                    // l ~ r-1
                    StringBuilder builder = new StringBuilder();
                    int smaller = (maxWidth-width) / (r-l-1);
                    int biggerNum = (maxWidth - width) % (r-l-1);
                    for(int i=l; i<r; i++) {
                        builder.append(words[i]);
                        if(i==r-1) {
                            break;
                        } else if(biggerNum>0) {
                            builder.append(" ".repeat(smaller+1)); biggerNum--;
                        } else {
                            builder.append(" ".repeat(smaller));
                        }
                    }
                    ans.add(builder.toString());
                }
                width = 0;
                l = r;
            }
        }


        return ans;
    }
}
