package controller;
import javax.swing.*;

import model.Member;
import service.impl.MemberserviceImpl;
import util.Cal;
import util.DynamicTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class  memberManage1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static  List<String[]> data1 = new ArrayList<>();	
	private static  String[] columnNames = { "會員名稱", "登入名稱", "密碼","電話號碼","會員等級"};	
    static DynamicTableModel modeltt = new DynamicTableModel(data1, columnNames);
	
	
    public memberManage1() {
        // 設置 JFrame 標題
        super("Custom JFrame with JTable and ScrollBar");
        setTitle("會員資料維護");

        // 設置 JFrame 大小
        setSize(627, 551);

        // 設置默認關閉操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  JTable
        JTable table = new JTable(modeltt);
        table.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        
   
        
        JButton button2 = new JButton("回上頁");
        button2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
        button2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		managePage mm = new managePage();
        		mm.setLocationRelativeTo(null);
				mm.setVisible(true);
				dispose();
        	}
        });
        // 創建 Member Array
        List<Member> l = new MemberserviceImpl().findAll();
        modeltt.clear();
        
        for(Member m : l)
        {	
           	modeltt.addRow(new String[]
       		{m.getMembername(),m.getUsername(),m.getPassword(),m.getPhone(),m.getLevel()});
        			   
        }
    
     
       
        
  

      
        JButton button1 = new JButton("確定");
        button1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
        button1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        
        		System.out.println(modeltt.getRowCount());
				System.out.println(l.size());
				int selectedRow = table.getSelectedRow();
				if (table.getRowCount()==0)
				    JOptionPane.showMessageDialog(memberManage1.this, "沒有任何會員資料");
				else
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(memberManage1.this, "請選擇要修改的會員資料");
				else					
				{
					
				System.out.println(selectedRow);
				Cal.SaveObject(l.get(selectedRow), "tmpFile.txt");
				updateMember um = new updateMember();
				um.setLocationRelativeTo(null); //視窗置中
		        um.setVisible(true);
				dispose();
				
			//	modeltt.removeRow(selectedRow);
			//	mo.remove(selectedRow);
				
				System.out.println(modeltt.getRowCount());
				System.out.println(l.size());
				}
				
        	}
        	
        	
        	
        });
 
        
       
        	
				 JPanel buttonPanel = new JPanel();			        
			        buttonPanel.add(button1);
			        buttonPanel.add(button2);
			        // 創建 JScrollPane 並將 JTable 添加到其中
			        JScrollPane scrollPane = new JScrollPane(table);

			        // 將 JScrollPane 添加到 JFrame
			        getContentPane().add(scrollPane, BorderLayout.CENTER);
			        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			        getContentPane().add(scrollPane, BorderLayout.CENTER);
			    
			        
			        
			        
        	

        
    
        }
    // 主方法，用於測試和顯示 CustomFrame
    public static void main(String[] args) {
        // 創建 CustomFrame 實例
    	memberManage1 frame = new memberManage1();

        // 設置 JFrame 可見
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
