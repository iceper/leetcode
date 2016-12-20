package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个纯数字的串，算出有多少种ip地址的可能情况.
 * 回溯法解决此问题
 * @author fu tao
 * @since 2016/12/20 16:40
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s == "") {
            return null;
        }
        int length = s.length();
        if (length < 4) {
            return null;
        }
        int seq1 = 1;
        int seq2 = 1;
        int seq3 = 1;
        int seq4 = length - (seq1 + seq2 + seq3);
        String sub = s.substring((seq1 + seq2 + seq3), length);
        if (isValid(sub)) {
            list.add(join(s, seq1, seq2, seq3, seq4));
        } else {

        }
        return null;
    }

    public String join(String s, int seq1, int seq2, int seq3, int seq4) {
        StringBuilder result = new StringBuilder();
        result.append(s.substring(0, seq1))
                .append(".")
                .append(s.substring(seq1, seq1 + seq2))
                .append(".")
                .append(s.substring(seq1 + seq2, seq1 + seq2 + seq3))
                .append(".")
                .append(s.substring(seq1 + seq2 + seq3, seq1 + seq2 + seq3 + seq4));
        return result.toString();
    }

    public boolean isValid(String sub) {
        if (sub == null || sub == "") {
            return false;
        }
        int val = Integer.valueOf(sub);
        if (val >= 0 && val <= 255) {
            return true;
        } else {
            return false;
        }
    }
}
