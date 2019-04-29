package arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromicNumber2 {
    public static void main(String[] args) {
        String string = "OP";
        PalindromicNumber2 number = new PalindromicNumber2();

        //去除标点和空格
//        String newString = number.changeString(string);
//        //判断是否是回文数
//        boolean istrue = number.isPalindrome(newString);
//
//        System.out.println(istrue);
         System.out.println(number.isHuiWen(string));
    }

    /**
     * 这种写法的弊端是如果出现了特殊字符判断就会出错
     *
     * @param stringInfo
     * @return
     */
    public String changeString(String stringInfo) {
        //去除标点符号
        Pattern p = Pattern.compile("[.,\"\\?!:']");//增加对应的标点
        Matcher m = p.matcher(stringInfo);
        String first = m.replaceAll(""); //把英文标点符号替换成空，即去掉英文标点符号
        System.out.println("去掉英文标点符号后的字符串：" + first);

        //去除多余的空格
        String second = first.replaceAll("\\s*", "");
        System.out.println("去掉多余空格后的字符串" + second);//second为最终输出的字符串

        return second;

    }


    public boolean isPalindrome(String s) {
        int size = s.length();
        String trans = s.toLowerCase();//转化成小写

        if (size <= 0 || size == 1) {
            return true;
        }
        if (size % 2 != 0) {
            //奇数
            String first = trans.substring(0, (size / 2));
            String temp = trans.substring((size / 2) + 1);

            String result = new StringBuffer(temp).reverse().toString();
            if (first.equals(result)) {
                return true;
            } else {
                return false;
            }

        } else {
            //偶数
            String first = trans.substring(0, (size / 2));
            System.out.println("前半段" + first);
            String temp = trans.substring((size / 2));

            System.out.println("后半段" + temp);
            String result = new StringBuffer(temp).reverse().toString();
            if (first.equals(result)) {
                return true;
            } else {
                return false;
            }
        }

    }

    //第二种写法

    public boolean isHuiWen(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        str = str.toLowerCase();
        int i = 0,j = str.length()-1;
        while(i<j) {
            while(i<j && !isCharOrNum(str.charAt(i))) {
                i++;
            }
            while(i<j && !isCharOrNum(str.charAt(j))) {
                j--;
            }
            while(str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    public boolean isCharOrNum(char a) {
        return a >= '0' && a <= 9 || a >= 'a' && a <= 'z';
    }

    //第三种写法
    public boolean huiwen(String s){
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
