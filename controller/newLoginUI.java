package controller;


import javax.swing.*;

import model.Member;
import service.impl.MemberserviceImpl;
import util.Cal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class newLoginUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private final JCheckBox memberCheckBox = new JCheckBox("還不是會員,我要註冊");
    private static  MemberserviceImpl msi = new MemberserviceImpl();
    
    

    public newLoginUI() {
        // 設置框架標題
        setTitle("點餐系統登入");

        // 設置框架大小
        setSize(340, 231);
        setBackground(new Color(255, 255, 0));
        // 設置框架關閉操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
      
        // 設置框架佈局
        getContentPane().setLayout(new GridLayout(4, 4));

        // 添加使用者名稱標籤和文字框
        JLabel label = new JLabel("使用者名稱:");
        label.setFont(new Font("微軟正黑體", Font.BOLD, 15));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(label);
        userTextField = new JTextField();
        userTextField.setFont(new Font("新細明體", Font.BOLD, 20));
        getContentPane().add(userTextField);

        // 添加密碼標籤和密碼框
        JLabel label_1 = new JLabel("密碼:");
        label_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(label_1);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        getContentPane().add(passwordField);

        // 添加登入按鈕
        loginButton = new JButton("確定");
     
  
        loginButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        getContentPane().add(loginButton);

        // 添加取消按鈕
        cancelButton = new JButton("取消");
        cancelButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
                System.exit(0);
        	}
        });
        cancelButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        getContentPane().add(cancelButton);
        memberCheckBox.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        getContentPane().add(memberCheckBox);

        // 設置登入按鈕的事件處理
        loginButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
               	if (memberCheckBox.isSelected()) {
            		NewMemberRegister mm = new NewMemberRegister();
            		mm.setLocationRelativeTo(null); //視窗置中
              		mm.setVisible(true);
					dispose();
            	
            	}
            	else
            	{
                  String username = userTextField.getText();
                  String password = new String(passwordField.getPassword());

                  // 密碼驗證邏輯
                 List <Member> l = msi.selectByUsername(username);
            
              	      if (! l.isEmpty())  {
              	    	Member m = new Member();
    					 m= l.get(0);
    					 if (m.getPassword().equals(password)) {
                           JOptionPane.showMessageDialog(newLoginUI.this, m.getLevel()+"您好! 歡迎登入成功");
                    	   if (m.getLevelid()==1){
    						   managePage frame = new managePage();
    						   frame.setVisible(true);
    					       frame.setLocationRelativeTo(null); //視窗置中
    					   }
                    	   else {
                    		     		 
                    		   Cal.SaveObject(m,"tmpfile.txt");
                    		   customerPage frame = new  customerPage();
    						   frame.setVisible(true);
    					       frame.setLocationRelativeTo(null); //視窗置中
                    		   
                    	   }
                    		   
              	      
                  //    登入成功
                  //    myDrinkUI frame = new myDrinkUI();
			  	  //	frame.setVisible(true);
				  //	frame.setLocationRelativeTo(null); //視窗置中
			  
					    dispose();
    				 }
    					 else {
    		                	
    		                    JOptionPane.showMessageDialog(newLoginUI.this, "使用者名稱或密碼錯誤");
                } 
                    
                }
            	}
        		
        	}
        });


 

        // 設置框架可見
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
    	
    	newLoginUI lg = new newLoginUI();
    	lg.setLocationRelativeTo(null); //視窗置中
        lg.setVisible(true);
        
        
    }
}
