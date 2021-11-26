package com.epam.tc.hw7.entity;

import java.util.Arrays;
import java.util.List;

public class MetalsAndColors {
    private List<Integer> summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public MetalsAndColors(List<Integer> summary, String[] elements, String color, String metals,
                           String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public List<String> toListString() {
        return Arrays.asList("Summary: " + getSum(),
                "Elements: " + Arrays.toString(elements).replaceAll("[\\[\\]]", ""),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: " + Arrays.toString(vegetables).replaceAll("[\\[\\]]", ""));
    }

    public Integer getSum() {
        return getSummary().get(0) + getSummary().get(1);
    }
}
