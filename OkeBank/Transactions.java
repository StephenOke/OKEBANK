package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdraw, quickStatement,pinChange,quickBucks,balance,convert,exit;
    String pinNumber;
    Transactions( String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

         deposit = new JButton("Deposit");
        deposit.setBounds(170,380,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

         withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(355,380,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);


        quickBucks = new JButton("Quick Bucks");
        quickBucks.setBounds(170,420,150,30);
        quickBucks.addActionListener(this);
        image.add(quickBucks);

        quickStatement = new JButton("Quick Statements");
        quickStatement.setBounds(355,420,150,30);
        quickStatement.addActionListener(this);
        image.add(quickStatement);
//
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,460,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);
//
//
        balance = new JButton("Balance");
        balance.setBounds(355,460,150,30);
        balance.addActionListener(this);
        image.add(balance);

        convert = new JButton("Convert");
        convert.setBounds(170,500,150,30);
        convert.addActionListener(this);
        image.add(convert);

        exit = new JButton("Exit");
        exit.setBounds(355,500,150,30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        } else if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (e.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);

        } else if (e.getSource() == quickBucks){
            setVisible(false);

             new QuickBucks(pinNumber).setVisible(true);
        } else if(e.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (e.getSource() == balance){
            setVisible(false);
            new Balance(pinNumber).setVisible(true);
        } else if (e.getSource() == quickStatement){
            new QuickStatements(pinNumber).setVisible(true);
        }

    }
}
