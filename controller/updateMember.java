package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.discountlevel;
import service.impl.DiscountlevelserviceImpl;
import service.impl.MemberserviceImpl;
import util.Cal;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;

public class updateMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField membernameField;
	private JTextField usernameField;
	private JTextField phoneField;
		
	private static MemberserviceImpl msi =new MemberserviceImpl() ;
	private static DiscountlevelserviceImpl dlsi = new DiscountlevelserviceImpl();
	private Member m = new Member();
	private discountlevel dcl = new discountlevel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateMember frame = new updateMember();
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
	public updateMember() {
		
		m = (Member)Cal.ReadObject("tmpFile.txt");
		
			System.out.println(m.getMemberid());
			System.out.println(m.getLevel());
		
		
		setTitle("會員資料修改");
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("會員等級");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(55, 206, 81, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		membernameField = new JTextField();
		membernameField.setEditable(false);
		membernameField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		membernameField.setBounds(165, 63, 96, 21);
		contentPane.add(membernameField);
		membernameField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		usernameField.setColumns(10);
		usernameField.setBounds(165, 106, 96, 21);
		contentPane.add(usernameField);
		
		phoneField = new JTextField();
		phoneField.setEditable(false);
		phoneField.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		phoneField.setColumns(10);
		phoneField.setBounds(165, 151, 96, 21);
		contentPane.add(phoneField);
		
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(165, 210, 96, 21);
		contentPane.add(comboBox);
		List<discountlevel> l = dlsi.selectAll();
		for(discountlevel d:l)
			comboBox.addItem(d.getLevelname());
		comboBox.setSelectedItem(m.getLevel());

		membernameField.setText(m.getMembername());
		usernameField.setText(m.getUsername());
		phoneField.setText(m.getPhone());
		
		
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println((String)comboBox.getSelectedItem());
				m.setLevel((String)comboBox.getSelectedItem());
				System.out.println(dlsi.selectBylevelname((String)comboBox.getSelectedItem()).get(0).getId());
				m.setLevelid(dlsi.selectBylevelname((String)comboBox.getSelectedItem()).get(0).getId());
				msi.updateMember(m);
				JOptionPane.showMessageDialog(updateMember.this, "資料更新成功");
				memberManage1 lg = new memberManage1();
		    	lg.setLocationRelativeTo(null); //視窗置中
		        lg.setVisible(true);
				dispose();
				
		//		if (msi.findByMember(usernameField.getText())) 
		//	      JOptionPane.showMessageDialog(updateMember.this, "登入名稱重複", "錯誤", JOptionPane.ERROR_MESSAGE);	
		//		else
		//	    if(phoneField.getText().trim().isEmpty() || !Cal.isNumeric(phoneField.getText()))
		//	      JOptionPane.showMessageDialog(updateMember.this, "請填入正確電話號碼!", "錯誤", JOptionPane.ERROR_MESSAGE);
		//	    else
			   
		//	    {
		
			      
		//	    }
			      
			}
			    
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton.setBounds(55, 297, 108, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回上頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memberManage1 lg = new memberManage1();
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
