package view;

import control.control;

import javax.swing.*;
import java.awt.*;

public class view extends JFrame{
    private JLabel userName;
    private JLabel passWord;
    private static JTextField user;
    private static JPasswordField pass;
    private static JButton login;
    private static JButton cancel;


    public view(){
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        setVisible(true);

    }

    public void buildPanel(){
        userName = new JLabel("username");
        passWord = new JLabel("password");
        user = new JTextField(20);
        pass = new JPasswordField(20);
        login = new JButton("Login");
        login.addActionListener(new control.eventButton());
        cancel = new JButton("Cancel");

        JPanel panel = new JPanel();
        panel.add(userName);
        panel.add(user);
        panel.add(passWord);
        panel.add(pass);
        panel.add(login);
        panel.add(cancel);

        add(panel);
    }

    public static JTextField getUser() {
        return user;
    }

    public static JPasswordField getPass() {
        return pass;
    }

    public static JButton getLogin() {
        return login;
    }

    public static JButton getCancel() {
        return cancel;
    }
}
