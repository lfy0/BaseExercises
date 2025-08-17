package java_;

public class Test2 {

    public static void main(String[] args) {
        //需要考虑性能问题N太大了这个方式肯定不可以，需要更好的算法，这是最简单的算法
        //2的3次方
        int M = 2;
        int N = 3;
        int s = 1;
        for (int i = 0; i < N; i++) {
            s *= M;
        }
        System.out.println("结果：" + s + "次数：" + N);
    }


}
