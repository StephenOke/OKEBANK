package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;
import java.util.Random;
import java.awt.event.*;
//import com.jcalendar.*;
public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JButton next;
    JRadioButton male,female,other;
    JTextField nameTextField,dateTextField, emailTextField,addressTextField,cityTextField,stateTextField,zipcodeTextField;
    SignUpOne(){
        setLayout(null);

        Random rand = new Random();
         random = Math.abs(rand.nextLong() % 9000L + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO."+ random);
        formNo.setFont(new Font("ARIAL", Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personDetails = new JLabel("1. PERSONAL INFORMATON.");
        personDetails.setFont(new Font("ARIAL", Font.BOLD,20));
        personDetails.setBounds(280,60,400,30);
        add(personDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("ARIAL", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel DOB = new JLabel("Date Of Birth: ");
        DOB.setFont(new Font("ARIAL", Font.BOLD,20));
        DOB.setBounds(100,190,200,30);
        add(DOB);
         dateTextField = new JTextField();
        dateTextField.setFont(new Font("Arial",Font.BOLD,14));
        dateTextField.setBounds(300,190,400,30);
        add(dateTextField);







        JLabel gender = new JLabel("sex:");
        gender.setFont(new Font("ARIAL", Font.BOLD,20));
        gender.setBounds(100,240,200,30);
        add(gender);
         male = new JRadioButton("Male");
        male.setBounds(300,240,60,30);
        male.setBackground(Color.WHITE);
        add(male);
         female = new JRadioButton("female");
        female.setBounds(450,240,120,30);
        female.setBackground(Color.white);
        add(female);
         other = new JRadioButton("Prefer not to say");
        other.setBounds(600,240,180,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);


        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("ARIAL", Font.BOLD,20));
        email.setBounds(100,290,200, 30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,14));
        emailTextField.setBounds(300,290,400,30);
        add(emailTextField);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("ARIAL", Font.BOLD,20));
        address.setBounds(100,340,200,30);
        add(address);

         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,14));
        addressTextField.setBounds(300,340,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City: ");
        city.setFont(new Font("ARIAL", Font.BOLD,20));
        city.setBounds(100,390,200,30);
        add(city);

         cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,14));
        cityTextField.setBounds(300,390,400,30);
        add(cityTextField);

        JLabel state =new JLabel("State: ");
        state.setFont(new Font("ARIAL", Font.BOLD,20));
        state.setBounds(100,440,200,30);
        add(state);

         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial",Font.BOLD,14));
        stateTextField.setBounds(300,440,400,30);
        add(stateTextField);

        JLabel zipCode =new JLabel("Zipcode: ");
        zipCode.setFont(new Font("ARIAL", Font.BOLD,20));
        zipCode.setBounds(100,490,200,30);
        add(zipCode);

         zipcodeTextField = new JTextField();
        zipcodeTextField.setFont(new Font("Arial",Font.BOLD,14));
        zipcodeTextField.setBounds(300,490,400,30);
        add(zipcodeTextField);

         next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.blue);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBounds(620,560,80,30);
        next.addActionListener(this);
        add(next);


    
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
      String formNo = ""+random;
      String name = nameTextField.getText();
      String email = emailTextField.getText();
      String address = addressTextField.getText();
      String DOB = dateTextField.getText();
        String gender = null;
        if(male.isSelected()){
            gender  = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        } else if (other.isSelected()){
            gender = "Prefer Not to say";
        }
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      String zipcode = zipcodeTextField.getText();

      try{
          if(name.isEmpty()){
              JOptionPane.showMessageDialog(null,"Your Name is Necessary");
          } else {
              Conn c = new Conn();
              String query = "insert into signup values('" +
                            formNo+
                      "', '"+name
                      +"', '"+DOB
                      +"', '"+gender
                      +"', '"+email
                      +"', '"+address
                      +"', '"+city
                      +"', '"+state
                      +"', '"+zipcode+"')";
              c.s.executeUpdate(query);
              setVisible(false);
              new SignUpTwo(formNo).setVisible(true);
          }
      }catch (Exception ae){
          System.out.println(ae);
      }
    }
    public static void main(String[] args) {
        new SignUpOne();
    }

}
