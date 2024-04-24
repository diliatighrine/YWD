
package com.example.demo.model;

import java.util.List;

public class Table {
    private Long id;
    private String name;

    private List<TableRow> data;

    public Table(String name) {
        this.name = name;
    }

    public Table(Long id, String name) {
        this.id = id;
        this.name = name;
        this.data = null;
    }

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

    public void addRow(List<String> rowData) {
        if (rowData == null || rowData.isEmpty()) {
            throw new IllegalArgumentException("La ligne ne peut pas être null ou vide.");
        }

        TableRow row = new TableRow(rowData); // Créer une nouvelle instance de TableRow avec les données
        data.add(row); // Ajouter la ligne à la liste de données
    }

    public void deleteRow(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("L'index spécifié est invalide.");
        }
        data.remove(index);
    }

    // à faire
    public void addData(List<String> row) {
        throw new UnsupportedOperationException("Unimplemented method 'addData'");

    }

    public Object getRow(int i) {
        return i;
    }
    // à faire

    public void updateRow(int i, List<String> row2) {
        throw new UnsupportedOperationException("Unimplemented method 'updateRow'");
    }

    public void setName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

}
