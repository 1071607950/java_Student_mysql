package manager;
import java.awt.event.*;
import javax.swing.*;

import main.Student;
public class findscores extends JPanel{
	public findscores(){
        setLayout(null);
        JLabel lab = new JLabel("按下列选项查询");
        JComboBox<String> cmb = new JComboBox<String>();
        JTextField jtf= new JTextField();
        cmb.addItem("学号");
        cmb.addItem("课程名");
        cmb.addItem("学期");
        cmb.addItem("成绩");
        cmb.addItem("学分");
        Student.button1 = new JButton("查询");
        Student.button2 = new JButton("取消");
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
                    JOptionPane.showMessageDialog(null, "请选择一个查询条件！", "查询", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(cmb.getSelectedIndex() == 0){
                    select = "number";
                }else if(cmb.getSelectedIndex() == 1){
                    select = "kcname";
                }else if(cmb.getSelectedIndex() == 2){
                    select = "term";
                }else if(cmb.getSelectedIndex() == 3){
                    select = "score";
                }else if(cmb.getSelectedIndex() == 4){
                    select = "credit";
                }
                Student.updatescore("select * from stuscore where "+select+"='"+jtf.getText().toString().trim()+"'");
            }
        });
        Student.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Student.model2.setRowCount(0);
            	cmb.setSelectedIndex(-1);
                jtf.setText("");
            }
        });
    }
}
