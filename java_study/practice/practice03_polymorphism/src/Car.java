public class Car {

    Tire[] tires = {
            new Tire(6,"앞왼쪽"),
            new Tire(2, "앞오른쪽"),
            new Tire(3, "뒤왼쪽"),
            new Tire(4, "뒤오른쪽")
    };

    int run(){
        for (int i = 0; i < tires.length; i++) {
            if (tires[i].roll()==false){
                stop();
                return i+1;
            }
        }
        return 0;
    }

    void stop(){
        System.out.println("자동차 정지");
    }
}
