package manager;
import java.awt.event.*;
import javax.swing.*;

import main.Student;
public class sortscores extends JPanel{
	public sortscores(){
        setLayout(null);
        JLabel lab = new JLabel("按下列选项排序");
        final JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("学号");
        cmb.addItem("课程名");
        cmb.addItem("学期");
        cmb.addItem("成绩");
        cmb.addItem("学分");
        ButtonGroup option = new ButtonGroup();
        JRadioButton optionA = new JRadioButton("升序");
        JRadioButton optionB = new JRadioButton("降序");
        option.add(optionA);
        option.add(optionB);
        Student.button1 = new JButton("排序");
        Student.button2 = new JButton("取消");
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
                	JOptionPane.showMessageDialog(null, "请选择一个排序条件！", "排序", JOptionPane.WARNING_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "请在单选框选择一项进行排序!", "排序", JOptionPane.WARNING_MESSAGE);
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
