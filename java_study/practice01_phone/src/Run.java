public class Run {
    public static void main(String[] args) {
        Tool tool = new Tool();
        boolean unlock = tool.unlock();
        while (unlock ==true) {
            tool.start();
        }
    }
}
