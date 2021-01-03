package manager;
import java.awt.event.*;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;

import main.Jdbc;
import main.Student;
public class deleteinfo extends JPanel{
	public deleteinfo(){
		this.setLayout(null);
		Student.jnumber=new JLabel("学号");
        Student.tnumber=new JTextField();
        Student.jname=new JLabel("姓名");
        Student.tname=new JTextField();
        Student.jgender=new JLabel("性别");
        Student.tgender=new JTextField();
        Student.jnation=new JLabel("民族");
        Student.tnation=new JTextField();
        Student.jbloodtype=new JLabel("血型");
        Student.tbloodtype=new JTextField();
        Student.jbirthday=new JLabel("出生日期");
        Student.tbirthday=new JTextField();
        Student.jyxname=new JLabel("院系");
        Student.tyxname=new JTextField();
        Student.jzyname=new JLabel("专业");
        Student.tzyname=new JTextField();
        Student.jbjname=new JLabel("班级");
        Student.tbjname=new JTextField();
        Student.button1=new JButton("删除");
        Student.button2=new JButton("取消");
        //设置控件的位置和大小
        Student.jnumber.setBounds(30,20,60,26);
        Student.jname.setBounds(30,60,60,26);
        Student.jgender.setBounds(30,100,60,26);
        Student.jnation.setBounds(30,140,60,26);
        Student.jbloodtype.setBounds(30,180,60,26);
        Student.jbirthday.setBounds(30,220,60,26);
        Student.jyxname.setBounds(30,260,60,26);
        Student.jzyname.setBounds(30,300,60,26);
        Student.jbjname.setBounds(30,340,60,26);
        Student.tnumber.setBounds(110,20,120,26);
        Student.tname.setBounds(110,60,120,26);
        Student.tgender.setBounds(110,100,120,26);
        Student.tnation.setBounds(110,140,120,26);
        Student.tbloodtype.setBounds(110,180,120,26);
        Student.tbirthday.setBounds(110,220,120,26);
        Student.tyxname.setBounds(110,260,120,26);
        Student.tzyname.setBounds(110,300,120,26);
        Student.tbjname.setBounds(110,340,120,26);
        Student.button1.setBounds(30,380,60,26);
        Student.button2.setBounds(110,380,60,26);
        
        Student.tnumber.setEditable(false);
        Student.tname.setEditable(false);
        Student.tgender.setEditable(false);
        Student.tnation.setEditable(false);
        Student.tbloodtype.setEditable(false);
        Student.tbirthday.setEditable(false);
        Student.tyxname.setEditable(false);
        Student.tzyname.setEditable(false);
        Student.tbjname.setEditable(false);
        //将控件添加到容器中
        this.add(Student.jnumber);
        this.add(Student.tnumber);
        this.add(Student.jname);
        this.add(Student.tname);
        this.add(Student.jgender);
        this.add(Student.tgender);
        this.add(Student.jnation);
        this.add(Student.tnation);
        this.add(Student.jbloodtype);
        this.add(Student.tbloodtype);
        this.add(Student.jbirthday);
        this.add(Student.tbirthday);
        this.add(Student.jyxname);
        this.add(Student.tyxname);
        this.add(Student.jzyname);
        this.add(Student.tzyname);
        this.add(Student.jbjname);
        this.add(Student.tbjname);
        this.add(Student.button1);
        this.add(Student.button2);
        Student.button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(!Student.tnumber.getText().matches("^\\d{1,10}$")) {
        			JOptionPane.showMessageDialog(null,"学号长度在1~10之间，只能包含数字！","添加",JOptionPane.WARNING_MESSAGE);
        			return;
        			}
        		else if(!Student.tname.getText().matches("^[\\u4E00-\\u9FA5A-Za-z0-9]{1,20}$")) {
            		JOptionPane.showMessageDialog(null,"姓名长度在1~20之间，只能包含中文、英文、数字！","添加",JOptionPane.WARNING_MESSAGE);
            		return;
        			}
        		else if(!Student.tgender.getText().matches("^\\u7537|\\u5973$")) {
            		JOptionPane.showMessageDialog(null,"性别只能为 男或女！","添加",JOptionPane.WARNING_MESSAGE);
            		return;
        			}
        		else if(!Student.tnation.getText().matches("^[\\u4e00-\\u9fa5]{1,2}$")) {
                	JOptionPane.showMessageDialog(null,"民族长度在1~2之间，只能包含中文！","添加",JOptionPane.WARNING_MESSAGE);
                	return;
        			}
                else if(!Student.tbloodtype.getText().matches("^[A-Za-z]{1,2}$")) {
                    JOptionPane.showMessageDialog(null,"血型长度在1~2之间，只能包含字母！","添加",JOptionPane.WARNING_MESSAGE);
                    return;
        			}
                else if(!Student.tbirthday.getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2}")) {
                    JOptionPane.showMessageDialog(null,"出生日期格式为 1900-01-01！","添加",JOptionPane.WARNING_MESSAGE);
        			return;
        			}
                else if(!Student.tyxname.getText().matches("^[\\u4E00-\\u9FA5A-Za-z0-9]{1,20}$")) {
                    JOptionPane.showMessageDialog(null,"院系长度在1~20之间，只能包含中文、英文、数字" , "添加",JOptionPane.WARNING_MESSAGE);
                    return;
        		}
                else if(!Student.tzyname.getText().matches("^[\\u4E00-\\u9FA5A-Za-z0-9]{1,20}$")) {
                    JOptionPane.showMessageDialog(null,"专业长度在1~20之间，只能包含中文、英文、数字！","添加",JOptionPane.WARNING_MESSAGE);
                    return;
        		}
                else if(!Student.tbjname.getText().matches("^[\\u4E00-\\u9FA5A-Za-z0-9]{1,20}$")) {
                    JOptionPane.showMessageDialog(null,"班级长度在1~20之间，只能包含中文、英文、数字！","添加",JOptionPane.WARNING_MESSAGE);
                    return;
        		}
                else{
        				//调用Jdbc
        				try {
        					Jdbc.delete("delete from students where number='"+
                					Student.tnumber.getText().toString().trim()
        							+"' and name='"+Student.tname.getText().toString().trim()
        							+"' and gender='"+Student.tgender.getText().toString().trim()
        							+"' and nation='"+Student.tnation.getText().toString().trim()
        							+"' and bloodtype='"+Student.tbloodtype.getText().toString().trim()
        							+"' and birthday='"+Student.tbirthday.getText().toString().trim()
        							+"' and yxname='"+Student.tyxname.getText().toString().trim()
        							+"' and zyname='"+Student.tzyname.getText().toString().trim()
        							+"' and bjname='"+Student.tbjname.getText().toString().trim()
        							+"'"
        							);
                			Student.tnumber.setText("");
            				Student.tname.setText("");
            				Student.tgender.setText("");
            				Student.tnation.setText("");
            				Student.tbloodtype.setText("");
            				Student.tbirthday.setText("");
            				Student.tyxname.setText("");
            				Student.tzyname.setText("");
            				Student.tbjname.setText("");
        				}catch(SQLIntegrityConstraintViolationException a){
                    		JOptionPane.showMessageDialog(null,"请先删除成绩表相同学号的项目！","删除",JOptionPane.ERROR_MESSAGE);
                    	}catch(Exception e1) {
                			e1.printStackTrace();
                    	}
        				Student.updateinfo("select * from students");
                }
        		
			}
		});
        Student.button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Student.tnumber.setText("");
				Student.tname.setText("");
				Student.tgender.setText("");
				Student.tnation.setText("");
				Student.tbloodtype.setText("");
				Student.tbirthday.setText("");
				Student.tyxname.setText("");
				Student.tzyname.setText("");
				Student.tbjname.setText("");
			}
		});
		//this.setVisible(true);
	}

}