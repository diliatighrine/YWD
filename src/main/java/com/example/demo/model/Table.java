package com.example.demo.model;

import java.util.List;

public class Table {
    private Long id;
    private String name;
    private List<List<String>> data;


    public Table() {
    }

    // Constructeur avec id et name
    public Table(Long id, String name) {
        this.id = id;
        this.name = name;
        this.data = null;
    }

    // Getters et setters pour id, name et data
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
