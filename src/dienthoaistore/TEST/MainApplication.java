package dienthoaistore.TEST;

import dienthoaistore.GUI.Login;

/**
 *
 * @author THANH NHAN
 */
public class MainApplication {

    public static void main(String[] args) {
        com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme.setup();
        
        Login login = new Login();
        
        login.setVisible(true);
    }
}
