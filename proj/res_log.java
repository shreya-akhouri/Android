import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class log implements ActionListener
{
JFrame Fr;
JLabel l1,l2,l3,l_pic,lmsg,l_pic2;
JTextField t1,t2;
JPanel P;
JButton b1,b2,b3,b4;
Timer t;
int count;
log()
{

count=1;
Fr=new JFrame();
l_pic=new JLabel();
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


}
public void actionPerformed(ActionEvent k)
{


}
public static void main(String kr[])
{
new log();
}
}