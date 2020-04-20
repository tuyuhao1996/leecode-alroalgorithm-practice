package convert;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 */
public class Convert {
    public static String convert(String s, int numRows) {
        String result = "";
        if (numRows <= 1) return s;
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuffer());
        }
        int j = 0;
        boolean isDown = false;
        for (int i = 0; i < s.length(); i++) {
            list.get(j).append(s.charAt(i));
            if (j==0 || j==numRows-1) isDown = !isDown;
            j += isDown ? 1 : -1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<list.size(); i++) {
            sb.append(list.get(i));
        }
        result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
