package manager;
import java.awt.event.*;
import javax.swing.*;

import main.Student;
public class sortscores extends JPanel{
	public sortscores(){
        setLayout(null);
        JLabel lab = new JLabel("������ѡ������");
        final JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("ѧ��");
        cmb.addItem("�γ���");
        cmb.addItem("ѧ��");
        cmb.addItem("�ɼ�");
        cmb.addItem("ѧ��");
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
                	order = "kcname";
                }else if(cmb.getSelectedIndex() == 2){
                	order = "term";
                }else if(cmb.getSelectedIndex() == 3){
                	order = "score";
                }else if(cmb.getSelectedIndex() == 4){
                	order = "credit";
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
                Student.updatescore("select * from stuscore order by "+order+" "+sc);
            }
        });
        Student.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	Student.model2.setRowCount(0);
                option.clearSelection();
                cmb.setSelectedIndex(-1);
            }
        });
    }
}
