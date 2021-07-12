public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;


        rc = new Audio();
        rc.turnOn();
        rc.turnOff();
        rc.setMute(true);
        rc.setMute(false);

    }
}
