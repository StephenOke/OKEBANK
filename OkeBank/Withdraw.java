package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinNumber;
    Withdraw(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("How Much Would You Like to Withdraw? ");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("ARIAL", Font.BOLD,22));
        amount.setBounds(170,350,320,20);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,460,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,500,150,30);
        back.addActionListener(this);
        image.add(back);





        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String[] args) {new Withdraw("");}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount You Want To Withdraw");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+ pinNumber +"', '"+date+"', 'Withdraw', '"+ number +"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$ " + number + " Withdrawn Successfully.");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception ae){
                    System.out.println(ae);
                }
            }

        }else if ( e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
}
