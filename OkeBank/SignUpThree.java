package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1 ,c2, c3, c4,c5,c6,c7;
    JButton submit , cancel;
    String formNo;

    SignUpThree(String formNo){
        this.formNo = formNo;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("ARIAL", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("ARIAL", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 =  new JRadioButton("Savings Account");
        r1.setFont(new Font("ARIAL", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,250,20);
        add(r1);

        r2 =  new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("ARIAL", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 =  new JRadioButton("Current Account");
        r3.setFont(new Font("ARIAL", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 =  new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("ARIAL", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("ARIAL", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-3303");
        number.setFont(new Font("ARIAL", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel cardDetail = new JLabel("YOUR 16 Digit Card Number");
        cardDetail.setFont(new Font("ARIAL", Font.BOLD, 12));
        cardDetail.setBounds(100,330,300,20);
        add(cardDetail);



        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("ARIAL", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("ARIAL", Font.BOLD, 22));
        pNumber.setBounds(330,370,300,30);
        add(pNumber);

        JLabel pinDetail = new JLabel("Your 4 Digit Pin Number");
        pinDetail.setFont(new Font("ARIAL", Font.BOLD, 12));
        pinDetail.setBounds(100,400,300,20);
        add(pinDetail);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("ARIAL", Font.BOLD, 22));
        services.setBounds(100,450,400,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("ARIAL", Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("ARIAL", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("ARIAL", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font("ARIAL", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("ARIAL", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.white);
        c6.setFont(new Font("ARIAL", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I  hereby CONSENT to giving OkeBank permission to search through any given data to verify validity.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("ARIAL", Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit  = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.BLUE);
        submit.setFont(new Font("ARIAL", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel  = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.BLUE);
        cancel.setFont(new Font("ARIAL", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);



        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Savings Account";

            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";

            } else if(r3.isSelected()){
                accountType = "Current Account";
            } else if(r4.isSelected()){
                accountType = "Reccurring Deposit Account";
            }
            Random random = new Random();
            String cardNumber =  ""+Math.abs((random.nextLong() % 90000000L) +5040936000000000L);
            String pinNumber = ""+Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility +" ATM Card";
            }else if(c2.isSelected()){
                facility = facility+" Internet Banking";
            } else if(c3.isSelected()){
                facility = facility+ " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility +"EMAIL & SMS ALERTS";
            }else if(c5.isSelected()){
                facility = facility+ " CHECKBOOK";
            }else if(c6.isSelected()){
                facility = facility+" E-Statement";
            }

            try {
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null,"Account Type is Required");
               } else {
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('" +
                           formNo
                           +"', '"+accountType
                           +"', '"+cardNumber
                           +"', '"+pinNumber
                           +"', '"+facility +"')";

                   String query2 = "insert into login values('" +
                           formNo
                           +"', '"+cardNumber
                           +"', '"+pinNumber +"')";
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);

                   JOptionPane.showMessageDialog(null,"Card Number: "+ cardNumber+"\n Pin: "+pinNumber);
                   setVisible(false);
                   new Deposit(pinNumber).setVisible(false);
               }
            }catch (Exception ae){
                System.out.println(ae);
            }

        }else if (e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);

        }
    }
}
