// DataController.java
package com.example.demo.controller;

import com.example.demo.model.TableRow;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/{tableName}")
    public String loadData(@PathVariable String tableName, @RequestParam("file") MultipartFile[] files) {
        return dataService.load(tableName, files);
    }
}
