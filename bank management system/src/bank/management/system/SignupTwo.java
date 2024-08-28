package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JComboBox religion, category, ocupation, education,income,seniorcitizen,existingaccount;
    String formno;

   SignupTwo(String formno){
       this.formno = formno;
       setLayout(null);
       
       setTitle("NEWACCOUNT APPLICATION FORM - PAGE 2");
              
       
        JLabel additionalDetails = new JLabel("Page 2: Additional Details" );
       additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
       additionalDetails.setBounds(290, 80, 400, 30);
       add(additionalDetails);
       
        JLabel name = new JLabel("Religion:");
       name.setFont(new Font("Raleway", Font.BOLD, 20));
       name.setBounds(100, 140, 100, 30);
       add(name);
       
       String valReligion[] = {"Hindu","Muslim","Christian","Other"};
        religion = new JComboBox(valReligion);
       religion.setBounds(300, 140, 400, 30);
       religion.setBackground(Color.WHITE);
       add(religion);
           
        JLabel fname = new JLabel("Category:");
       fname.setFont(new Font("Raleway", Font.BOLD, 20));
       fname.setBounds(100, 190, 200, 30);
       add(fname);
       
       String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
       category.setBackground(Color.WHITE);
          category.setBounds(300, 190, 400, 30);
       add(category);
       
       
        JLabel dob = new JLabel("Income:");
       dob.setFont(new Font("Raleway", Font.BOLD, 20));
       dob.setBounds(100, 240, 200, 30);
       add(dob);
       
        String valincome[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(300, 240, 400, 30);
       income.setBackground(Color.WHITE);
       add(income);
       
       JLabel gender = new JLabel("Educational");
       gender.setFont(new Font("Raleway", Font.BOLD, 20));
      gender.setBounds(100, 290, 200, 30);
       add(gender);
      

       
        JLabel email = new JLabel("Qualification:");
       email.setFont(new Font("Raleway", Font.BOLD, 20));
      email.setBounds(100, 315, 200, 30);
       add(email);
       
        String educationalValues[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(educationalValues);
        education.setBounds(300, 315, 400, 30);
       education.setBackground(Color.WHITE);
       add(education);
       
       
        JLabel marital = new JLabel("Ocupation:");
       marital.setFont(new Font("Raleway", Font.BOLD, 20));
      marital.setBounds(100, 390, 200, 30);
       add(marital);
       
        String ocupationalValues[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        ocupation = new JComboBox(ocupationalValues);
        ocupation.setBounds(300, 390, 400, 30);
       ocupation.setBackground(Color.WHITE);
       add(ocupation);
      
       
        JLabel Address = new JLabel("Pan Number:");
       Address.setFont(new Font("Raleway", Font.BOLD, 20));
      Address.setBounds(100, 440, 200, 30);
       add(Address);
       
       pan = new JTextField();
       pan.setFont(new Font("Raleway", Font.BOLD, 14));
       pan.setBounds(300, 440, 400, 30);
       add(pan);
       
        JLabel city = new JLabel("Adhar Number:");
       city .setFont(new Font("Raleway", Font.BOLD, 20));
      city .setBounds(100, 490, 200, 30);
       add(city);
       
        aadhar = new JTextField();
       aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
       aadhar.setBounds(300, 490, 400, 30);
       add(aadhar);
       
       JLabel ssd = new JLabel("Senior Citizen:");
       ssd .setFont(new Font("Raleway", Font.BOLD, 20));
      ssd .setBounds(100, 540, 200, 30);
       add(ssd);
       
        String senior[] = {"Yes","NO"};
        seniorcitizen = new JComboBox(senior);
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
      seniorcitizen.setBounds(300, 540, 200, 30);
       add(seniorcitizen);
       
       JLabel vsd = new JLabel("Existing Account:");
       vsd .setFont(new Font("Raleway", Font.BOLD, 20));
      vsd .setBounds(100, 590, 200, 30);
       add(vsd);
       
       
        String existing[] = {"Yes","NO"};
        existingaccount = new JComboBox(existing);
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
      existingaccount.setBounds(300, 590, 200, 30);
       add(existingaccount);
     
       
       next = new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway", Font.BOLD, 14));
       next.setBounds(620, 660, 80, 30);
       next.addActionListener(this);
       add(next);
       
       getContentPane().setBackground(Color.WHITE);
       setSize(850, 800);
       setLocation(350, 10);
       setVisible(true);
       
   }
   
   public void actionPerformed(ActionEvent ae){
       String sreligion = (String)religion.getSelectedItem(); 
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String socupation = (String)ocupation.getSelectedItem();
        String sseniorcitizen = (String)seniorcitizen.getSelectedItem();
        String sexistingaccount = (String)existingaccount.getSelectedItem();
         String span = pan.getText();
        String saadhar = aadhar.getText();
        
 
      
        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+socupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexistingaccount+"')";
                c.s.executeUpdate(query);
               
      setVisible(false);
      new SignupThree(formno).setVisible(true);
                    
       } catch (Exception e){
          System.out.println(e);
      }
    
               
    }
   
   
    public static void main(String args[]) {
        new SignupTwo("");
    }
}