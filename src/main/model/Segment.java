package model;

import java.util.Objects;

public class Segment implements Comparable<Segment> {
    private String type;
    private int weight;

    public Segment(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Segment segment = (Segment) o;
        return weight == segment.weight
                && Objects.equals(type, segment.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }

    public String getType() {
        return this.type;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Segment otherSegment) {
        return this.weight - otherSegment.getWeight();
    }
}
