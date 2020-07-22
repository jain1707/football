package com.example.football.client;

import com.example.football.model.Competitions;
import com.example.football.model.Country;
import static org.junit.jupiter.api.Assertions.*;

import com.example.football.model.Standing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestClientTest {
    RestClient rs = new RestClient();

    @Test
    void getCompetitions() {
        Competitions[] c = rs.getCompetitions();
        assertNotNull(c);
        assertEquals(2,c.length);
    }

    @Test
    void getCountries() {
        Country[] c = rs.getCountries();
        assertNotNull(c);
        assertEquals(2,c.length);
    }

    @Test
    void getStanding() {
        Standing[] c = rs.getStanding("149");
        assertNotNull(c);
        assertEquals(24,c.length);
    }
}