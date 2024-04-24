package controllertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Table;
import com.example.demo.service.TableService;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc // tester les contrôleurs sans nécessiter le démarrage complet du serveur.
                      // Il permet de tester le comportement des contrôleurs
@Transactional
@Rollback(true)
public class TableControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TableService tableService;

    @BeforeEach
    public void setUp() {
        // Création de données de test
        Table table = new Table("sonia");
        table.setName("TestTable");
        tableService.createTable(table);
    }

    @Test
    public void testCreateTable() throws Exception {
        String requestBody = "{\"name\":\"TestTable\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tables") // envoyer une requête POST à l'endpoint
                                                                   // "/api/tables".
                .contentType(MediaType.APPLICATION_JSON) // Il définit le type de contenu de la requête comme étant JSON
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk()) // vérifier que la réponse de l'API a un statut HTTP
                                                                  // 200 (OK)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("TestTable"));
    } // vérifie que la réponse JSON contient un champ nommé "name" avec la valeur
      // "TestTable"

    @Test
    public void testGetAllTables() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tables")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

}
