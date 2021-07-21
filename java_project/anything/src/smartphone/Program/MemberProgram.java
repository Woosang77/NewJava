package smartphone.Program;

import smartphone.User.Member;

public class MemberProgram extends MainProgram {
    @Override
    public void start() {

        String[] idPw;
        user = new Member();
        arr = user.getMenu();
        idPw = setIdPw();
        user.setId(idPw[0]);
        user.setPw(idPw[1]);

        int num = listUp();
        switch (num){
            case 1:
                phone();
                break;
            case 2:
                myPage();
                break;
            case 3:
                System.out.printf("Bye, %s",user.getId());
                break;
        }
    }
}
