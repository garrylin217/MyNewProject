package controller;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.LoginFrame;

import model.Member;
import service.impl.MemberserviceImpl;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NewMemberRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField membernameField;
	private JTextField usernameField;
	private JTextField phoneField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private static MemberserviceImpl msi =new MemberserviceImpl() ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMemberRegister frame = new NewMemberRegister();
					frame.setLocationRelativeTo(null); //視窗置中
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewMemberRegister() {
		setTitle("會員註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員名稱");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel.setBounds(55, 63, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("登入名稱");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(55, 102, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("電話號碼");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(55, 147, 81, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("密碼");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(55, 191, 81, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("密碼再次確認");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(36, 235, 100, 21);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		membernameField = new JTextField();
		membernameField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		membernameField.setBounds(165, 63, 96, 21);
		contentPane.add(membernameField);
		membernameField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		usernameField.setColumns(10);
		usernameField.setBounds(165, 106, 96, 21);
		contentPane.add(usernameField);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		phoneField.setColumns(10);
		phoneField.setBounds(165, 151, 96, 21);
		contentPane.add(phoneField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		passwordField.setBounds(165, 195, 100, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		passwordField_1.setBounds(165, 239, 100, 21);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(usernameField.getText());
				if (msi.findByMember(usernameField.getText())) 
			      JOptionPane.showMessageDialog(NewMemberRegister.this, "登入名稱重複", "錯誤", JOptionPane.ERROR_MESSAGE);	
				else
			    if(phoneField.getText().trim().isEmpty() || !Cal.isNumeric(phoneField.getText()))
			      JOptionPane.showMessageDialog(NewMemberRegister.this, "請填入正確電話號碼!", "錯誤", JOptionPane.ERROR_MESSAGE);
			    else
			    if(passwordField.equals(passwordField_1))
			   	  JOptionPane.showMessageDialog(NewMemberRegister.this, "密碼前後不一致", "錯誤", JOptionPane.ERROR_MESSAGE);
			    else
			    {
			      //新增資料
			      msi.addMember(membernameField.getText(),
			    	  	        usernameField.getText(), 
			    		        passwordField.getText(), 
			    		        phoneField.getText());
			      JOptionPane.showMessageDialog(NewMemberRegister.this, "註冊成功");
			      newLoginUI lg = new newLoginUI();
			    	lg.setLocationRelativeTo(null); //視窗置中
			        lg.setVisible(true);
			        dispose();
			      
			    }
			      
			}
			    
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton.setBounds(55, 297, 108, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回登入頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newLoginUI lg = new newLoginUI();
		    	lg.setLocationRelativeTo(null); //視窗置中
		        lg.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1.setBounds(190, 297, 108, 42);
		contentPane.add(btnNewButton_1);
	}

}
