package olivier.hu.ipass.services;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import olivier.hu.ipass.dao.Categorie;
import olivier.hu.ipass.dao.CategorieDAO;
import olivier.hu.ipass.dao.GebruikerDAO;
import olivier.hu.ipass.dao.Uitgave;
import olivier.hu.ipass.dao.UitgaveDAO;
import oracle.jdbc.proxy.annotation.Post;


@Path("/main")
public class MainResource {
	ServiceProvider OrderService = new ServiceProvider();
	GebruikerDAO gebDAO = OrderService.getGebruikerDAO();
	UitgaveDAO uitDAO = OrderService.getUitgaveDAOO();
	CategorieDAO catDAO = OrderService.getCategorieDAO();
	
	@POST
	@Path("/opslaan")
	@Produces("application/json")
	public Response Opslaan(
			@FormParam ("naam") String oms,
			@FormParam ("date") String date,
			@FormParam ("prijs") String pr
			){
				System.out.println(oms);
				System.out.println(date);
				System.out.println(pr);

			 JsonArrayBuilder jab = Json.createArrayBuilder();
			 JsonObjectBuilder job = Json.createObjectBuilder();
			 
			
			jab.add(job);
			String returnvalue = jab.build().toString();
			return Response.status(201).entity(returnvalue).build();
	}	
	
	
	@GET
	@Path("/uitgave/{id}")
	public String fillUitgave(@PathParam("id") String user){
			System.out.println(user);
			System.out.println(gebDAO.findByUsername(user).getEmail());
			 JsonArrayBuilder jab = Json.createArrayBuilder();
			 int x = 0;
		    for (Uitgave u : uitDAO.findAll()) {
		    	if(u.getUser_id_f() == gebDAO.findByUsername(user).getUser_id()){
		    		x++;
		      JsonObjectBuilder job = Json.createObjectBuilder();
		      		
			      job.add("omschrijving", u.getOmschrijving());
			      job.add("datum",u.getDate());
			      job.add("prijs",u.getPrijs());
			      job.add("categorie",catDAO.findByID(u.getCat_id_f()).getOmschrijving());
	
			      jab.add(job);
		    	}
		    }
		   
		    JsonArray array = jab.build();
		    return array.toString();
		  
		   
	}	
	
	@GET
	@Path("/categorie/{id}")
	public String fillCategorie(@PathParam("id") String id) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for (Categorie c : catDAO.findAll()) {
			if(id.equals(gebDAO.findByUsername(id).getUsername())){
    	
    		JsonObjectBuilder job = Json.createObjectBuilder();
    		job.add("omschrijving", c.getOmschrijving());
    		job.add("budget",c.getBudget());
	       jab.add(job);
    	}
    }
		 JsonArray array = jab.build();
		    return array.toString();
}
}