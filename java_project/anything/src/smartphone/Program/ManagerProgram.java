package smartphone.Program;

import smartphone.User.Manager;

public class ManagerProgram extends MainProgram {
    @Override
    public void start() {
        String[] idPw;
        user = new Manager();
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
                System.out.printf("Bye, %s",user.getId());
                break;
        }
    }
}
