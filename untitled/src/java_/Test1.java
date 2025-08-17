package java_;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test1 {

    static String arr1[] = {"", "十", "百", "千", "", "十", "百", "千","", "十", "百", "千","", "十", "百", "千","", "十", "百", "千"};//需要考虑到运算量上限来设置

    static String arr2[] = {"零","一", "二","三","四","五","六","七","八","九"};

    public static void main(String[] args) {
       // long number = 223456;//十二万三千四百五十六
       // long number = 1234567;//一百二十三万四千五百五十六
       long number = 123456;//一千二百三十四万五千六百七十八
       //long number = 123456789;//一千二百三十四万五千六百七十八
        String value = String.valueOf(number);
        System.out.println(giveBig(value));
    }

    public static String giveBig(String number) {
        int length = number.length();
        if (length > arr1.length) return "error";
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {//迭代目标数字字符串，逐位取出，对应大写数字，根据当前数字所在位置拿到单位比如第一位是个位，第二位拿到十位
            int index = number.length() - 1 - i;
            if (index == 3) {
                buffer.append("万");
            } else if (index == 7 && number.length() -1 != index) {
                buffer.append("亿");
            }//目前单位到亿，后续依此类推+4
            char c = number.charAt(i);
            String word = arr2[c - 48];//减去机器码得到对应索引
            buffer.append(word).append(arr1[number.length() - 1 - i]);
        }
        return buffer.toString();
    }

}
