package olivier.hu.ipass.dao;

public class Categorie {

	private int cat_id;
	private int budget;
	private String omschrijving;
	private int user_id;

	public Categorie(int id, int bud, String oms,int uid){
		this.cat_id =id;
		this.budget =bud;
		this.omschrijving = oms;
		this.user_id = uid;
	}
	
	public void setCat_id(int id){
		this.cat_id = id;
	}
	
	public void setBudget(int bud){
		this.budget = bud;
	}
	
	public void setOmschrijving(String oms){
		this.omschrijving = oms;
	}
	
	public int getCat_id(){
		return this.cat_id;
	}
	
	public int getBudget(){
		return this.budget;
	}
	
	public String getOmschrijving(){
		return this.omschrijving;
	}

}

