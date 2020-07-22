package com.example.football.client;

import com.example.football.model.Competitions;
import com.example.football.model.Country;
import com.example.football.model.Standing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class RestClient {

    RestTemplate rt = new RestTemplate();
    public static String URL_COMP="https://apiv2.apifootball.com/?action=get_leagues&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    public static String URL_COUNTRY="https://apiv2.apifootball.com/?action=get_countries&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    public static String URL_STANDING="https://apiv2.apifootball.com/?action=get_standings&league_id=LEAGUE_ID&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";


    public Competitions[] getCompetitions(){
        ResponseEntity<Competitions[]> res = rt.getForEntity(URL_COMP,Competitions[].class);
        return res.getBody();
    }

    public Country[] getCountries(){
        ResponseEntity<Country[]> res = rt.getForEntity(URL_COUNTRY,Country[].class);
        return res.getBody();
    }

    public Standing[] getStanding(String league_id){
        String URL=URL_STANDING.replace("LEAGUE_ID",league_id);
        ResponseEntity<Standing[]> res = rt.getForEntity(URL,Standing[].class);
        return res.getBody();
    }





    public static void main(String[] args) {
        RestClient rs = new RestClient();
        System.out.println(rs.getStanding("148")[0]);
    }
}
