package Gleb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Created by Глеб on 27.09.2014.
 */

public class Authorization extends JFrame{
    private Timer timer = new Timer();
    private static final String log = "1";
    private static final String pas = "1";

    public void NoAuthorization() {
        JLabel label = new JLabel("An incorrect login or password!");
        label.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(label);
        pack();
        setResizable(false);
        setVisible(true);
    }

    public Authorization() {
        super("Authorization");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box box1 = Box.createHorizontalBox();
        JLabel login = new JLabel("Login : ");
        final JTextField textLogin = new JTextField(15);
        box1.add(login);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(textLogin);

        Box box2 = Box.createHorizontalBox();
        JLabel password = new JLabel("Password : ");
        final JPasswordField textPassword = new JPasswordField(15);
        box2.add(password);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(textPassword);

        login.setPreferredSize(password.getPreferredSize());

        Box box3 = Box.createHorizontalBox();
        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textLogin.getText().equals(log)
                        && textPassword.getText().equals(pas)) {
                    setVisible(false);
                } else {
                    NoAuthorization();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1500);
                                setVisible(false);
                                new Authorization();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 0);

                }
            }
        });
        JButton cancle = new JButton("Cancle");
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        box3.add(Box.createHorizontalGlue());
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(cancle);
        Box box = Box.createVerticalBox();
        box.setBorder(new EmptyBorder(12, 12, 12, 12));
        box.add(box1);
        box.add(Box.createVerticalStrut(6));
        box.add(box2);
        box.add(Box.createVerticalStrut(6));
        box.add(box3);
        setContentPane(box);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
