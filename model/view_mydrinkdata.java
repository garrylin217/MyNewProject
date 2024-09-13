package model;

public class view_mydrinkdata {

	
      private Integer myDrinkParentid;  //父分類名稱 id
      private String  myDrinkParentName;//父分類名稱
      private String  myDrinkParentDescription; //父分類描述
      private String  myDrinkParentCategory;  // 父分類種類
      private Integer DrinkId;   //飲料id
      private String  DrinkName; //飲料名稱
      private Integer DrinkPrice; //飲料單價
      private String  DrinkDescription; //飲料描述
      private String  DrinkCategory; //飲料種類
      
      
      public view_mydrinkdata(){}


	
	
	

	public Integer getMyDrinkParentid() {
		return myDrinkParentid;
	}






	public void setMyDrinkParentid(Integer myDrinkParentid) {
		this.myDrinkParentid = myDrinkParentid;
	}






	public String getMyDrinkParentName() {
		return myDrinkParentName;
	}






	public void setMyDrinkParentName(String myDrinkParentName) {
		this.myDrinkParentName = myDrinkParentName;
	}






	public String getMyDrinkParentDescription() {
		return myDrinkParentDescription;
	}






	public void setMyDrinkParentDescription(String myDrinkParentDescription) {
		this.myDrinkParentDescription = myDrinkParentDescription;
	}






	public String getMyDrinkParentCategory() {
		return myDrinkParentCategory;
	}






	public void setMyDrinkParentCategory(String myDrinkParentCategory) {
		this.myDrinkParentCategory = myDrinkParentCategory;
	}






	public Integer getDrinkId() {
		return DrinkId;
	}






	public void setDrinkId(Integer drinkId) {
		DrinkId = drinkId;
	}






	public String getDrinkName() {
		return DrinkName;
	}






	public void setDrinkName(String drinkName) {
		DrinkName = drinkName;
	}






	public Integer getDrinkPrice() {
		return DrinkPrice;
	}






	public void setDrinkPrice(Integer drinkPrice) {
		DrinkPrice = drinkPrice;
	}






	public String getDrinkDescription() {
		return DrinkDescription;
	}






	public void setDrinkDescription(String drinkDescription) {
		DrinkDescription = drinkDescription;
	}






	public String getDrinkCategory() {
		return DrinkCategory;
	}






	public void setDrinkCategory(String drinkCategory) {
		DrinkCategory = drinkCategory;
	}






	public String show() {
		return this.myDrinkParentid+"\n" +
			   this.myDrinkParentName +"\n" +
			   this.myDrinkParentDescription +"\n";
	}
	
}
