package OkeBank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class QuickBucks extends JFrame implements ActionListener {
    JButton deposit,withdraw, quickStatement,pinChange,quickBucks,balance,convert,exit;
    String pinNumber;
    QuickBucks( String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT THE WITHDRAW AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposit = new JButton("$ 100");
        deposit.setBounds(170,380,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("$ 50");
        withdraw.setBounds(355,380,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);


        quickBucks = new JButton("$ 20");
        quickBucks.setBounds(170,420,150,30);
        quickBucks.addActionListener(this);
        image.add(quickBucks);

        quickStatement = new JButton("$ 10");
        quickStatement.setBounds(355,420,150,30);
        quickStatement.addActionListener(this);
        image.add(quickStatement);
//
        pinChange = new JButton("$ 5");
        pinChange.setBounds(170,460,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);
//
//
        balance = new JButton("$ 1");
        balance.setBounds(355,460,150,30);
        balance.addActionListener(this);
        image.add(balance);

        convert = new JButton("$ 25");
        convert.setBounds(170,500,150,30);
        convert.addActionListener(this);
        image.add(convert);

        exit = new JButton("BACK");
        exit.setBounds(355,500,150,30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(2);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNumber+"'");
                int balance =0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount") ) ;
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount") ) ;
                    }
                }
                if(e.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"INSUFFICENT FUNDS");
                    return;
                }

                    Date date = new Date();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$" + amount + " Withdrawn Successfully");

                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);

            }catch (Exception ae){
                System.out.println(ae);
            }
        }

    }
    public static void main(String[] args) {
        new QuickBucks("");
    }
}

