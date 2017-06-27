package services;

import dbUtil.Resolution;
import dbUtil.dbHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/solutions")
public class LevelService {
    private dbHandler dbHandler=new dbHandler();

 @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String getSolution(@PathParam("name") String name)
 {
     if(dbHandler.getSolution(name)!=null)
        return dbHandler.getSolution(name);
     else
         return null;
 }

 @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addSolution(@FormParam("name") String name, @FormParam("solution") String solution)
 {
     System.out.println("ADDING SOLUTION TRIGGERED, DETAILS:"+name+" "+solution);
     Resolution sol=new Resolution(name,solution);
     dbHandler.addSolution(sol);
 }

}
