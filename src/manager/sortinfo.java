package manager;
import java.awt.event.*;
import javax.swing.*;

import main.Student;
public class sortinfo extends JPanel{
	public sortinfo(){
        setLayout(null);
        JLabel lab = new JLabel("������ѡ������");
        JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("ѧ��");
        cmb.addItem("����");
        cmb.addItem("�Ա�");
        cmb.addItem("����");
        cmb.addItem("Ѫ��");
        cmb.addItem("��������");
        cmb.addItem("Ժϵ");
        cmb.addItem("רҵ");
        cmb.addItem("�༶");
        ButtonGroup option = new ButtonGroup();
        JRadioButton optionA = new JRadioButton("����");
        JRadioButton optionB = new JRadioButton("����");
        option.add(optionA);
        option.add(optionB);
        Student.button1 = new JButton("����");
        Student.button2 = new JButton("ȡ��");
        lab.setBounds(30, 20, 100, 30);
        cmb.setBounds(130, 20, 100, 26);
        optionA.setBounds(30, 70, 60, 30);
        optionB.setBounds(100, 70, 60, 30);
        Student.button1.setBounds(30, 120, 60, 26);
        Student.button2.setBounds(110, 120, 60, 26);
        cmb.setSelectedIndex(-1);
        add(lab);
        add(cmb);
        add(optionA);
        add(optionB);
        add(Student.button1);
        add(Student.button2);
        Student.button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String order = null;
                String sc = null;
                if(cmb.getSelectedIndex() == -1){
                	JOptionPane.showMessageDialog(null, "��ѡ��һ������������", "����", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(cmb.getSelectedIndex() == 0){
                	order = "number";
                }else if(cmb.getSelectedIndex() == 1){
                	order = "name";
                }else if(cmb.getSelectedIndex() == 2){
                	order = "gender";
                }else if(cmb.getSelectedIndex() == 3){
                	order = "nation";
                }else if(cmb.getSelectedIndex() == 4){
                	order = "bloodtype";
                }else if(cmb.getSelectedIndex() == 5){
                	order = "birthday";
                }else if(cmb.getSelectedIndex() == 6){
                	order = "yxname";
                }else if(cmb.getSelectedIndex() == 7){
                	order = "zyname";
                }else if(cmb.getSelectedIndex() == 8){
                	order = "bjname";
                }
                if(!optionA.isSelected() && !optionB.isSelected()){
                    JOptionPane.showMessageDialog(null, "���ڵ�ѡ��ѡ��һ���������!", "����", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(optionA.isSelected()){
                    sc = "asc";
                }else if(optionB.isSelected()){
                    sc = "desc";
                }
                Student.updateinfo("select * from students order by "+order+" "+sc);
            }
        });
        Student.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Student.model1.setRowCount(0);
                option.clearSelection();
                cmb.setSelectedIndex(-1);
            }
        });
    }
}
