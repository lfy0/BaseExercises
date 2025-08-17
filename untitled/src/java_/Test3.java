package java_;

public class Test3 {

    public static void main(String[] args) {
        //只能算平方根是整数的
//        int M = 1;
//        int M = 4;
        // int M = 8;
        int M = 16;
        if (M == 1) System.out.println(M);
        for (int i = 1; i <= M / 2; i++) {
            if (i * i == M) {
                System.out.println(i);
                return;
            } else {
                if (i == M / 2) {
                    System.out.println("未找出");
                    return;
                }
            }
        }
    }


}
