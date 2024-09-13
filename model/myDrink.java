package model;

// 啟始產品內容 
// name : 產品名稱
// price: 產品單價
// description : 產品描述
// category : 產品種類
//       x: 購買數量
class DrinkItem extends myDrinkParent{
 /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 private String name;
 private double price;
 private String description;
 private String category;
 private double x; 
 static double memberDiscount; //會員折扣
 
 

//Constructor

  static {
	  memberDiscount= 0.9;
  }


 public DrinkItem(String myDrinkParenNtame, String myDrinkParentDescription, String myDrinkParentCategory,
            	  String name, double price, String description, String categor,double x ) {
	 
	 super(myDrinkParenNtame, myDrinkParentDescription, myDrinkParentCategory);
     this.name = name;
     this.price = price;
     this.description = description;
     this.category = category;
     this.x = x;
     
 
 }

 // method Getter 和 Setter 
 public String getName() { return name; }
 public void setName(String name) { this.name = name; }

 public double getPrice() { return price; }
 public void setPrice(double price) { this.price = price; }

 public String getDescription() { return description; }
 public void setDescription(String description) { this.description = description; }

 public String getCategory() { return category; }
 public void setCategory(String category) { this.category = category; }

public double getX() {
	return x;
}

public void setX(double x) {
	this.x = x;
}

public double getSum() {
		return this.x*this.price;
	}
//顯示所以fileds
public void show(){
	super.show();
	System.out.println("名稱:"+this.name+"\t描述:"+this.description+"\t種類:"+this.category+"\t單價:"+this.price);
}

//取的會員折扣數
public static double getMemberDiscount() {
	return memberDiscount;
}

public static void setMemberDiscount(double memberDiscount) {
	DrinkItem.memberDiscount = memberDiscount;
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
 
 





