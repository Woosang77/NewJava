package Newlec.Collection_Part;

public class IntList {
    //정수형만을 받는 List
    private int[] nums;
    private int current;

    public IntList() {
        nums = new int[3];
        current = 0;
    }

    public void add(int num) {
        nums[current] = num;
        current++;
    }

    public void clear() {
        current = 0;
        //삭제하지 않아도 덮어쓴다.
    }

    public int size() {
        return current;
    }

    public int get(int index) {
        if (current <= index){
            throw new IndexOutOfBoundsException();
        }
        return nums[index];
    }
    /*
    지금은 정수형만을 담을 수 있지만,
    String, double, float...등 모든 형식의 데이터를 담을 수 있다면??
        --> Object Class : 모든 클래스의 부모 클래스 (최상위 추상 클래스)
         But, Object 클래스는 참조형식이라 객체를 담을 수는 있지만, 데이터를 담을 수는 없다.
         ==> Wrapper Class : primitive데이터를 감싸 객체로 만들어주는 클래스
            (Boxing) Object obj = new Integer(3);
            (Unboxing) int x = obj.intValue();

            *지금은 Boxing, Unboxing 모두 자동으로 된다.(개념적 이해 필요)
     */
}
