package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class QuickStatements extends JFrame {
    QuickStatements(String pinNumber){
        setTitle("Past Statements");
        setLayout(null);

        JLabel quick = new JLabel();
        add(quick);

        JLabel bank = new JLabel("OKE BANK");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
           Conn conn = new Conn();

           ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE  pin = '"+pinNumber+"'");
//            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE  pin = '"+pinNumber+"'");

           while(rs.next()){
               card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+ "XXXXXXXXX" + rs.getString("cardnumber").substring(12));

           }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
           Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNumber+"'");
            int bal =0;
           while(rs.next()){
               quick.setText(quick.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount") + "<br><br> <html>");
               if(rs.getString("type").equals("Deposit")){
                   bal +=Integer.parseInt(rs.getString("amount") ) ;
               } else {
                   bal -= Integer.parseInt(rs.getString("amount") ) ;
               }
           }
           balance.setText("Your Current Account Balance is $"+bal);
        }catch (Exception e){
            System.out.println(e);
        }

        quick.setBounds(20,140,400,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new QuickStatements("");
    }
}
