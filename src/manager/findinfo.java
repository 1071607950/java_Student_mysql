package manager;
import java.awt.event.*;
import javax.swing.*;

import main.Student;
public class findinfo extends JPanel{
	public findinfo(){
        setLayout(null);
        JLabel lab = new JLabel("������ѡ���ѯ");
        JComboBox<String> cmb = new JComboBox<String>();
        JTextField jtf= new JTextField();
        cmb.addItem("ѧ��");
        cmb.addItem("����");
        cmb.addItem("�Ա�");
        cmb.addItem("����");
        cmb.addItem("Ѫ��");
        cmb.addItem("��������");
        cmb.addItem("Ժϵ");
        cmb.addItem("רҵ");
        cmb.addItem("�༶");
        Student.button1 = new JButton("��ѯ");
        Student.button2 = new JButton("ȡ��");
        lab.setBounds(30, 20, 120, 26);
        cmb.setBounds(30, 60, 80, 26);
        jtf.setBounds(120, 60, 120, 26);
        Student.button1.setBounds(30, 120, 60, 26);
        Student.button2.setBounds(110, 120, 60, 26);
        cmb.setSelectedIndex(-1);
        add(lab);
        add(cmb);add(jtf);
        add(Student.button1);
        add(Student.button2);
        Student.button1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
                String select = null;
                if(cmb.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "��ѡ��һ����ѯ������", "��ѯ", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(cmb.getSelectedIndex() == 0){
                    select = "number";
                }else if(cmb.getSelectedIndex() == 1){
                    select = "name";
                }else if(cmb.getSelectedIndex() == 2){
                    select = "gender";
                }else if(cmb.getSelectedIndex() == 3){
                    select = "nation";
                }else if(cmb.getSelectedIndex() == 4){
                    select = "bloodtype";
                }else if(cmb.getSelectedIndex() == 5){
                    select = "birthday";
                }else if(cmb.getSelectedIndex() == 6){
                    select = "yxname";
                }else if(cmb.getSelectedIndex() == 7){
                    select = "zyname";
                }else if(cmb.getSelectedIndex() == 8){
                    select = "bjname";
                }
                Student.updateinfo("select * from students where "+select+"='"+jtf.getText().toString().trim()+"'");
            }
        });
        Student.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Student.model1.setRowCount(0);
            	cmb.setSelectedIndex(-1);
                jtf.setText("");
            }
        });
    }
}
