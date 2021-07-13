public class StringBufferExample {
    public static void main(String[] args) {
        //String 객체의 값을 자주 변경하거나 추가하는 것은 String 객체의 수를 증가시킨다.
        //그렇기 때문에 변경이나 추가가 잦은 문자열객체는 StringBuffer를 사용한다.
        StringBuffer sb = new StringBuffer();

        sb.append("Java ");
        sb.append("Program Study");
        System.out.println(sb.toString());

        sb.insert(4, "2");
        //지정 번호에 str을 추가
        System.out.println(sb.toString());

        sb.setCharAt(6, '6');
        System.out.println(sb.toString());

        sb.replace(6, 13, "Book");
        //start index부터 end index전까지 str로 교환
        System.out.println(sb.toString());

        sb.delete(4,5);
        System.out.println(sb.toString());

        int length = sb.length();
        System.out.println("총문자수 : " + length );

        String result = sb.toString();
        //StringBuffer 타입에서 수정이 없다면, String객체로 변환
        System.out.println(result);
    }
}
