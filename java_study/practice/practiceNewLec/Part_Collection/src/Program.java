import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);

        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(5);
        set.add(6);
        set.add(7);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int num = iterator.next();
            System.out.printf("%d, ", num);
        }
        System.out.println();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("title", "Hello");
        map.put("hit", 12);

        System.out.println(map.get("title"));

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d, ", list.get(i));
        }

//        num = (Integer)list.get(1);
//        System.out.printf("num : %d\n",num);

        /*
        정작 Object Class로 담아 데이터의 다양성을 높였지만, 출력할 때 형식을 맞춰야되는 문제가 발생한다.
        --> Generic
         */
    }
}
