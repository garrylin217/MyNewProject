package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.myDrink1;
import model.myDrinkParent;
import service.impl.MyDrink1serviceImpl;
import service.impl.myDrinkParentserviceImpl;
import util.Cal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class myDrinkChildMaintain extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static myDrinkParentserviceImpl mdpi = new myDrinkParentserviceImpl();
	private static MyDrink1serviceImpl mpi = new MyDrink1serviceImpl();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	myDrinkParent mm =  new myDrinkParent();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			myDrinkChildMaintain dialog = new myDrinkChildMaintain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public myDrinkChildMaintain() {
		mm = (myDrinkParent)Cal.ReadObject("tmpfile.txt");
		
		setTitle("產品細項設定");
	
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("產品名稱");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			lblNewLabel.setBounds(74, 61, 69, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			textField.setColumns(10);
			textField.setBounds(141, 61, 139, 30);
			contentPanel.add(textField);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("產品描述:");
			lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			lblNewLabel_1.setBounds(74, 117, 69, 30);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			textField_1.setColumns(10);
			textField_1.setBounds(141, 101, 139, 63);
			contentPanel.add(textField_1);
		}
		
		JLabel lblNewLabel = new JLabel("產品價格:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 173, 69, 30);
		contentPanel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 174, 139, 30);
		contentPanel.add(textField_2);
		{
			JLabel lblNewLabel_1 = new JLabel("類別名稱:");
			lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			lblNewLabel_1.setBounds(74, 21, 206, 30);
			contentPanel.add(lblNewLabel_1);
			lblNewLabel_1.setText("產生類別:"+ mm.getMyDrinkParenNtame());
		}
		
		textField_2.addKeyListener(new KeyAdapter() {
			
			 public void keyTyped(KeyEvent e) {
	                char c = e.getKeyChar();
	                if (!Character.isDigit(c)) {
	                    e.consume();  // 忽略非數字輸入
	                }
	            }
		});

		
		
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
            	myDrinkMaintain frame = new myDrinkMaintain();
				frame.setLocationRelativeTo(null); //視窗置中
				frame.setVisible(true);
				dispose();
            }
        });
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(textField.getText().trim().isEmpty())
							 JOptionPane.showMessageDialog(myDrinkChildMaintain.this, "名稱不可空白!", "錯誤", JOptionPane.ERROR_MESSAGE);
						else
						{
						
						  List<myDrink1> l = mpi.selectByParentidAndDrinkName(mm.getMyDrinkParenid(),textField.getText());
						  System.out.println(l.size());
						  if (!l.isEmpty() ) {
						 	JOptionPane.showMessageDialog(myDrinkChildMaintain.this, "名稱重複", "錯誤", JOptionPane.ERROR_MESSAGE);
						  }
						  else
						  {
						 	
							myDrink1  m = new myDrink1();
							m.setDrinkname(textField.getText());
							m.setMydrinkparentid(mm.getMyDrinkParenid());
							m.setDrinkdescription(textField_1.getText());
							m.setDrinkprice(Integer.valueOf(textField_2.getText()));
							m.setDrinkcategory("");
							mpi.add(m);
							JOptionPane.showMessageDialog(myDrinkChildMaintain.this, "新增資料成功");
							myDrinkMaintain frame123 = new myDrinkMaintain();
							frame123.setLocationRelativeTo(null); //視窗置中
							frame123.setVisible(true);
							dispose();
						}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						myDrinkMaintain frame = new myDrinkMaintain();
						frame.setLocationRelativeTo(null); //視窗置中
						frame.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
