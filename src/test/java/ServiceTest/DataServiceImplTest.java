package ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;

import com.example.demo.service.DataService;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration"
})

class DataServiceImplTest {

    @Autowired
    private DataService dataService;

    @Test
    void load() throws IOException {
        MockMultipartFile file = new MockMultipartFile("file", "test.parquet", "text/plain", "Test Data".getBytes());

        String result = dataService.load("test_table", new MockMultipartFile[] { file });

        assertEquals("Data loaded successfully into table: test_table", result);
    }
}
