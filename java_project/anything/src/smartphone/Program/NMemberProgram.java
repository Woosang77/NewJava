package smartphone.Program;

import smartphone.User.Non_Member;

public class NMemberProgram extends MainProgram {
    @Override
    public void start() {
        String[] idPw;
        user = new Non_Member();
        arr = user.getMenu();
        idPw = setIdPw();
        user.setId(idPw[0]);
        user.setPw(idPw[1]);

        int num = listUp();
        switch (num){
            case 1:
                myPage();
                break;
            case 2:
                break;
        }
    }
}
