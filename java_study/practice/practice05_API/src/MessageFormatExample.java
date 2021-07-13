import java.text.MessageFormat;

public class MessageFormatExample {
    public static void main(String[] args) {
        String id = "java";
        String name = "오복";
        String tel = "010-1234-5678";

        String text = "회원 ID: {0} \n회원 이름: {1} \n회원 전화: {2}";
        String result = MessageFormat.format(text, id, name, tel);
        System.out.println(result);
        System.out.println();

        String sql = "insert into member values({0}, {1}, {2})";
        Object[] argument = {"'java'", "'오복'", "'010-1234-5678'"};
        String result2 = MessageFormat.format(sql, argument);
        System.out.println(result2);
    }
}
