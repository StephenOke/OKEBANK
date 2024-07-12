package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin, rePin;
    JButton change, back;
    String pinNumber;

    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN: ");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165,320,100,25);
        image.add(pinText);

         pin = new JPasswordField();
        pin.setFont(new Font("ARIAL", Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel reEnterPinText = new JLabel("Re-Enter New PIN: ");
        reEnterPinText.setForeground(Color.white);
        reEnterPinText.setFont(new Font("System", Font.BOLD, 16));
        reEnterPinText.setBounds(165,360,180,25);
        image.add(reEnterPinText);

         rePin = new JPasswordField();
        rePin.setFont(new Font("ARIAL", Font.BOLD,25));
        rePin.setBounds(330,360,180,25);
        image.add(rePin);

         change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

         back = new JButton("BANK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String newPin = pin.getText();
                String rPin = rePin.getText();

                if (!newPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "The PIN does NOT match");
                    return;
                }
                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }
                if (rPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rPin+"' where pin ='"+pinNumber+"'";
                String query2 = "update login set pin = '"+rPin+"' where pin ='"+pinNumber+"'";
                String query3 = "update signupthree set pin = '"+rPin+"' where pin ='"+pinNumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed Successfully!");
                setVisible(false);
                new Transactions(rPin).setVisible(true);

            } catch (Exception ae) {
                System.out.println(ae);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
}
