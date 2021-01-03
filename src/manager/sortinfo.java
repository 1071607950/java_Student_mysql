package manager;
import java.awt.event.*;
import javax.swing.*;

import main.Student;
public class sortinfo extends JPanel{
	public sortinfo(){
        setLayout(null);
        JLabel lab = new JLabel("按下列选项排序");
        JComboBox<String> cmb = new JComboBox<String>();
        cmb.addItem("学号");
        cmb.addItem("姓名");
        cmb.addItem("性别");
        cmb.addItem("民族");
        cmb.addItem("血型");
        cmb.addItem("出生日期");
        cmb.addItem("院系");
        cmb.addItem("专业");
        cmb.addItem("班级");
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
                    JOptionPane.showMessageDialog(null, "请在单选框选择一项进行排序!", "排序", JOptionPane.WARNING_MESSAGE);
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
