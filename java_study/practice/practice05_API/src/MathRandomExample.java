public class MathRandomExample {

    //Math의 random은 하나의 기능이며, 주로 수학 메소드를 중점에 둔다.

    //임의의 주사위 눈 얻기
    public static void main(String[] args) {

        //Math Class random : 0.0 ~ 1.0 사이의 double 난수

        int num = (int) (Math.random()*6) + 1;
        //범위 : 0.0 <= Math.random < 1.0
        //실제 사용할때
        //  소수점 제거 (int) Casting
        //  1부터 시작할수있도록 변경 +1;
        System.out.println("주사위 눈 : " + num);
    }
}
