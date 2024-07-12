package OkeBank;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login  extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("OKEBANK ATM");
        setLayout(null);
        ImageIcon i0 = new ImageIcon(ClassLoader.getSystemResource("icons/atmLogo.jpg"));
        Image i1 = i0.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(i0);
        label.setBounds(70,10,100,100);
        add(label);
        JLabel text = new JLabel("WELCOME TO THE ATM");
        text.setFont(new Font("NEW TIMES ROMAN",Font.BOLD,30));
        getContentPane().setBackground(Color.WHITE);
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardNO = new JLabel("CARD NO: ");
        cardNO.setFont(new Font("Raleway",Font.BOLD,20));
        getContentPane().setBackground(Color.WHITE);
        cardNO.setBounds(120,150,230,40);
        add(cardNO);
            cardTextField = new JTextField();
            cardTextField.setBounds(300,150,230,30);
            cardTextField.setFont(new Font("Arial",Font.BOLD,14));
            add(cardTextField);

        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        getContentPane().setBackground(Color.WHITE);
        pin.setBounds(180,220,250,30);
        add(pin);
            pinTextField = new JPasswordField();
            pinTextField.setBounds(300,220,230,30);
            pinTextField.setFont(new Font("Arial",Font.BOLD,14));
            add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.blue);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
            getContentPane().setBackground(Color.white);


        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource() == login){
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "SELECT * from login WHERE cardnumber = '" +
                    cardNumber +"' and pin = '"+pinNumber +"'";
            try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinNumber).setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            }catch (Exception ae){
                System.out.println(ae);
            }

        } else if (e.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }


}
