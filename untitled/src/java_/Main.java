package java_;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("不换门选中次数：" + test(true));
        System.out.println("换门选中次数：" +test(false));
    }

    static int[] arr = new int[3];

    private static int test(boolean reSelect) {

        arr[0] = 1;//1代表车0代表羊
        arr[1] = 0;
        arr[2] = 0;
        int count = 0;
        {
            for (int i = 0; i < 100000; i++) {//模拟100000次选择
                int selectValue;
                int select = new Random().nextInt(arr.length);
                selectValue = arr[select];//第一次三个里面选一个

                int[] targetArr = new int[2];
                if (selectValue == 1) {//选中了的情况
                    targetArr[0] = selectValue;//targetArr[0] 为当前选中的值，选中的就是有车的
                    targetArr[1] = 0;//targetArr[1] 为另一扇门的值
                } else {//没选中的情况
                    targetArr[0] = 0;//targetArr[0] 为当前选中的值,当前选中的是无车的
                    targetArr[1] = 1;//排除掉一个是羊之后，另一个肯定是车
                }
                if (reSelect)//不换门
                    count += targetArr[0];
                else//换门
                    count += targetArr[1];
            }
            return count;

        }
    }

    void fun() {
        Sign.getInstance().fun();
    }
}