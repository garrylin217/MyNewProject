package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;




public class Cal {
/*	
	//切換到註冊頁, 註冊頁經常會用到. 可以獨立將其寫出method
	public static void gotoAddMember()
	{
		AddMemberUI a=new AddMemberUI();
		a.setVisible(true);
		 
	}
	
*/	
	//存檔,為了跨頁可以暫存資料
	/**
	 * 利用 object write 
	 * @param o
	 * @param fileName
	 */
	public static void SaveObject(Object o,String fileName)
	{
		try {
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(o);
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	//讀取檔,資料暫存
	/**
	 * 利用 object read 
	 * @param fileName
	 * @return
	 */
	public static Object ReadObject(String fileName)
	{
		Object o=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			o=ois.readObject();
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return o;
	}
	
	public static boolean isNumeric(String str){
		for(int i=str.length();--i>=0;){
		int chr=str.charAt(i);
		if(chr<48 || chr>57)
		return false;
		}
		return true;
		}
		

}