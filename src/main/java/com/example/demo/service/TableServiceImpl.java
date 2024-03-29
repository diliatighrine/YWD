// TableServiceImpl.java
package com.example.demo.service;

import com.example.demo.model.Table;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    private final List<Table> tables = new ArrayList<>();

    @Override
    public Table createTable(Table table) {

        table.setId(generateUniqueId());
        tables.add(table);
        return table;
    }

    @Override
    public List<Table> getAllTables() {
        return tables;
    }


    private long generateUniqueId() {

        return System.currentTimeMillis();
    }
}
