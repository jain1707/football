package com.example.football.service;

import com.example.football.business.Processor;
import com.example.football.model.NameSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("ranking")
@Service
public class FootballService {
    @Autowired
    Processor p;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        return Response.status(200).entity(p.getStandings()).build();
    }

    @GET
    @Path("{country}/{league}/{team}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByNameSearch(@PathParam("country") String country, @PathParam("league") String league,
                                    @PathParam("team") String team){
        List<Processor.Node> nodes = p.searchWithName(country,league,team);
        return Response.status(200).entity(nodes).build();
    }

}
