package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	private JLabel laba1,laba2,labb1,labb2;
	private JLabel JLba1=new JLabel("账    号");
	private JLabel JLba2=new JLabel("密    码");
	private JLabel JLbb1=new JLabel("账    号");
	private JLabel JLbb2=new JLabel("旧    密    码");
	private JLabel JLbb3=new JLabel("新    密    码");
	private JButton Ok1=new JButton("确定");
	private JButton Cancel1=new JButton("取消");
	private JButton Ok2=new JButton("修改");
	private JButton Cancel2=new JButton("取消");
	private JTextField user1=new JTextField();
	private JPasswordField pwd1=new JPasswordField();
	private JTextField user2=new JTextField();
	private JPasswordField pwd2=new JPasswordField();
	private JPasswordField pwd3=new JPasswordField();
	public Login() {
		super("登录");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		laba1 = new JLabel("欢迎来到学生学籍");
        laba2 = new JLabel("管理登录系统!");
        labb1 = new JLabel("欢迎来到学生学籍");
        labb2 = new JLabel("管理登录系统!");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JLayeredPane adminlogin = new JLayeredPane();
		tabbedPane.addTab("登录", null, adminlogin, null);
		adminlogin.setLayout(new GridLayout(4,2));
		JLayeredPane adminalter = new JLayeredPane();
		tabbedPane.addTab("修改密码", null, adminalter, null);
		adminalter.setLayout(new GridLayout(5,2));
		
		adminlogin.add(laba1);adminlogin.add(laba2);
		adminlogin.add(JLba1);adminlogin.add(user1);
		adminlogin.add(JLba2);adminlogin.add(pwd1);
		adminlogin.add(Ok1);adminlogin.add(Cancel1);
		
		adminalter.add(labb1);adminalter.add(labb2);
		adminalter.add(JLbb1);adminalter.add(user2);
		adminalter.add(JLbb2);adminalter.add(pwd2);
		adminalter.add(JLbb3);adminalter.add(pwd3);
		adminalter.add(Ok2);adminalter.add(Cancel2);
		
		laba1.setForeground(Color.blue);
        laba2.setForeground(Color.blue);
        labb1.setForeground(Color.blue);
        labb2.setForeground(Color.blue);
        Ok1.setBackground(Color.YELLOW);
        Cancel1.setBackground(Color.YELLOW);
        Ok2.setBackground(Color.YELLOW);
        Cancel2.setBackground(Color.YELLOW);
        
        laba1.setHorizontalAlignment(SwingConstants.RIGHT);
        laba2.setHorizontalAlignment(SwingConstants.LEFT);
		JLba1.setHorizontalAlignment(SwingConstants.CENTER);
		JLba2.setHorizontalAlignment(SwingConstants.CENTER);
		Ok1.addActionListener(this);
		Cancel1.addActionListener(this);
		
		labb1.setHorizontalAlignment(SwingConstants.RIGHT);
        labb2.setHorizontalAlignment(SwingConstants.LEFT);
		JLbb1.setHorizontalAlignment(SwingConstants.CENTER);
		JLbb2.setHorizontalAlignment(SwingConstants.CENTER);
		JLbb3.setHorizontalAlignment(SwingConstants.CENTER);
		Ok2.addActionListener(this);
		Cancel2.addActionListener(this);
		
		setSize(500,400);
		setLocationRelativeTo(null);
		setResizable(false); 
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		String stra1,stra2,strb1,strb2,strb3;
		Object obj=e.getSource();
		//获得文本框输入的用户名和密码
		stra1=user1.getText().trim();
		stra2=new String(pwd1.getPassword()).trim();
		strb1=user2.getText().trim();
		strb2=new String(pwd2.getPassword()).trim();
		strb3=new String(pwd3.getPassword()).trim();
		if(obj.equals(Ok1)){
			if(!stra1.matches("^[a-zA-Z][a-zA-Z0-9_]{5,19}$")){
				JOptionPane.showMessageDialog(this,"账号以字母开头，允许6-20字节，允许字母数字下划线！","账号非法",JOptionPane.WARNING_MESSAGE);
				return;
			}else if(!stra2.matches("^[a-zA-Z]\\w{5,19}$")) {
				JOptionPane.showMessageDialog(this,"密码以字母开头，长度在6~20之间，只能包含字母、数字和下划线！","密码非法",JOptionPane.WARNING_MESSAGE);
				return;
			}
			else {
				if(Jdbc.Login(stra1, stra2)) {
					JOptionPane.showMessageDialog(this,"登录成功","正确",JOptionPane.INFORMATION_MESSAGE);
					new Student();
					//关闭登录窗口
					this.dispose();
			    }else {
			    	JOptionPane.showMessageDialog(this,"账号密码错误，请重新输入","错误",JOptionPane.WARNING_MESSAGE);
			    	user1.setText("");
			    	pwd1.setText("");
			    }
			}
		}else if(obj.equals(Ok2)){
			if(!strb1.matches("^[a-zA-Z][a-zA-Z0-9_]{5,19}$")){
				JOptionPane.showMessageDialog(this,"账号以字母开头，允许6-20字节，允许字母数字下划线！","账号非法",JOptionPane.WARNING_MESSAGE);
				return;
			}else if(!strb2.matches("^[a-zA-Z]\\w{5,19}$")) {
				JOptionPane.showMessageDialog(this,"旧密码以字母开头，长度在6~20之间，只能包含字母、数字和下划线！","旧密码非法",JOptionPane.WARNING_MESSAGE);
				return;
			}else if(!strb3.matches("^[a-zA-Z]\\w{5,19}$")) {
				JOptionPane.showMessageDialog(this,"新密码以字母开头，长度在6~20之间，只能包含字母、数字和下划线！","新密码非法",JOptionPane.WARNING_MESSAGE);
				return;
			}
			else {
				if(Jdbc.Login(strb1, strb2)) {
					try {
						Jdbc.update("update admin set"
								+" password='"+strb3
								+"' where accounts='"+strb1
								+"' and password='"+strb2
								+"'"
								);
						
						user2.setText("");
				    	pwd2.setText("");
				    	pwd3.setText("");
			    	}catch(Exception e1){
			    		e1.printStackTrace();
			    	}
			    }else {
			    	JOptionPane.showMessageDialog(this,"账号密码错误，请重新输入","错误",JOptionPane.WARNING_MESSAGE);
			    	user2.setText("");
			    	pwd2.setText("");
			    	pwd3.setText("");
			    }
			}
		}else if(obj.equals(Cancel1)) {
			Jdbc.connclose();
			this.dispose();
			System.exit(0);
		}else if(obj.equals(Cancel2)) {
			Jdbc.connclose();
			this.dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Login();	
		Jdbc.init();
	}

}
