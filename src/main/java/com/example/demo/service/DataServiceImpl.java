package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.api.ReadSupport;
import org.apache.parquet.hadoop.example.GroupReadSupport;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;
import org.apache.parquet.schema.Type;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.simple.SimpleGroup;

@Service
public class DataServiceImpl implements DataService {

    // Une liste de listes pour stocker les tables en mémoire
    private List<List<Object>> tables = new ArrayList<>();

    @Override
    public String load(String tableName, MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {

                // Lire et insérer les lignes dans la table
                List<List<Object>> data = readParquetFile(file.getInputStream());
                tables.addAll(data);
            }

            return "Data loaded successfully into table: " + tableName;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to load data into table: " + tableName;
        }
    }

    // Méthode pour lire les données à partir du fichier Parquet
    private List<List<Object>> readParquetFile(InputStream inputStream) {
        try {
            // Configuration Hadoop
            Configuration configuration = new Configuration();

            // Créer un lecteur Parquet
            ParquetReader<Group> parquetReader = ParquetReader.builder(new GroupReadSupport(), new Path("parquet_file_path"))
                    .withConf(configuration)
                    .build();

            // Lire et retourner les données sous forme de liste de listes
            List<List<Object>> data = new ArrayList<>();
            Group record;
            while ((record = parquetReader.read()) != null) {
                data.add(convertGroupToList(record));
            }
            parquetReader.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Méthode pour convertir un enregistrement Group en une liste d'objets
    private List<Object> convertGroupToList(Group group) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < group.getType().getFieldCount(); i++) {
            list.add(group.getValueToString(i, 0));
        }
        return list;
    }
}
