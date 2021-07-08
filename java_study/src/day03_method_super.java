public class day03_method_super {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}

class Airplane {
    public void land(){
        System.out.println("착륙");
    }
    public void fly(){
        System.out.println("비행");
    }
    public void takeOff(){
        System.out.println("이륙");
    }
}

class SupersonicAirplane extends Airplane {
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL;

    @Override
    public void fly() {
        if (flyMode==SUPERSONIC){
            System.out.println("초음속비행중");
        }else{
            super.fly();        //Override 중 super의 사용
        }
    }
}

