package com.example.allocinedome.model;


import java.util.List;

public class Theater {
    public String code;
    public String name;
    public String address;
    public int postalCode;
    public String city;
    public String area;
    public MyPicture picture;
    public CinemaChain cinemaChain;
    public int hasPRMAccess;
    public int openToSales;
    public GeoLoc geoloc;
    public List<Link> link;
}
