package java_;

public class Sign {

    private Sign() {

    }

    public static volatile Sign sign = null;

    public static Sign getInstance() {
        if (sign == null) {
            synchronized (Sign.class) {
                if (sign == null) {
                    sign = new Sign();
                }
            }
        }
        return sign;
    }

    public void fun() {
        System.out.println("我是测试方法");
    }

}
