
package com.example.demo.model.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Table;

public class TableTest {

    @Test
    public void testCreateTable() {
        // Cas d'utilisation standard
        Table table = new Table("my_table");
        table.createTable();
        assertEquals("my_table", table.getName());
        assertTrue(table.getData().isEmpty());

        // Cas d'erreur
        table = new Table(null);
        assertThrows(IllegalArgumentException.class, table::createTable);
    }

    @Test
    public void testLoadData() throws Exception {
        // Cas d'utilisation standard
        Table table = new Table("my_table");
        MultipartFile file = new MockMultipartFile("data.parquet", "data.parquet", "application/octet-stream",
                new FileInputStream("path/to/file"));
        table.loadData(new MultipartFile[] { file });
        assertFalse(table.getData().isEmpty());
        assertEquals(100, table.getData().size()); // Taille du fichier exemple

        // Cas d'erreur
        table = new Table(null);
        assertThrows(IllegalArgumentException.class, () -> table.loadData(new MultipartFile[] { file }));

        file = new MockMultipartFile("data.txt", "data.txt", "text/plain", new FileInputStream("path/to/invalid/file"));
        assertThrows(IOException.class, () -> table.loadData(new MultipartFile[] { file }));
    }

    @Test
    public void testAddRow() {
        // Cas d'utilisation standard
        Table table = new Table("my_table");
        List<String> row = Arrays.asList("value1", "value2");
        table.addRow(row);
        assertEquals(1, table.getData().size());
        assertEquals(row, table.getData().get(0));

        // Cas d'erreur
        table = new Table(null);
        assertThrows(IllegalArgumentException.class, () -> table.addRow(row));

        row = Arrays.asList(null, "value2");
        assertThrows(IllegalArgumentException.class, () -> table.addRow(row));
    }

    @Test
    public void testGetRow() {
        // Cas d'utilisation standard
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        List<String> row2 = Arrays.asList("value3", "value4");
        table.addRow(row1);
        table.addRow(row2);
        assertEquals(row1, table.getRow(0));
        assertEquals(row2, table.getRow(1));

        // Cas d'erreur
        table = new Table(null);
        assertThrows(IllegalArgumentException.class, () -> table.getRow(0));

        assertThrows(IndexOutOfBoundsException.class, () -> table.getRow(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> table.getRow(2));
    }

    // Tester d'autres fonctions et méthodes de la classe Table...

    @Test
    public void testDeleteRow() {
        // Cas d'utilisation standard
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        List<String> row2 = Arrays.asList("value3", "value4");
        table.addRow(row1);
        table.addRow(row2);
        table.deleteRow(0);
        assertEquals(1, table.getData().size());
        assertEquals(row2, table.getData().get(0));

        // Cas d'erreur
        table = new Table(null);
        assertThrows(IllegalArgumentException.class, () -> table.deleteRow(0));

        assertThrows(IndexOutOfBoundsException.class, () -> table.deleteRow(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> table.deleteRow(2));
    }

@Test
    public void testUpdateRow() {
        // Cas d'utilisation standard
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        List<String> row2 = Arrays.asList("value3", "value4");
        table.addRow(row1);
        table.updateRow(0, row2);
        assertEquals(row2, table.getData().get(0));

        

//1serveurs par machine pour 3 machines