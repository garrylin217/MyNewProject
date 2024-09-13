package controller;

import java.util.ArrayList;
import java.util.List;



import javax.swing.*;


import model.Member;
import service.impl.MemberserviceImpl;
import util.DynamicTableModel;

import java.awt.*;

public class memberManage {
	
	private static  List<String[]> data1 = new ArrayList<>();
	
	private static  String[] columnNames = { "會員名稱", "登入名稱", "密碼","電話號碼","會員等級"};
    static DynamicTableModel modeltt = new DynamicTableModel(data1, columnNames);
	
    public static void main(String[] args) {
        // 创建 JFrame
        JFrame frame = new JFrame("會員管理");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(705, 567);
        frame.getContentPane().setLayout(new BorderLayout());
        
        // 创建列名
       
        List<Member> l = new MemberserviceImpl().findAll();
                // 创建 JTable
        JTable table = new JTable(modeltt);
        
     //   table.setShowGrid(false);
        table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
        // 将 JTable 放入 JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        for(Member m : l)
        {	
              	modeltt.addRow(new String[]
       			{m.getMembername(),m.getUsername(),m.getPassword(),m.getPhone(),m.getLevel()});
        			   
        }
        // 添加 JScrollPane 到 JFrame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    	frame.setLocationRelativeTo(null); //視窗置中
        // 设置 JFrame 显示
        frame.setVisible(true);
        
    }
    
    public  memberManage() {}
}