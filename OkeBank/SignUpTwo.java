package OkeBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JButton next, back;
    JRadioButton yes, no, other, single, married,eYes,eNo;
    JTextField  ssnTextField, existingAccountField, cityTextField, stateTextField, zipcodeTextField;
    JComboBox incomeTaxRange, employment;
    String formNo;
    SignUpTwo(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("PAGE 2: Additional Details");
        additionalDetails.setFont(new Font("ARIAL", Font.BOLD, 20));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("ARIAL", Font.BOLD, 20));
        income.setBounds(100, 140, 100, 30);
        add(income);

        String incomeTaxRanges[] = {"$0 - $11,600", "$11,600 - $44,725", "$44,725 - $95,375", "$95,375 - $182,100", "$182,100 - $231,250", "$231,250 - $578,125", "$578,125 or more"};
        incomeTaxRange = new JComboBox(incomeTaxRanges);
        incomeTaxRange.setBounds(300, 140, 400, 30);
        incomeTaxRange.setBackground(Color.white);
        add(incomeTaxRange);

        JLabel seniorCitizen = new JLabel("Senior Citizen");
        seniorCitizen.setFont(new Font("ARIAL", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 190, 200, 30);
        add(seniorCitizen);
        yes = new JRadioButton("Yes");
        yes.setBounds(300, 190, 60, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(450, 190, 60, 30);
        no.setBackground(Color.white);
        add(no);
        other = new JRadioButton("Prefer not to say");
        other.setBounds(600, 190, 180, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(yes);
        seniorGroup.add(no);
        seniorGroup.add(other);

        JLabel relationship = new JLabel("Relationship: ");
        relationship.setFont(new Font("ARIAL", Font.BOLD, 20));
        relationship.setBounds(100, 230, 200, 30);
        add(relationship);
        single = new JRadioButton("Single");
        single.setBounds(300, 230, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);
        married = new JRadioButton("Married");
        married.setBounds(450, 230, 120, 30);
        married.setBackground(Color.white);
        add(married);

        ButtonGroup relationshipGroup = new ButtonGroup();
        relationshipGroup.add(single);
        relationshipGroup.add(married);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("ARIAL", Font.BOLD, 20));
        occupation.setBounds(100, 280, 200, 30);
        add(occupation);

        String[] employmentStatus = {"Employed", "Retired", "Self-employed", "Unemployed", "Student", "Complicated"};
        employment = new JComboBox<>(employmentStatus);
        employment.setBounds(300, 280, 400, 30);
        employment.setBackground(Color.WHITE);
        add(employment);

        JLabel ssn = new JLabel("SSN: ");
        ssn.setFont(new Font("ARIAL", Font.BOLD, 20));
        ssn.setBounds(100, 330, 200, 30);
        add(ssn);
        ssnTextField = new JTextField();
        ssnTextField.setFont(new Font("Arial", Font.BOLD, 14));
        ssnTextField.setBounds(300, 330, 400, 30);
        add(ssnTextField);

        JLabel existingAccountLabel = new JLabel("Existing Account: ");
        existingAccountLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 380, 200, 30);
        add(existingAccountLabel);
        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 380, 100, 30);
        eYes.setBackground(Color.WHITE);
        add(eYes);
        eNo = new JRadioButton("No");
        eNo.setBounds(450, 380, 120, 30);
        eNo.setBackground(Color.white);
        add(eNo);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        relationshipGroup.add(eYes);
        relationshipGroup.add(eNo);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.RED);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(120, 460, 80, 30);
        back.addActionListener(this);
        add(back);
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.blue);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(620, 460, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 600);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String income = (String) incomeTaxRange.getSelectedItem();
        String senior = null;
        if (yes.isSelected()) {
            senior = "Yes";
        } else if (no.isSelected()) {
            senior = "No";
        } else if (other.isSelected()) {
            senior = "Prefer Not to say";
        }
        String relationship = null;
        if (single.isSelected()) {
            relationship = "Single";
        } else if (married.isSelected()) {
            relationship = "Married";
        }
        String occupation = (String) employment.getSelectedItem();
        String ssn = ssnTextField.getText();
        String existingAcc = null;
        if (eYes.isSelected()) {
            existingAcc = "Yes";
        } else if( eNo.isSelected()) {
            existingAcc = "No";
        }


        try{
            if(ssn.isEmpty()){
                JOptionPane.showMessageDialog(null,"Your SSN is Necessary");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" +
                        formNo
                        +"', '"+income
                        +"', '"+senior
                        +"', '"+relationship
                        +"', '"+occupation
                        +"', '"+ssn
                        +"', '"+existingAcc +"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formNo).setVisible(true);


            }
        }catch (Exception ae){
            System.out.println(ae);
        }
    }


    public static void main(String[] args) {new SignUpTwo("");}
}
