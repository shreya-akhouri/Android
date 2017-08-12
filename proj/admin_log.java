import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

class admnlog extends JFrame implements ActionListener
{
JFrame Fr;
String str="";
JLabel l1,l2,l3,l4,l_pic,lmsg,l_pic2,l;
JTextField t1,t2,t3,t4;
JPanel P;
JButton b1,b2,b3,b4,b5;
Timer t;
int count;
admnlog()
{

count=1;
Fr=new JFrame();
l_pic=new JLabel();
l=new JLabel();
l_pic.setBounds(0,0,200,100);
l_pic.setIcon(new ImageIcon("C:/Users/Shreya/Desktop/pictures/indian.jpeg"));

Fr.add(l_pic);
lmsg=new JLabel("<html><body><font color=blue size=8>Restaurant Billing</font></body></html>");
Fr.add(lmsg);
lmsg.setBounds(210,30,400,50);
l_pic2=new JLabel();
l_pic2.setIcon(new ImageIcon("C:/Users/Shreya/Desktop/pictures/k4.png"));
l_pic2.setBounds(100,120,600,220);
t=new Timer(1000,new ActionListener(){
public void actionPerformed(ActionEvent k)
{
if(count==5)
count=1;

l_pic2.setIcon(new ImageIcon("C:/Users/Shreya/Desktop/pictures/"+"k"+count+".png"));
count++;
}
});
t.start();
Fr.add(l_pic2);
P= new JPanel();

P.setLayout(new GridLayout(5,2));
P.setBounds(100,400,300,250);
l1=new JLabel("Name:");
l2=new JLabel("pas:");
t1=new JTextField();
t2=new JTextField();
b1=new JButton("SAVE");
b1.addActionListener(this);
b2=new JButton("RESET");
b2.addActionListener(this);
b3=new JButton("BACK");
b3.addActionListener(this);
b4=new JButton("EXIT");
b4.addActionListener(this);
b5=new JButton("UPLOAD");
b5.addActionListener(this);
P.add(l1);
P.add(t1);
P.add(l2);
P.add(t2);
P.add(b1);
P.add(b2);
P.add(b3);
P.add(b4);
P.add(b5);
Fr.add(P);
Fr.setLayout(null);
Fr.setBounds(0,0,900,800);
Fr.setVisible(true);

}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==b1)
{
Connection conn;
PreparedStatement pst;
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","system","a");
pst=conn.prepareStatement("Insert into admn values(?,?)");

pst.setString(1,t1.getText());


pst.setString(2,t2.getText());

pst.executeUpdate();
JOptionPane.showMessageDialog(null,"DATA SAVED");

conn.close();
pst.close();
Fr.dispose();
new billing();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error-"+e);

}
}
if(k.getSource()==b2)
{

t1.setText("");
t2.setText("");


}
if(k.getSource() ==b3)
{
Fr.dispose();
new billing();
}
if(k.getSource() ==b4)
{
Fr.dispose();
}
if(k.getSource() ==b5)
{

}
}
public static void main(String kr[])
{
new admnlog();
}
}