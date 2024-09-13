package controller;

import java.awt.Component;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import controller.customerPage.ClockRunnable;

import dao.impl.MyDrinkParentDaoImpl;
import dao.impl.view_mydrinkdataDaoImpl;
import model.Member;
import model.discountlevel;
import model.myDrink1;
import model.myDrinkParent;
import model.myOrder;
import model.tmpMyOrder;
import model.view_mydrinkdata;
import service.impl.DiscountlevelserviceImpl;
import service.impl.MyDrink1serviceImpl;
import service.impl.myDrinkParentserviceImpl;
import service.impl.myOrderserviceImpl;
import service.impl.view_mydrinkdataserviceImpl;

import util.Cal;
import util.DynamicTableModel;

import javax.swing.JTree;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.sql.Timestamp;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class customerPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree tree;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode root_1;
	private DefaultTreeModel treeModel,treeModel_1;
	private String SelectedChildNode="";
	private String SelectedChildNode_1="";
    private myDrinkParentserviceImpl  mdps = new myDrinkParentserviceImpl(); 
    private MyDrink1serviceImpl mdcs= new MyDrink1serviceImpl();
    private DiscountlevelserviceImpl dlsi =  new DiscountlevelserviceImpl();
    private myOrderserviceImpl mosi = new myOrderserviceImpl();
    private Member mmmm ;
	private JLabel timeLabel1 = new JLabel() ;	
	private List<myOrder> mo =new ArrayList<myOrder>();
	private List<String[]> data1 = new ArrayList<>();
	private List<discountlevel> dl = new ArrayList<discountlevel>();
	private String[] columnNames = {"名稱", "數量","單價","總價"};	
	private DynamicTableModel modeltt = new DynamicTableModel( data1, columnNames);
	private Double dlsValue =(double) 0 ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerPage frame = new customerPage();
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
	public customerPage() {
		setResizable(false);
		
		
		addWindowListener(new WindowAdapter() {
		     public void windowActivated(WindowEvent e) {	    	 
		        super.windowActivated(e);
				new Thread(new ClockRunnable()).start();
			}
			});
		
		
		mmmm = (Member)Cal.ReadObject("tmpfile.txt");
		dl = dlsi.selectById(mmmm.getLevelid());
		dlsValue= dl.get(0).getDiscount();
		
		
		setTitle("點餐系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 509);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sumprice = new JLabel("");
		sumprice.setBounds(598, 235, 128, 38);
		sumprice.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(sumprice);

		
		JLabel prodLabel = new JLabel("");
		prodLabel.setBounds(599, 63, 141, 44);
		prodLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(prodLabel);
		SpinnerModel value =  
                new SpinnerNumberModel(0, //initial value  
                 0, //minimum value  
                1000, //maximum value  
                 1); //step  
		JSpinner spinner = new JSpinner(value);
		spinner.setBounds(598, 143, 128, 38);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println(spinner.getValue().toString());
				int j = SelectedChildNode_1.indexOf(':');
				//int sum1 = (Integer.valueOf(SelectedChildNode_1.substring(j+1))*(Integer)(spinner.getValue()));
				String sum2 = String.valueOf((Integer.valueOf(SelectedChildNode_1.substring(j+1))*(Integer)(spinner.getValue())));
				sumprice.setText(sum2);
					
					
				
			}
		});
		spinner.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		contentPane.add(spinner);
		JLabel lblProdlabel = new JLabel("購買數量:");
		lblProdlabel.setBounds(598, 104, 128, 38);
		lblProdlabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblProdlabel);

		JLabel lblProdlabel_2 = new JLabel("小計:");
		lblProdlabel_2.setBounds(598, 191, 128, 38);
		lblProdlabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblProdlabel_2);
		
	
		
		
		
		root_1 = new DefaultMutableTreeNode("產品名稱");
	    treeModel_1 = new DefaultTreeModel(root_1);
		JTree tree_2 = new JTree(treeModel_1);
		tree_2.setBounds(331, 73, 243, 382);
		tree_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		
		contentPane.add(tree_2);
		
        root = new DefaultMutableTreeNode("產品分類");
        treeModel = new DefaultTreeModel(root);
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(45, 73, 265, 382);
		contentPane.add(scrollPane);
		tree = new JTree(treeModel);
		scrollPane.setViewportView(tree);
		tree.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		
		//	scrollPane.add(tree);
		//    tree.setCellRenderer(new CheckBoxTreeCellRenderer());
		    
		    
        tree.addTreeSelectionListener(new TreeSelectionListener() {
        	public void valueChanged(TreeSelectionEvent e) {
        		
        		TreeSelectionModel selectionModel = tree.getSelectionModel();
                TreePath[] selectedPaths = selectionModel.getSelectionPaths();

                if (selectedPaths != null) {
                    for (TreePath path : selectedPaths) {
                        Object selectedNode = path.getLastPathComponent();
                        SelectedChildNode = selectedNode.toString();
                        System.out.println("Selected Node: " + selectedNode);
                        prodLabel.setText("");
                        sumprice.setText("");
                        spinner.setValue(0);;
                        
                        
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
		
        tree_2.addTreeSelectionListener(new TreeSelectionListener() {
        	public void valueChanged(TreeSelectionEvent e) {
        		
        		TreeSelectionModel selectionModel = tree_2.getSelectionModel();
                TreePath[] selectedPaths = selectionModel.getSelectionPaths();

                if (selectedPaths != null) {
                    for (TreePath path : selectedPaths) {
                        Object selectedNode = path.getLastPathComponent();
                        SelectedChildNode_1=selectedNode.toString();
                        System.out.println("Selected Node: " + selectedNode);
                        if (SelectedChildNode != "" && SelectedChildNode_1 != "" && 
                            SelectedChildNode != "產品分類" && SelectedChildNode_1 != "產品名稱")
                        {
                        	prodLabel.setText(SelectedChildNode_1);
                        	spinner.setValue(0);
                        }
                    }
                } else {
                    System.out.println("No node selected.");
                }
 
        	}
        });
        

		
		
		
   
		
		JButton backButton = new JButton("登出");
		backButton.setBounds(598, 417, 128, 38);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newLoginUI lg = new newLoginUI();
		    	lg.setLocationRelativeTo(null); //視窗置中
		        lg.setVisible(true);
		   		dispose();
			 
					
			}
			  
		});
		backButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		contentPane.add(backButton);
		
		JLabel memberLabel = new JLabel("New label");
		memberLabel.setBounds(35, 0, 592, 53);
		memberLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(memberLabel);
		memberLabel.setText(mmmm.getMembername()+ "您好 !  您的會員等級是:"+mmmm.getLevel()+"    折數:"+ dlsValue);
		
		timeLabel1.setBounds(752, 10, 193, 53);
		
		

		
	

		
		
		
		timeLabel1.setText("TimeLabel");
		timeLabel1.setForeground(new Color(0, 0, 0));
		timeLabel1.setBackground(new Color(255, 255, 255));
		

		timeLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel1.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(timeLabel1);
		
		
	
        JTable table = new JTable(modeltt);
        table.setShowGrid(false);
        table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));     
		table.setBounds(750, 73, 451, 372);
        // 移除 JTable 邊框 table.setShowGrid(false);

        // 移除表格的內部邊框
        table.setBorder(null);
 

    
        // 移除 TableHeader 邊框
        JTableHeader header = table.getTableHeader();
		contentPane.add(table);

		
		
		JButton addToCar = new JButton("加入購物車-->");	
		addToCar.setBounds(598, 273, 125, 38);
		addToCar.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("spvalue="+(Integer)spinner.getValue());
				if ((Integer)spinner.getValue()==0) 
				 JOptionPane.showMessageDialog(customerPage.this, "請輸入正確數量");
				else
				{
				if (prodLabel.getText()!= "" && (Integer)spinner.getValue()!=0) { 	
				int j = SelectedChildNode_1.indexOf(':');				
				String SelectedChildNode_2 = SelectedChildNode_1.substring(0,j);	
			    System.out.println(SelectedChildNode+":::"+SelectedChildNode_1);
	
				myOrder o = new myOrder();
				Timestamp now = new Timestamp(System.currentTimeMillis());
				
				List<myDrinkParent>l1 =mdps.selectByDrinkParenNtame(SelectedChildNode);
				List<myDrink1>l2 = mdcs.selectByParentidAndDrinkName(l1.get(0).getMyDrinkParenid(),SelectedChildNode_2);
				
			
				//為了顯示在JTbale
				// {  "名稱","數量","單價","總價"};
			
				modeltt.addRow(new String[]{
						SelectedChildNode_1.substring(0,j),						 
						(spinner.getValue()).toString(),
						(Integer.valueOf(SelectedChildNode_1.substring(j+1)).toString() ),
						String.valueOf(Double.valueOf(sumprice.getText())*dlsValue)
								});
							       
				// 為了後面寫入DB
				
				o.setMemberid(mmmm.getMemberid());
				o.setDrinkid(l2.get(0).getDrinkid());
				o.setDrinkprice((Integer.valueOf(SelectedChildNode_1.substring(j+1))));
				o.setOrderdatetime(now);
				o.setOrderqty((Integer)(spinner.getValue()));
				o.setDrinkname(SelectedChildNode_1.substring(0,j));
				o.setOrdersum();
			//	addCarArea.setText(addCarArea.getText()+o.show1()+"\n");
				mo.add(o);
				}
					
				
				
			} }
		});
		addToCar.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		contentPane.add(addToCar);
		
		JButton addToCar_1 = new JButton("<--移除購物車");
		addToCar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {  
				System.out.println(modeltt.getRowCount());
				System.out.println(mo.size());
				int selectedRow = table.getSelectedRow();
				if (table.getRowCount()==0)
				  JOptionPane.showMessageDialog(customerPage.this, "購物車內沒有任何購物資料");
				else
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(customerPage.this, "請選擇要刪除的購物資料");
				else					
				{
					
				System.out.println( selectedRow);
				modeltt.removeRow(selectedRow);
				mo.remove(selectedRow);
				System.out.println(modeltt.getRowCount());
				System.out.println(mo.size());
				
			}
		}});
		addToCar_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		addToCar_1.setBounds(598, 321, 125, 38);
		contentPane.add(addToCar_1);
		
		JButton PayButton = new JButton("結帳");
		PayButton.addMouseListener(new MouseAdapter() {
			
	    
			@Override
			public void mouseClicked(MouseEvent e) {
			    if (table.getRowCount()!=0) {
			    	 int sumtotal= 0;
			    	for(myOrder l:mo) {
			    		sumtotal += l.getDrinkprice();
		//	       	System.out.println(l.getDrinkprice());
			    	mosi.add(l);
			    	modeltt.clear();
			     }
			  
			    	{
			    JOptionPane.showMessageDialog(customerPage.this, "您的購買金額: "+sumtotal+"  已結帳完成!");
			    spinner.setValue(0);
			    sumprice.setText("0");
			    
			    	}
	         }
			    else
	         JOptionPane.showMessageDialog(customerPage.this, "購物車內沒有任何購物資料");  
 			}
		});
		PayButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		PayButton.setBounds(598, 369, 128, 38);
		contentPane.add(PayButton);
		


           
        

		

  
		
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
   public class ClockRunnable implements Runnable
	{
		

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while ( true) {
			//	System.out.println(getTime());
				timeLabel1.setText(getTime());
			//	timeLabel1.setText(getTime());
				try {
			    Thread.sleep(1000);		  
				}
				catch ( InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	    	
	}
   
   
   private static String format(int number) {
		return number<10?"0"+number:""+number;
		
	}
	
	private static String getTime() {
		Calendar calendar=new GregorianCalendar();
		
		int Hour = calendar.get(Calendar.HOUR_OF_DAY);
		int Minute = calendar.get(Calendar.MINUTE);
		int Second = calendar.get(Calendar.SECOND);
		return format(Hour)+":"+format(Minute)+":"+format(Second);
	}
}
        
    
    	
  	
    	 
    


