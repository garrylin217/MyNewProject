package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import controller.customerPage.CheckBoxTreeCellRenderer;
import dao.impl.MyDrinkParentDaoImpl;
import dao.impl.view_mydrinkdataDaoImpl;
import model.myDrink1;
import model.myDrinkParent;
import model.view_mydrinkdata;
import service.impl.MyDrink1serviceImpl;
import service.impl.myDrinkParentserviceImpl;
import service.impl.view_mydrinkdataserviceImpl;
import util.Cal;

import javax.swing.JTree;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class myDrinkMaintain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree tree;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode root_1;
	private DefaultTreeModel treeModel,treeModel_1;
	private String SelectedChildNode="";
	private String SelectedChildNode_1="";
    private myDrinkParentserviceImpl  mdps = new myDrinkParentserviceImpl(); 
    private MyDrink1serviceImpl mdcs=new MyDrink1serviceImpl(); 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myDrinkMaintain frame = new myDrinkMaintain();
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
	public myDrinkMaintain() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
		
			}
		});
		setTitle("產品內容維護");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 606);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		root_1 = new DefaultMutableTreeNode("產品名稱");
	    treeModel_1 = new DefaultTreeModel(root_1);
		contentPane.setLayout(null);
		JTree tree_2 = new JTree(treeModel_1);
		tree_2.setBounds(359, 30, 246, 448);
		tree_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		
		contentPane.add(tree_2);
		
	     root = new DefaultMutableTreeNode("產品分類");
	        treeModel = new DefaultTreeModel(root);
	    	JScrollPane scrollPane = new JScrollPane();
	    	scrollPane.setBounds(45, 30, 265, 459);
			contentPane.add(scrollPane);
			tree = new JTree(treeModel);
			scrollPane.setViewportView(tree);
			tree.setFont(new Font("微軟正黑體", Font.BOLD, 15));
			
			  tree_2.setCellRenderer(new CheckBoxTreeCellRenderer());
			    tree.setCellRenderer(new CheckBoxTreeCellRenderer());


		
		

		
		
		
		myDrinkParentserviceImpl mm = new myDrinkParentserviceImpl();
		List <myDrinkParent> l = mm.selectAll();
		
		DefaultMutableTreeNode[] a = 
        new DefaultMutableTreeNode[l.size()];
		int i =  0;
		for(myDrinkParent mm1:l)
	    {
	      a[i] = addNode(mm1.getMyDrinkParenNtame(),root); 
	      i++;
     
        }
		
		
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        	public void valueChanged(TreeSelectionEvent e) {
        		
        		TreeSelectionModel selectionModel = tree.getSelectionModel();
                TreePath[] selectedPaths = selectionModel.getSelectionPaths();

                if (selectedPaths != null) {
                    for (TreePath path : selectedPaths) {
                        Object selectedNode = path.getLastPathComponent();
                        SelectedChildNode = selectedNode.toString();
                        System.out.println("Selected Node: " + selectedNode);
                        
                        view_mydrinkdataserviceImpl vvv = new view_mydrinkdataserviceImpl();
                 	    List<view_mydrinkdata> l= 
                 		vvv.selectByDrinkParenNtame(selectedNode.toString());
                 		
                 		
                 		DefaultMutableTreeNode[] a = 
                 		new DefaultMutableTreeNode[l.size()];
                 		root_1.removeAllChildren();
                 		treeModel_1.reload(); 
                 		int i=0;
             			for(view_mydrinkdata v1:l)
             			{
             			      a[i] = addNode1(v1.getDrinkName()+":"+v1.getDrinkPrice(),root_1); 
             			      i++;
             			}
               
                    }
                } else {
                    System.out.println("No node selected.");
                }
 
        	}
        });
		
        tree_2.addTreeSelectionListener(new TreeSelectionListener() {
        	public void valueChanged(TreeSelectionEvent e) {
        		
        		TreeSelectionModel selectionModel = tree_2.getSelectionModel();
                TreePath[] selectedPaths = selectionModel.getSelectionPaths();

                if (selectedPaths != null) {
                    for (TreePath path : selectedPaths) {
                        Object selectedNode = path.getLastPathComponent();
                        SelectedChildNode_1=selectedNode.toString();
                        System.out.println("Selected Node: " + selectedNode);
                        
                  
                    }
                } else {
                    System.out.println("No node selected.");
                }
 
        	}
        });
		
		
		
      	JButton btnNewButton = new JButton("新增產品分類");
    		btnNewButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    			}
    		});
		JButton btnNewButton_1 = new JButton("新增產品細項");
		btnNewButton_1.setBounds(641, 189, 130, 49);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				List<myDrinkParent>l =mdps.selectByDrinkParenNtame(SelectedChildNode);
				if (SelectedChildNode == "")
					 JOptionPane.showMessageDialog(myDrinkMaintain.this, "請先選擇產品類別");
				else
				{
				Cal.SaveObject(l.get(0), "tmpfile.txt");
				System.out.println(SelectedChildNode);
				myDrinkChildMaintain mmm = new myDrinkChildMaintain() ;
				mmm.setVisible(true);
				mmm.setLocationRelativeTo(null);
				dispose();
				}
			}
		});
	
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		contentPane.add(btnNewButton_1);
		
		JButton editParentNode = new JButton("修改產品分類");
		editParentNode.setBounds(641, 117, 130, 49);

		editParentNode.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		contentPane.add(editParentNode);
		
		JButton editChildNode = new JButton("修改產品細項");
		editChildNode.setBounds(641, 263, 130, 49);
		editChildNode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (SelectedChildNode == "" || SelectedChildNode_1== "")
					 JOptionPane.showMessageDialog(myDrinkMaintain.this, "請先選擇產品類別或產品細項");
				else {
					int i = SelectedChildNode_1.indexOf(':');
					System.out.println(i);
					SelectedChildNode_1 = SelectedChildNode_1.substring(0,i);
					System.out.println("GARRY:"+SelectedChildNode_1);
				List<myDrinkParent>l =mdps.selectByDrinkParenNtame(SelectedChildNode);
				List<myDrink1>l1 = mdcs.selectByParentidAndDrinkName(l.get(0).getMyDrinkParenid(),SelectedChildNode_1);
				
				Cal.SaveObject(l.get(0),"tmpfile.txt");				
				Cal.SaveObject(l1.get(0),"tmpfile_1.txt");
				
				
				updateMyChild frame = new updateMyChild();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
				}
				
				
				
			}
		});
		editChildNode.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		contentPane.add(editChildNode);
		
		JButton btnNewButton_1_1_1_1 = new JButton("返回");
		btnNewButton_1_1_1_1.setBounds(641, 343, 130, 49);
		btnNewButton_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("新增產品分類");
		btnNewButton_1_1_2.setBounds(641, 51, 130, 49);
		btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				ttt frame = new ttt();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		contentPane.add(btnNewButton_1_1_2);
		editParentNode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SelectedChildNode == "")
					 JOptionPane.showMessageDialog(myDrinkMaintain.this, "請先選擇產品類別");
				else {
				List<myDrinkParent>l =mdps.selectByDrinkParenNtame(SelectedChildNode);
				Cal.SaveObject(l.get(0), "tmpfile.txt");				
				updateMyChild frame = new updateMyChild();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
				}
			}
		});		
		
		
  
		
	}
	// 自定義的渲染器類
    class CheckBoxTreeCellRenderer extends JCheckBox implements TreeCellRenderer {

        /**
    	 * 
    	 */
    	private static final long serialVersionUID = 1L;

    	@Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            // 設置勾選框的文本為節點的名稱
            setText(value.toString());
           
         //   System.out.println(value.toString());
            // 設置勾選框是否選中（這裡用 selected 只是為了改變顯示效果）
            setSelected(selected);
            // 設置勾選框是否可用
            setEnabled(tree.isEnabled());

            // 返回這個勾選框作為節點的顯示組件
            return this;
        }
    }
	
	
	   //新增節點
    public DefaultMutableTreeNode addNode(String nodeName,DefaultMutableTreeNode aaa) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
        treeModel.insertNodeInto(newNode, aaa, aaa.getChildCount());
        treeModel.reload(); // 更新顯示
        return newNode;
    }
	   //新增節點
   private DefaultMutableTreeNode addNode1(String nodeName,DefaultMutableTreeNode aaa) {
     DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
     treeModel_1.insertNodeInto(newNode, aaa, aaa.getChildCount());
     treeModel_1.reload(); // 更新顯示
     return newNode;
 }
 // 刪除節點的方法
    private void removeNode(String nodeName) {
        DefaultMutableTreeNode node = findNode(nodeName);
        if (node != null) {
            treeModel.removeNodeFromParent(node);
            treeModel.reload(); // 更新顯示
        }
    }

    

 
    
}
