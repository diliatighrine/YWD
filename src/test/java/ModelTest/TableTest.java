package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Table;

public class TableTest {

    @Test
    public void testCreateTable() {
        Table table = new Table("my_table");
        assertNotNull(table);
        assertEquals("my_table", table.getName());
    }

    @Test
    public void testAddRow() {
        Table table = new Table("my_table");
        List<String> row = Arrays.asList("value1", "value2");
        table.addRow(row);
        assertEquals(1, table.getData().size());
        assertEquals(row, table.getData().get(0).getData());
    }

    @Test
    public void testGetRow() {
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        List<String> row2 = Arrays.asList("value3", "value4");
        table.addRow(row1);
        table.addRow(row2);
        assertEquals(row1, table.getData().get(0).getData()); // getData() pour obtenir les données de la ligne
        assertEquals(row2, table.getData().get(1).getData());
    }

    @Test
    public void testDeleteRow() {
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        List<String> row2 = Arrays.asList("value3", "value4");
        table.addRow(row1);
        table.addRow(row2);
        table.deleteRow(0);
        assertEquals(1, table.getData().size());
        assertEquals(row2, table.getData().get(0).getData());
    }

    @Test
    public void testGetData() {
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        table.addRow(row1);
        assertEquals(row1, table.getData().get(0).getData());
    }

    @Test
    public void testUpdateRow() {
        Table table = new Table("my_table");
        List<String> row1 = Arrays.asList("value1", "value2");
        List<String> row2 = Arrays.asList("value3", "value4");
        table.addRow(row1);
        table.updateRow(0, row2);
        assertEquals(row2, table.getData().get(0).getData());
    }
}
