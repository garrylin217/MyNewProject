package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class managePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managePage frame = new managePage();
					frame.setLocationRelativeTo(null);
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
	public managePage() {
		setTitle("主管理系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("會員管理");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				memberManage1 mm= new memberManage1();
				mm.setLocationRelativeTo(null);
				mm.setVisible(true);
				dispose();
				
				
			    
				
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		
		btnNewButton.setBounds(58, 52, 115, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("產品管理");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myDrinkMaintain mmyy = new myDrinkMaintain();
				mmyy.setLocationRelativeTo(null);
				mmyy.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btnNewButton_1.setBounds(205, 52, 115, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("銷貨管理");
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(58, 116, 115, 41);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("登出");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				newLoginUI nu= new newLoginUI();
				nu.setLocationRelativeTo(null);
				nu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(205, 116, 115, 41);
		contentPane.add(btnNewButton_1_2);
	}
}
