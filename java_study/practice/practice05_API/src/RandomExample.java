import java.util.Arrays;
import java.util.Random;

/*
    Random은 Math와 다르게 Int, double, Boolean을 반환하는 난수 전문 클래스이다.

    Random 클래스는 종자값을 가진다.
    Random r = new Random(seed);
        Random 클래스는 seed값을 가지고 난수를 만드는데, 사용자가 직접 작성할 수 있고, 안할 수도 있다.
        같은 종자값을 갖는 객체는 같은 난수를 가지게 된다.
        사용자가 seed를 작성하지 않으면, seed는 자동적으로 현재 시작을 매개변수로 가지고 난수를 만들기 때문에, 다른 값을 갖게 된다.

   Random의 nextInt의 범위는 0 <= ~ < n
 */

public class RandomExample {    //로또 번호 얻기
    public static void main(String[] args) {

        //선택번호
        int[] selectNumber = new int[6];
        Random random = new Random();
        System.out.print("선택번호 :");
        for (int i = 0; i < 6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println();

        //당첨번호
        int[] winningNumber = new int[6];
        random = new Random();
        System.out.print("당첨번호 :");
        for (int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45)+1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println();

        //당첨여부
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        Boolean result = Arrays.equals(selectNumber,winningNumber);
        System.out.print("당첨여부 : ");
        if (result){
            System.out.println("당첨!!");
        }else{
            System.out.println("탈락 ㅠㅠ");
        }
    }
}
