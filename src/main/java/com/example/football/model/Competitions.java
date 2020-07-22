package com.example.football.model;

public class Competitions {
    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;

    public String getCountry_id() {
        return country_id;
    }

    @Override
    public String toString() {
        return "Competitions{" +
                "country_id='" + country_id + '\'' +
                ", country_name='" + country_name + '\'' +
                ", league_id='" + league_id + '\'' +
                ", league_name='" + league_name + '\'' +
                '}';
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }
}
