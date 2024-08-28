package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardtextFiled;
    JPasswordField  pintextFiled;
    
    Login() {
        setTitle("BANK");
        setLayout(null);
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel label = new JLabel(i3);
       label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("BANKING SYSTEM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
         JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
       cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardtextFiled = new JTextField();
        cardtextFiled.setBounds(300, 150, 230, 30);
        cardtextFiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtextFiled);
                
         JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pintextFiled = new JPasswordField();
        pintextFiled.setBounds(300, 220, 230, 30);
        pintextFiled.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintextFiled);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("clear");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        
       if(ae.getSource() == clear){
        cardtextFiled.setText("");
        pintextFiled.setText("");
    }   else if(ae.getSource() == login){
        Conn c = new Conn();
        String cardnumber = cardtextFiled.getText();
        String pinnumber = pintextFiled.getText();
        String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
        try{
           ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
               } else {
      JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
        
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
    }   else if(ae.getSource() == signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    public static void main(String args[]) {
        new Login();
    }
}