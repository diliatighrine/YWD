// TableService.java
package com.example.demo.service;

import com.example.demo.model.Table;

import java.util.List;

public interface TableService {
    Table createTable(Table table);
    List<Table> getAllTables();
}
