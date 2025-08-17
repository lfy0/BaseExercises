package java_;

import java.util.Stack;

public class Test4 {


    static String arr3[] = {"aA","bB","cC"};

    public static void main(String[] args) {
        String target = "cbBC";
        Stack<String> s = new Stack<>();
        boolean pop = false;
        for (int i = 0; i < target.length(); i++) {
            pop = false;
            char c = target.charAt(i);
            String cc = String.valueOf(c);
            String pp = "";
            if (!s.empty()){
                pp = s.peek();
            }
            for (int j = 0; j < arr3.length; j++) {
                if ((pp + cc).equals(arr3[j])) {//如果是"aA","bB","cC"的形式则弹栈，不是则入栈最后判断栈是否为空
                    s.pop();
                    pop = true;
                    break;
                }
            }
            if (!pop){
                s.push(cc);
            }
        }
        System.out.println(s.empty());
    }
}
