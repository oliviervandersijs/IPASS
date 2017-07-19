package olivier.hu.ipass.dao;

public class Gebruiker {
		private int user_id;
		private int maandinkomen;
		private String username;
		private String password;
		private String email;
		
		public Gebruiker(int id, String us, String ps, String ema,int mi){
			this.user_id = id;
			this.maandinkomen = mi;
			this.username = us;
			this.password = ps;
			this.email = ema;
		}
		
		public Gebruiker(String us, String ps, String ema,int mi){
			this.username = us;
			this.password = ps;
			this.email = ema;
			this.maandinkomen = mi;
			
			
		}
		
		public void setUser_id(int id){
			this.user_id = id;
		}
		
		public void setMaandinkomen(int mi){
			this.maandinkomen = mi;
		}
		
		public void setUsername(String us){
			this.username = us;
		}
		
		public void setPassword(String ps){
			this.password = ps;
		}
		
		public void setEmail(String ema){
			this.email = ema;
		}
		
		public int getUser_id(){
			return this.user_id;
		}
		
		public int getMaandinkomen(){
			return this.maandinkomen;
		}
		
		public String getUsername(){
			return this.username;
		}
		
		public String getPassword(){
			return this.password;
		}
		
		public String getEmail(){
			return this.email;
		}
		
}
