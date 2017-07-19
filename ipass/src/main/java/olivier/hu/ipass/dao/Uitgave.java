package olivier.hu.ipass.dao;

public class Uitgave {
	private int uitgave_id;
	private int prijs;
	private String date;
	private String omschrijving;
	private int user_id_f;
	private int cat_id_f;

	public Uitgave(int id,int prs, String dt, String oms,int cat,int us){
		this.uitgave_id = id;
		this.prijs = prs;
		this.date =dt;
		this.omschrijving = oms;
		this.cat_id_f = cat;
		this.user_id_f = us;
	}
	
	public int getUser_id_f() {
		return user_id_f;
	}

	public void setUser_id_f(int user_id_f) {
		this.user_id_f = user_id_f;
	}

	public int getCat_id_f() {
		return cat_id_f;
	}

	public void setCat_id_f(int cat_id_f) {
		this.cat_id_f = cat_id_f;
	}

	public void setUitgave_id(int id){
		this.uitgave_id = id;
	}
	
	public void setPrijs(int prs){
		this.prijs = prs;
	}
	
	public void setDate(String dt){
		this.date = dt;
	}
	
	public void setOmschrijving(String oms){
		this.omschrijving = oms;
	}
	
	public int getUitgave_id(){
		return this.uitgave_id;
	}
	
	public int getPrijs(){
		return this.prijs;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getOmschrijving(){
		return this.omschrijving;
	}
}


