package java_;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Test6 {



    public String reversal(String str) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            string = c + string;
        }
        return string;
    }

    public int[] sumValue(int target, int[] numbs) {
        int[] arr = null;
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (target == (numbs[i] + numbs[j])) {
                    arr = new int[]{i, j};
                    return arr;
                }
            }
        }
        return arr;
    }

    public boolean myPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int t = num % 10;
            num /= 10;
            if (!stack.empty() && stack.peek() == t) {
                stack.pop();
            } else {
                stack.push(t);
            }
            arrayList.add(t);
        }
        if (stack.size() % 2 == 1) {
            stack.clear();
            arrayList.remove(arrayList.size() / 2);
            for (Integer i :
                    arrayList) {
                if (!stack.empty() && stack.peek().equals(i)) {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        return stack.isEmpty();
    }


    public boolean myPalindrome2(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        int reverseHalf = 0;
        while (num > reverseHalf) {
            int desc = num % 10;
            System.out.println("desc:" + desc);
            reverseHalf = reverseHalf * 10 + desc;
            num /= 10;
        }
        return num == reverseHalf || reverseHalf / 10 == num;
    }


    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            System.out.print("a:" + c);
            String getChar = getMate(c + "");
//            System.out.println("b:" + getChar);
            if (!stack.empty() && getChar.equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(c + "");
            }
        }
        return stack.isEmpty();
    }

    public String getMate(String c) {
        return switch (c) {
            case ")" -> "(";
            case "]" -> "[";
            case "}" -> "{";
            default -> "";
        };
    }

    public boolean isValid2(String S){
//        if (S.length() % 2 != 0) { // s 长度必须是偶数
//            return false;
//        }
        // 直接把 s 当作栈
        char[] s = S.toCharArray();
        int top = 0;
        for (char c : s) {
            //将该左括号转变成对应的右括号
            if (c == '(') {
                s[top++] = ')';
            } else if (c == '[') {
                s[top++] = ']';
            } else if (c == '{') {
                s[top++] = '}';
                //第一个就是右括号或者右括号和他前面的左括号（转变成对应的右括号）不相等
            } else if (top == 0 || s[--top] != c) {
                return false;
            }
        }
        // 所有左括号必须匹配完毕，top才能为0
        return top == 0;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = list2;
        ListNode tempNode;
        while (list1 != null) {
            System.out.println("val:" + list1.val);
            curr = list2;
            while (curr != null) {
                System.out.print(curr.val + ",");
                if (list1.val > curr.val) {
                    //ListNode lastNode = tempNode.next;
                }
                curr = curr.next;
            }

            list1 = list1.next;
            System.out.println();
        }
        return null;
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (!s.contains(" ")){
            return s.length();
        }
        int count = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            count++;
            char first = s.charAt(i);
            char last = s.charAt(i + 1);
            if (first == ' ' && last != ' ') {
                break;
            }
        }
        return count;
    }

    public int[] plusOne(int[] digits) {
        int digit = digits[digits.length - 1];
        if (digit != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        int num = 0;
        //BigDecimal bd = new BigDecimal(0);
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            //bd = bd.multiply(new BigDecimal(10)).add(new BigDecimal(digits[i]));
            //num = (num * 10) + digits[i];
            if (digits[i] == 9) {
                count++;
            }
        }
        System.out.println("数字：" + num + "九的个数：" + count);
        num++;
        if (count == digits.length) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = num % 10;
                num /= 10;
            }
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int digit = digits[digits.length - 1];
        if (digit != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        StringBuilder numStr = getStringBuilder(digits);
        if (numStr.length() > digits.length) {
            int size = digits.length + 1;
            digits = new int[size];
        }
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        System.out.println("numStr:" + numStr);
        return digits;
    }

    @NotNull
    private static StringBuilder getStringBuilder(int[] digits) {
        boolean w = false;//是否进位
        StringBuilder numStr = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = i == digits.length - 1 ? digits[i] + 1 : digits[i];
            if (w) {
                temp++;
            }
            w = false;
            if (temp <= 9) {
                numStr.insert(0, temp);
            } else {
                if (i == 0) {
                    numStr.insert(0, "10");
                } else {
                    numStr.insert(0, "0");
                }
                w = true;
            }
        }
        return numStr;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        Integer[][] array = new Integer[numRows][];
        int rightIndex = 0;
        for (int i = 0; i < numRows; i++) {
            array[i] = new Integer[rightIndex + 1];
            array[i][0] = 1;
            array[i][rightIndex] = 1;
            rightIndex++;
            if (i > 1) {
                for (int j = 1; j < rightIndex - 1; j++) {
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }
            list.add(Arrays.asList(array[i]));
        }
//        for (List<Integer> integers : list) {
//            System.out.println(integers);
//        }
        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<List<Integer>> list = new ArrayList<>();
        Integer[][] array = new Integer[rowIndex][];
        int rightIndex = 0;
        for (int i = 0; i < rowIndex; i++) {
            array[i] = new Integer[rightIndex + 1];
            array[i][0] = 1;
            array[i][rightIndex] = 1;
            rightIndex++;
            if (i > 1) {
                for (int j = 1; j < rightIndex - 1; j++) {
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }
            list.add(Arrays.asList(array[i]));
        }
//        for (List<Integer> integers : list) {
//            System.out.println(integers);
//        }
       // System.out.println(list.get(--rowIndex));
        return list.get(--rowIndex);
    }


    public static void main(String[] args) {
        String str = "abcdefg";
        Test6 test6 = new Test6();
        System.out.println(test6.reversal(str));
        int aar[] = {3, 2, 4};
        System.out.println(Arrays.toString(test6.sumValue(6, aar)));
        System.out.println("是回文数吗?" + test6.myPalindrome(124321));
        System.out.println("是回文数吗?" + test6.myPalindrome2(11223311));
        System.out.println(test6.isValid("()[]{}"));
        System.out.println(test6.isValid2("()[]{"));
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};
        ListNode node1 = arrayToList(arr1);
        ListNode node2 = arrayToList(arr2);
        test6.mergeTwoLists(node1, node2);

        int[] original = {1, 2, 3, 4, 5};
        int[] copy = new int[original.length];
        // 参数依次为：源数组、源起始位置、目标数组、目标起始位置、拷贝长度
        System.arraycopy(original, 0, copy, 1, 3);
        System.out.println(Arrays.toString(copy));
        // System.arraycopy(original, 0, copy, 0, original.length);
       // System.arraycopy(original, 0, original, 1, 2);
      //  System.out.println(Arrays.toString(original));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println("字数大小：" + test6.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("pushOne:" + Arrays.toString(test6.plusOne2(new int[]{9,9})));
        test6.generate(5);
        test6.getRow(3);
    }

    private static ListNode arrayToList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode curr = head;
        for (int i = 1; i < array.length; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return head;
    }

    public static int removeDuplicates(int[] nums) {
        int sum = 0;
        int currNumber = nums[0];
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(currNumber);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                sum++;
                currNumber = nums[i];
                myList.add(currNumber);
            }
        }
//        System.out.println(myList);
        nums = myList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums));
        return ++sum;
    }




}

