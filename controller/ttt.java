package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.myDrinkParent;
import service.impl.myDrinkParentserviceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ttt extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static myDrinkParentserviceImpl mpi = new myDrinkParentserviceImpl();
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ttt dialog = new ttt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ttt() {
		
		
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("分類名稱");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			lblNewLabel.setBounds(74, 26, 69, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			textField.setColumns(10);
			textField.setBounds(141, 26, 139, 30);
			contentPanel.add(textField);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("分類描述");
			lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			lblNewLabel_1.setBounds(74, 75, 69, 30);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			textField_1.setColumns(10);
			textField_1.setBounds(74, 101, 206, 63);
			contentPanel.add(textField_1);
		}
		
		
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
							 JOptionPane.showMessageDialog(ttt.this, "名稱不可空白!", "錯誤", JOptionPane.ERROR_MESSAGE);
						else
						{
						
						  List<myDrinkParent> l = mpi.selectByDrinkParenNtame(textField.getText());
						  System.out.println(l.size());
						  if (!l.isEmpty() ) {
						 	JOptionPane.showMessageDialog(ttt.this, "名稱重複", "錯誤", JOptionPane.ERROR_MESSAGE);
						  }
						  else
						  {
						 	//新增大分類資料
							myDrinkParent m = new myDrinkParent();
							m.setMyDrinkParenNtame(textField.getText());
							m.setMyDrinkParentDescription(textField_1.getText());
							mpi.add(m);
							JOptionPane.showMessageDialog(ttt.this, "新增資料成功");
							myDrinkMaintain frame = new myDrinkMaintain();
							frame.setLocationRelativeTo(null); //視窗置中
							frame.setVisible(true);
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
