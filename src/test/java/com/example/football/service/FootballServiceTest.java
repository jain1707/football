package com.example.football.service;

import com.example.football.business.Processor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import javax.ws.rs.core.Response;

import static com.example.football.business.Processor.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class FootballServiceTest {
    FootballService fs;
    Processor p;
    @Test
    void get() {
        List<Node> ll = new ArrayList<>();
        ll.add(new Node("Country ID & Name:","46-France"));
        when(p.getStandings()).thenReturn(ll);
        Response r = fs.get();
        assertNotNull(r);
        assertEquals(200,r.getStatus());
        assertEquals(1,((List)r.getEntity()).size());
    }

    @Test
    void getByNameSearch() {
        List<Node> ll = new ArrayList<>();
        ll.add(new Node("Country ID & Name:","46-France"));
        when(p.searchWithName("France","Ligue 2","Caen")).thenReturn(ll);
        Response r = fs.getByNameSearch("France","Ligue 2","Caen");
        assertNotNull(r);
        assertEquals(200,r.getStatus());
        assertEquals(1,((List)r.getEntity()).size());
    }

    @BeforeEach
    void setUp() {
        fs = new FootballService();
        p = Mockito.mock(Processor.class);
        fs.setP(p);

    }

    @AfterEach
    void tearDown() {
    }
}