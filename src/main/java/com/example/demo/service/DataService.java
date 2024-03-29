// DataService.java
package com.example.demo.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DataService {
    String load(String tableName, MultipartFile[] files);
}
