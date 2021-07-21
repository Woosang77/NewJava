package Alphabet;

public class A {
    private X x;

    //도킹장치
    public void setX(X x) {
        this.x = x;
    }

    public A() {
    }

    public void print() {
        int total = x.total();
        System.out.printf("total is %d\n",total);
    }
}
