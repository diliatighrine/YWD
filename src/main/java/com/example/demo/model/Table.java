// Table.java
package com.example.demo.model;

import java.util.List;

public class Table {
    private Long id;
    private String name;
    private List<TableRow> data;

    public Table(String name) {
        this.name = name;
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

    public List<TableRow> getData() {
        return data;
    }

    public void setData(List<TableRow> data) {
        this.data = data;
    }

    public void addRow(String row2) {
        if (row2 == null || row2.isEmpty()) {
            throw new IllegalArgumentException("La ligne ne peut pas être null ou vide.");
        }

        TableRow row = new TableRow(); // Créer une nouvelle instance de TableRow
        row.setData(row2); // Définir les données de la ligne

        data.add(row); // Ajouter la ligne à la liste de données
    }

    public void deleteRow(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("L'index spécifié est invalide.");
        }
        data.remove(index);
    }

    public void addData(List<String> row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addData'");
    }

    public Object getRow(int i) {
        return i;
    }

}
