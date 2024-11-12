package Controller;

import Controller.ScannerSJ;
import views.Menu;

public class MainController {
    public static void actions(){
        int sl;
        do {
            sl = ControllerMenu.mainMenu();
            switch (sl){
                case 1://CRUD
                    do {
                        sl = ControllerMenu.crudMenu();
                        switch (sl){
                            case 1:
                                //CREATE
                                break;
                            case 2:
                                //ALTER
                                break;
                            case 3:
                                //UPDATE
                                break;
                            case 4:
                                //DELETE
                                break;
                            case 5:
                                //INSERT
                                break;
                            default:
                                break;
                        }
                    }while(sl != 5);
                    break;
                case 2:
                    //SHOW ALL DATA
                    break;
                case 3:
                    //SEARCH INFO BY DATE
                    break;
                case 4:
                    //GOOGLE SEARCH
                    break;
                default:
                    break;
            }
        }while(sl != 5);
    }
}
