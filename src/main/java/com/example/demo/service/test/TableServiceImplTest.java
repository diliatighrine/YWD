package com.example.demo.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Table;
import com.example.demo.service.TableService;
import com.example.demo.service.TableServiceImpl;

public class TableServiceImplTest {

    private TableService tableService;

    @BeforeEach
    public void setUp() {
        tableService = new TableServiceImpl();
    }

    @Test
    public void testCreateTable() {
        Table table = new Table("TestTable");
        Table createdTable = tableService.createTable(table);

        assertNotNull(createdTable.getId());
        assertEquals("TestTable", createdTable.getName());
    }

    @Test
    public void testGetAllTables() {
        Table table1 = new Table("Table1");
        Table table2 = new Table("Table2");
        tableService.createTable(table1);
        tableService.createTable(table2);

        List<Table> tables = tableService.getAllTables();

        assertEquals(2, tables.size());
        assertEquals("Table1", tables.get(0).getName());
        assertEquals("Table2", tables.get(1).getName());
    }
}
