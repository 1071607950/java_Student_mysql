package manager;
import java.awt.event.*;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;

import main.Jdbc;
import main.Student;
public class addscore extends JPanel{
	public addscore(){
		this.setLayout(null);
		Student.jnumber=new JLabel("学号"); 
		Student.tnumber=new JTextField();
		Student.jkcname=new JLabel("课程名称");
		Student.tkcname=new JTextField();
		Student.jterm=new JLabel("学期");
		Student.tterm=new JTextField();
		Student.jscore=new JLabel("成绩");
		Student.tscore=new JTextField();
		Student.jcredit=new JLabel("学分");
		Student.tcredit=new JTextField();
		Student.button1=new JButton("添加");
		Student.button2=new JButton("取消");
        //设置控件的位置和大小
		Student.jnumber.setBounds(30,20,60,30);
		Student.jkcname.setBounds(30,70,60,26);
		Student.jterm.setBounds(30,120,60,26);
		Student.jscore.setBounds(30,170,60,26);
		Student.jcredit.setBounds(30,220,60,26);
		Student.tnumber.setBounds(110,20,120,26);
		Student.tkcname.setBounds(110,70,120,26);
		Student.tterm.setBounds(110,120,120,26);
		Student.tscore.setBounds(110,170,120,26);
		Student.tcredit.setBounds(110,220,120,26);
		Student.button1.setBounds(30,370,60,26);
		Student.button2.setBounds(110,370,60,26);
        //将控件添加到容器中
        this.add(Student.jnumber);
        this.add(Student.tnumber);
        this.add(Student.jkcname);
        this.add(Student.tkcname);
        this.add(Student.jterm);
        this.add(Student.tterm);
        this.add(Student.jscore);
        this.add(Student.tscore);
        this.add(Student.jcredit);
        this.add(Student.tcredit);
        this.add(Student.button1);
        this.add(Student.button2);
        Student.button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(!Student.tnumber.getText().matches("^\\d{1,10}$")) {
        			JOptionPane.showMessageDialog(null,"学号长度在1~10之间，只能包含数字！","添加",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		else if(!Student.tkcname.getText().matches("^[\\u4E00-\\u9FA5A-Za-z0-9]{1,20}$")) {
            		JOptionPane.showMessageDialog(null,"课程长度在1~20之间，只能包含中文、英文、数字！","添加",JOptionPane.WARNING_MESSAGE);
            		return;
        		}
        		else if(!Student.tterm.getText().matches("^\\d{1,10}$")) {
            		JOptionPane.showMessageDialog(null,"学期长度在1~10之间，只能包含数字！","添加",JOptionPane.WARNING_MESSAGE);
            		return;
        		}
        		else if(!Student.tscore.getText().matches("^\\d{1,10}$")) {
                	JOptionPane.showMessageDialog(null,"成绩长度在1~10之间，只能包含数字！","添加",JOptionPane.WARNING_MESSAGE);
                	return;
        		}
                else if(!Student.tcredit.getText().matches("^\\d{1,10}$")) {
                    JOptionPane.showMessageDialog(null,"学分长度在1~10之间，只能包含数字！","添加",JOptionPane.WARNING_MESSAGE);
                    return;
        		}
                else{
                	//调用Jdbc
                	try {
                		Jdbc.insert("insert into stuscore values('"
            					+Student.tnumber.getText().toString().trim()
            					+"','"+Student.tkcname.getText().toString().trim()
            					+"','"+Student.tterm.getText().toString().trim()
            					+"','"+Student.tscore.getText().toString().trim()
            					+"','"+Student.tcredit.getText().toString().trim()
            					/*+"','"+String.valueOf(
            							Integer.valueOf(Student.tkcname.getText().trim())+
                            			Integer.valueOf(Student.tterm.getText().trim())+
                            			Integer.valueOf(Student.tscore.getText().trim())+
                            			Integer.valueOf(Student.tcredit.getText().trim())
                            			)**/
            					+"')");
                	}catch(SQLIntegrityConstraintViolationException a){
                		JOptionPane.showMessageDialog(null,"学号不存在！","添加",JOptionPane.ERROR_MESSAGE);
                	}catch(Exception e1) {
            			e1.printStackTrace();
                	}
					Student.updatescore("select * from stuscore");
                }
			}
		});
        Student.button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Student.tnumber.setText("");
				Student.tkcname.setText("");
				Student.tterm.setText("");
				Student.tscore.setText("");
				Student.tcredit.setText("");
			}
		});
		//this.setVisible(true);
	}     	
}

