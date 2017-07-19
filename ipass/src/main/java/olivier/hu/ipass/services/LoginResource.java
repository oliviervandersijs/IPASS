package olivier.hu.ipass.services;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import olivier.hu.ipass.dao.GebruikerDAO;




@Path("/login")
public class LoginResource {
	ServiceProvider OrderService = new ServiceProvider();
	GebruikerDAO gebDAO = OrderService.getGebruikerDAO();
		
	@POST
	@Path("/check")
	@Produces("application/json")
	public Response Login(
			@FormParam ("naam") String nm,
			@FormParam ("wachtwoord") String ww){
			System.out.println(nm);
			System.out.println(ww);

			 JsonArrayBuilder jab = Json.createArrayBuilder();
			 JsonObjectBuilder job = Json.createObjectBuilder();
			 
			if(gebDAO.findByUsername(nm)== null) {
				job.add("username", nm);
				job.add("password", ww);
				job.add("status" , "LoginFalse");
			} else if(ww.equals(gebDAO.findByUsername(nm).getPassword())){
					job.add("username", nm);
					job.add("password", ww);
					job.add("status" , "LoginTrue");
			} else{
				job.add("username", nm);
				job.add("password", ww);
				job.add("status" , "LoginFalse");
			}
			jab.add(job);
			String returnvalue = jab.build().toString();
			return Response.status(201).entity(returnvalue).build();
	}	
}