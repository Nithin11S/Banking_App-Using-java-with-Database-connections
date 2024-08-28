
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;



public class Deposit  extends JFrame implements ActionListener{
    JTextField amount;
     JButton deposit,back;
    String pinnumber;
   Deposit(String pinnumber){
       this.pinnumber = pinnumber;
       
       setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
       
       JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
       
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
         deposit = new JButton("DEPOSIT");
         deposit.setBounds(355, 485, 150, 30);
         deposit.addActionListener(this);
        image.add(deposit);
         
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(960,1080);
        //setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
   }
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == deposit ){
        String number = amount.getText();
        Date date = new Date();
        if(number.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
        } else {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                int depositAmount = Integer.parseInt(number);
                if (balance == 0 && depositAmount < 500) {
                    JOptionPane.showMessageDialog(null, "Minimum balance of Rs 500 should be maintained.");
                } else {
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Deposited Successfully");
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } else if (ae.getSource()  == back){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
   
    public static void main(String args[]) {
        new Deposit("");
    }
}
