package com.example.demo.test.controllertest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import com.example.demo.service.DataService;
import com.example.demo.service.DataServiceImpl;

public class DataServiceImplTest {

    private DataService dataService;

    @BeforeEach
    public void setUp() {
        dataService = new DataServiceImpl();
    }

    @Test
    public void testLoad() throws IOException {
        // Créer un fichier parquet de test
        String parquetData = "test parquet data";
        MockMultipartFile file = new MockMultipartFile("file", "test.parquet", "application/octet-stream",
                parquetData.getBytes());

        // Appeler la méthode load
        String result = dataService.load("TestTable", new MockMultipartFile[] { file });

        // Vérifier le résultat
        assertEquals("Data loaded successfully into table: TestTable", result);
    }
}
