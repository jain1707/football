package com.example.football.service;

import com.example.football.business.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

}
