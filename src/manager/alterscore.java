package manager;
import java.awt.event.*;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;

import main.Jdbc;
import main.Student;
public class alterscore extends JPanel{
	public alterscore(){
		this.setLayout(null);
		Student.jnumber=new JLabel("ѧ��"); 
		Student.tnumber=new JTextField();
		Student.jkcname=new JLabel("�γ�����");
		Student.tkcname=new JTextField();
		Student.jterm=new JLabel("ѧ��");
		Student.tterm=new JTextField();
		Student.jscore=new JLabel("�ɼ�");
		Student.tscore=new JTextField();
		Student.jcredit=new JLabel("ѧ��");
		Student.tcredit=new JTextField();
		Student.button1=new JButton("�޸�");
		Student.button2=new JButton("ȡ��");
        //���ÿؼ���λ�úʹ�С
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
        
        Student.tnumber.setEditable(false);
        
        //���ؼ���ӵ�������
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
        			JOptionPane.showMessageDialog(null,"ѧ�ų�����1~10֮�䣬ֻ�ܰ������֣�","�޸�",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		else if(!Student.tkcname.getText().matches("^[\\u4E00-\\u9FA5A-Za-z0-9]{1,20}$")) {
            		JOptionPane.showMessageDialog(null,"�γ̳�����1~20֮�䣬ֻ�ܰ������ġ�Ӣ�ġ����֣�","�޸�",JOptionPane.WARNING_MESSAGE);
            		return;
        		}
        		else if(!Student.tterm.getText().matches("^\\d{1,10}$")) {
            		JOptionPane.showMessageDialog(null,"ѧ�ڳ�����1~10֮�䣬ֻ�ܰ������֣�","�޸�",JOptionPane.WARNING_MESSAGE);
            		return;
        		}
        		else if(!Student.tscore.getText().matches("^\\d{1,10}$")) {
                	JOptionPane.showMessageDialog(null,"�ɼ�������1~10֮�䣬ֻ�ܰ������֣�","�޸�",JOptionPane.WARNING_MESSAGE);
                	return;
        		}
                else if(!Student.tcredit.getText().matches("^\\d{1,10}$")) {
                    JOptionPane.showMessageDialog(null,"ѧ�ֳ�����1~10֮�䣬ֻ�ܰ������֣�","�޸�",JOptionPane.WARNING_MESSAGE);
                    return;
        		}
                else{
                	//����Jdbc
                	try {
                		Jdbc.update("update stuscore set"
            					+" kcname='"+Student.tkcname.getText().toString().trim()
            					+"' ,term='"+Student.tterm.getText().toString().trim()
            					+"' ,score='"+Student.tscore.getText().toString().trim()
            					+"' ,credit='"+Student.tcredit.getText().toString().trim()
            					/*+"' ,scores='"+String.valueOf(
            							Integer.valueOf(Student.tkcname.getText().toString().trim())+
                            			Integer.valueOf(Student.tterm.getText().toString().trim())+
                            			Integer.valueOf(Student.tscore.getText().toString().trim())+
                            			Integer.valueOf(Student.tcredit.getText().toString().trim()))*/
            					+"' where number='"+Student.tnumber.getText().toString().toString().trim()
            					+"'"
            					);
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

