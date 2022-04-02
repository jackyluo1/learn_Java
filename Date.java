class a {
    public static void main(String[] args) {
        int x = 0;
        Date y = new Date(0);
        System.out.println(x);
        System.out.println(y.num);
        System.err.println("--");
        pro(x, y);
        System.err.println("--");
        System.out.println(x);
        System.out.println(y.num);
    }

    public static void pro(int m, Date n) {
        System.out.println(m);
        System.out.println(n.num);
        m = 1;
        n.num = 1;
        System.out.println(m);
        System.out.println(n.num);
    }
}

class Date {
    int num;

    public Date(int num) {
        this.num = num;
    }
}