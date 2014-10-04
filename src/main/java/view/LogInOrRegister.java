package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eugene on 02.10.14.
 */
public class LogInOrRegister {

    public LogInOrRegister(){

    }

    public void SingUpIn(boolean visible){

        JFrame frame = new JFrame("Log in or register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Log in or create an account");

        JPanel labelPanel= new JPanel();
        label.setLayout(new BorderLayout());

        labelPanel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton signIn = new JButton("Sign in");
        JButton signUp = new JButton("Sign Up");

        buttonPanel.add(signIn);
        buttonPanel.add(signUp);

        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(labelPanel, BorderLayout.NORTH);

        frame.getContentPane().add(panel);

        frame.setVisible(visible);



    }

}
