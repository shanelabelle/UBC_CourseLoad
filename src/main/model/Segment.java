package model;

import java.util.ArrayList;

public class Segment {

    private String type;
    private float weight;


    public Segment(String type, int weight) {
        this.type = type;
        this.weight = weight / 100;
    }
}
