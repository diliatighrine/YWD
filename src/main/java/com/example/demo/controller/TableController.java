// TableController.java
package com.example.demo.controller;

import com.example.demo.model.Table;
import com.example.demo.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping
    public Table createTable(@RequestBody Table table) {
        return tableService.createTable(table);
    }

    @GetMapping
    public List<Table> getAllTables() {
        return tableService.getAllTables();
    }

    
}
