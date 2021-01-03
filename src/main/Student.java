package main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import manager.addinfo;
import manager.addscore;
import manager.alterinfo;
import manager.alterscore;
import manager.deleteinfo;
import manager.deletescore;
import manager.findinfo;
import manager.findscores;
import manager.sortinfo;
import manager.sortscores;
public class Student extends JFrame implements ActionListener{
	public static DefaultTableModel model1 = new DefaultTableModel(null, new String[]{"学号","姓名","性别","民族","血型","出生日期","院系","专业","班级"});
	public static DefaultTableModel model2 = new DefaultTableModel(null, new String[]{"学号","课程名","学期","成绩","学分"});
	public static DefaultTableModel model3 = new DefaultTableModel(null, new String[0]);
	public static JTable table = new JTable();
	public static JScrollPane jsp = new JScrollPane(table);
	public static JTextField tnumber,tname,tgender,tnation,tbloodtype,tbirthday,tyxname,tzyname,tbjname;
	public static JLabel jnumber,jname,jgender,jnation,jbloodtype,jbirthday,jyxname,jzyname,jbjname;
	public static JButton button1,button2;
	public static JTextField tkcname,tterm,tscore,tcredit;
	public static JLabel jkcname,jterm,jscore,jcredit;
	//声明面板容器
	JPanel jp=new JPanel();
	//创建菜单栏
	JMenuBar jMenuBar1=new JMenuBar();
	//创建菜单
	JMenu jMenua=new JMenu("学生信息管理");
	JMenu jMenub=new JMenu("学生成绩管理");
	JMenu jMenuc=new JMenu("基本信息查询");
	JMenu jMenud=new JMenu("成绩查询与统计");
	JMenu jMenue=new JMenu("退出");
	//创建菜单选项
	JMenuItem jMenuItema1=new JMenuItem("添加信息");
	JMenuItem jMenuItema2=new JMenuItem("修改信息");
	JMenuItem jMenuItema3=new JMenuItem("删除信息");
	JMenuItem jMenuItema4=new JMenuItem("查询信息");
	JMenuItem jMenuItemb1=new JMenuItem("添加成绩");
	JMenuItem jMenuItemb2=new JMenuItem("修改成绩");
	JMenuItem jMenuItemb3=new JMenuItem("删除成绩");
	JMenuItem jMenuItemb4=new JMenuItem("查询成绩");
	JMenuItem jMenuItemc1=new JMenuItem("按条件查询");
	JMenuItem jMenuItemc2=new JMenuItem("分类排序");
	JMenuItem jMenuItemd1=new JMenuItem("按条件查询");
	JMenuItem jMenuItemd2=new JMenuItem("排序统计");
	JMenuItem jMenuIteme1=new JMenuItem("退出系统");
	public static MouseListener mouselistener = new MouseListener() {
        public void mousePressed(MouseEvent mouseevent){}
        public void mouseReleased(MouseEvent mouseevent){}
        public void mouseEntered(MouseEvent mouseevent){}
        public void mouseExited(MouseEvent mouseevent){}
        public void mouseClicked(MouseEvent e)
        {
        	if(Student.table.getModel().equals(model1)){
        		int selectRows = Student.table.getSelectedRow();
                Student.tnumber.setText((String)Student.model1.getValueAt(selectRows, 0));
                Student.tname.setText((String)Student.model1.getValueAt(selectRows, 1));
                Student.tgender.setText((String)Student.model1.getValueAt(selectRows, 2));
                Student.tnation.setText((String)Student.model1.getValueAt(selectRows, 3));
                Student.tbloodtype.setText((String)Student.model1.getValueAt(selectRows, 4));
                Student.tbirthday.setText((String)Student.model1.getValueAt(selectRows, 5));
                Student.tyxname.setText((String)Student.model1.getValueAt(selectRows, 6));
                Student.tzyname.setText((String)Student.model1.getValueAt(selectRows, 7));
                Student.tbjname.setText((String)Student.model1.getValueAt(selectRows, 8));
        	}else if(Student.table.getModel().equals(model2)){
        		int selectRows = Student.table.getSelectedRow();
                Student.tnumber.setText((String)Student.model2.getValueAt(selectRows, 0));
                Student.tkcname.setText((String)Student.model2.getValueAt(selectRows, 1));
                Student.tterm.setText((String)Student.model2.getValueAt(selectRows, 2));
                Student.tscore.setText((String)Student.model2.getValueAt(selectRows, 3));
                Student.tcredit.setText((String)Student.model2.getValueAt(selectRows, 4));
        	}
        }
    };
	public Student(){
		super("学生学籍管理系统");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setJMenuBar(jMenuBar1);
		//向菜单栏上添加菜单                             
		jMenuBar1.add(jMenua);
		jMenuBar1.add(jMenub);
		jMenuBar1.add(jMenuc);
		jMenuBar1.add(jMenud);
		jMenuBar1.add(jMenue);
		//向菜单中添加菜单项
		jMenua.add(jMenuItema1);
		jMenua.add(jMenuItema2);
		jMenua.add(jMenuItema3);
		jMenua.add(jMenuItema4);
		jMenub.add(jMenuItemb1);
		jMenub.add(jMenuItemb2);
		jMenub.add(jMenuItemb3);
		jMenub.add(jMenuItemb4);
		jMenuc.add(jMenuItemc1);
		jMenuc.add(jMenuItemc2);
		jMenud.add(jMenuItemd1);
		jMenud.add(jMenuItemd2);
		jMenue.add(jMenuIteme1);
		//监听
		jMenuItema1.addActionListener(this);
		jMenuItema2.addActionListener(this);
		jMenuItema3.addActionListener(this);
		jMenuItema4.addActionListener(this);
		jMenuItemb1.addActionListener(this);
		jMenuItemb2.addActionListener(this);
		jMenuItemb3.addActionListener(this);
		jMenuItemb4.addActionListener(this);
		jMenuItemc1.addActionListener(this);
		jMenuItemc2.addActionListener(this);
		jMenuItemd1.addActionListener(this);
		jMenuItemd2.addActionListener(this);
		jMenuIteme1.addActionListener(this);
		//布局
		this.add(jp,BorderLayout.CENTER);
		this.add(jsp,BorderLayout.EAST);
		jp.setLayout(new CardLayout());
		//大小，位置，界面可变，可见
		setSize(800,500);
		setLocationRelativeTo(null);
		//this.pack();
		setResizable(true); 
		jp.add(new JLabel(new ImageIcon("img/bg.jpeg")));
		jsp.setVisible(false);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		CardLayout c1=(CardLayout)jp.getLayout();
		jsp.setVisible(true);
		table.removeMouseListener(mouselistener);
		if(obj.equals(jMenuItema1)) {
			addinfo addinfo=new addinfo();
			jp.add(addinfo,"添加基本信息");
			c1.show(jp, "添加基本信息");
			table.setModel(model1);
			table.addMouseListener(mouselistener);
		}else if(obj.equals(jMenuItema2)) {
			alterinfo alterinfo=new alterinfo();
			jp.add(alterinfo,"修改基本信息");
			c1.show(jp, "修改基本信息");
			table.setModel(model1);
			table.addMouseListener(mouselistener);
		}else if(obj.equals(jMenuItema3)) {
			deleteinfo deleteinfo=new deleteinfo();
			jp.add(deleteinfo,"删除基本信息");
			c1.show(jp, "删除基本信息");
			table.setModel(model1);
			table.addMouseListener(mouselistener);
		}else if(obj.equals(jMenuItema4)){
			jp.add(jp.add(new JLabel(new ImageIcon("img/bg2.jpg"))),"背景");
			c1.show(jp, "背景");
			Student.updateinfo("select * from students");
		}else if(obj.equals(jMenuItemb1)) {
			addscore addscore=new addscore();
			jp.add(addscore,"添加成绩信息");
			c1.show(jp, "添加成绩信息");
			table.setModel(model2);
			table.addMouseListener(mouselistener);
		}else if(obj.equals(jMenuItemb2)) {
			alterscore alterscore=new alterscore();
			jp.add(alterscore,"修改成绩信息");
			c1.show(jp, "修改成绩信息");
			table.setModel(model2);
			table.addMouseListener(mouselistener);
		}else if(obj.equals(jMenuItemb3)) {
			deletescore deletescore=new deletescore();
			jp.add(deletescore,"删除成绩信息");
			c1.show(jp, "删除成绩信息");
			table.setModel(model2);
			table.addMouseListener(mouselistener);
		}else if(obj.equals(jMenuItemb4)){
			jp.add(jp.add(new JLabel(new ImageIcon("img/bg2.jpg"))),"背景");
			c1.show(jp, "背景");
			Student.updatescore("select * from stuscore");
		}else if(obj.equals(jMenuItemc1)){
			findinfo findinfo = new findinfo();
            jp.add(findinfo, "按条件查询信息");
            c1.show(jp, "按条件查询信息");
            model1.setRowCount(0);
            table.setModel(model1);
            table.addMouseListener(mouselistener);
	    }else if(obj.equals(jMenuItemc2)){
	    	sortinfo sortinfo = new sortinfo();
            jp.add(sortinfo, "排序信息");
            c1.show(jp, "排序信息");
            model1.setRowCount(0);
            table.setModel(model1);
            table.addMouseListener(mouselistener);
        }else if(obj.equals(jMenuItemd1)){
            findscores findscores = new findscores();
            jp.add(findscores, "按条件查询成绩");
            c1.show(jp, "按条件查询成绩");
            model2.setRowCount(0);
            table.setModel(model2);
            table.addMouseListener(mouselistener);
        }else if(obj.equals(jMenuItemd2)){
            sortscores sortscores = new sortscores();
            jp.add(sortscores, "排序成绩");
            c1.show(jp, "排序成绩");
            model2.setRowCount(0);
            table.setModel(model2);
            table.addMouseListener(mouselistener);
        }else if(obj.equals(jMenuIteme1)){
			Jdbc.connclose();
			this.dispose();
			System.exit(0);
		}
		this.setVisible(true);
	}
	public static void updateinfo(String sql) {
		table.setModel(model1);
		//表格设置
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn Column2 = table.getColumnModel().getColumn(1);
		Column2.setPreferredWidth(50);
		TableColumn Column3 = table.getColumnModel().getColumn(2);
		Column3.setPreferredWidth(40);
		TableColumn Column4 = table.getColumnModel().getColumn(3);
		Column4.setPreferredWidth(40);
		TableColumn Column5 = table.getColumnModel().getColumn(4);
		Column5.setPreferredWidth(40);
		TableColumn Column6 = table.getColumnModel().getColumn(5);
		Column6.setPreferredWidth(90);
		try {
			PreparedStatement ps=Jdbc.conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			model1.setRowCount(0);
			while(rs.next())
			{
				// 填充数据
				Vector<String> arr=new Vector<String>();
				arr.add(rs.getString("number"));
				arr.add(rs.getString("name"));
				arr.add(rs.getString("gender"));
				arr.add(rs.getString("nation"));
				arr.add(rs.getString("bloodtype"));
				arr.add(rs.getString("birthday"));
				arr.add(rs.getString("yxname"));
				arr.add(rs.getString("zyname"));
				arr.add(rs.getString("bjname"));
				// 添加数据到表格
				model1.addRow(arr);
			}
			//table.updateUI();
			table.invalidate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void updatescore(String sql) {
		table.setModel(model2);
		//表格设置
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn Column1 = table.getColumnModel().getColumn(0);
		Column1.setPreferredWidth(100);
		try {
			PreparedStatement ps=Jdbc.conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			model2.setRowCount(0);
			while(rs.next())
			{
				// 填充数据
				Vector<String> arr=new Vector<String>();
				arr.add(rs.getString("number"));
				arr.add(rs.getString("kcname"));
				arr.add(rs.getString("term"));
				arr.add(rs.getString("score"));
				arr.add(rs.getString("credit"));
				// 添加数据到表格
				model2.addRow(arr);
			}
			//table.updateUI();
			table.invalidate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) {
		new Student();	
		Jdbc.init();
	}*/
}
