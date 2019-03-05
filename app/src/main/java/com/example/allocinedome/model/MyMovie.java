package com.example.allocinedome.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyMovie implements Serializable {
    public String title;
    public Poster poster;
    public Trailer trailer;
    public ArrayList<Genre> genre;
    public Release release;
    public Statistics statistics;
}
