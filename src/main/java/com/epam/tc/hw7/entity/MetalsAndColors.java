package com.epam.tc.hw7.entity;

import java.util.List;

public class MetalsAndColors {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public MetalsAndColors(List<Integer> summary, List<String> elements, String color, String metals,
                           List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public Integer getSum() {
        return getSummary().get(0) + getSummary().get(1);
    }
}
