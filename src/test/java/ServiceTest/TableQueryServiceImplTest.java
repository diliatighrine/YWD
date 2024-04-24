package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TableQueryServiceImplTest {

    @Autowired
    private TableQueryService tableQueryService;

    @Test
    void executeQuery() {
        String query = "SELECT * FROM test_table WHERE column1 = 'value'";
        assertNotNull(tableQueryService.executeQuery(query));
    }
}
