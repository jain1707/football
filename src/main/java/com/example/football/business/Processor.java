package com.example.football.business;

import com.example.football.client.RestClient;
import com.example.football.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Processor {
    @Autowired
    private RestClient rc;
    public static String country = "Country ID & Name:";
    public static String league = "League ID & Name: ";
    public static String team = "Team ID & Name: ";
    public static String position = "Overall League Position:";

    public List<Node> getStandings(){
        List<Node> nodes = new ArrayList<>();
        HashMap<String, String> countryMap = new HashMap<>();
        for (Country c:rc.getCountries()) {
            countryMap.put(c.getCountry_name(),c.getCountry_id());
        }

        Set<String> leagues = Arrays.stream(rc.getCompetitions()).map(i -> i.getLeague_id()).collect(Collectors.toSet());
        leagues.stream().map( i -> rc.getStanding(i)).flatMap(i -> Arrays.stream(i)).
                forEach(i -> {
            nodes.add(new Node(country, countryMap.get(i.getCountry_name()) +"-"+i.getCountry_name()));
            nodes.add(new Node(league, i.getLeague_id() +"-"+i.getLeague_name()));
            nodes.add(new Node(team, i.getTeam_id() +"-"+i.getTeam_name()));
            nodes.add(new Node(position, i.getOverall_league_position()));
        });
        return nodes;
    }

    public static class Node{
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
