package control;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.database.*;

import static java.lang.System.exit;
import static view.view.*;

public class control {

    public static class eventButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == getLogin()){
                if(getUser().getText() == "" || getPass().getText() == ""){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame,
                            "error!!!",
                            "error",
                            JOptionPane.ERROR_MESSAGE);
                }else{
                    try {
                        createConnection();
                        ResultSet resultSet = select("*","account","username ='"+getUser().getText()+"';");
                        resultSet.next();
                        String check = resultSet.getString("pass");
                        String pass = getPass().getText();


                        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                        if(pass.equals(check)){
                            JOptionPane.showMessageDialog(frame, "Successfully login.");
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Login fail.");
                        }



                        closeDB(getConnection());
                    } catch (SQLException ex) {
                        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                        JOptionPane.showMessageDialog(frame,
                                "error!!!",
                                "error",
                                JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
            } else if (e.getSource() == getCancel()) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                int result = JOptionPane.showConfirmDialog(frame,
                        "are you sure",
                        "confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if(result == JOptionPane.YES_OPTION){
                    exit(0);
                }
            }
        }
    }
}
