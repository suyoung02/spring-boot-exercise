package com.example.exercise1.Controller;

import com.example.exercise1.Model.LogEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(value = "/api/logs")
public class LoggerController {

    @GetMapping("")
    public ResponseEntity<List<LogEntry>> getLogs(@RequestParam(value = "level") String level, @RequestParam(value = "content") String message) {
        List<LogEntry> list = new ArrayList<>();
        String folderPath = "C:\\Users\\vinhh\\Source_C\\logs";

        try {
            Files.walk(Paths.get(folderPath))
                    .filter(Files::isRegularFile)
                    .forEach(filePath -> readLogFile(filePath, list, level, message));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return ResponseEntity.ok(list);
    }

    private void readLogFile(Path filePath, List<LogEntry> list, String level, String message) {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String strLine;
            while ((strLine = reader.readLine()) != null) {
                String[] words = strLine.split("\\s", 5);
                LogEntry entry = new LogEntry(words[0], words[1], words[4], words[3]);
                if(level.equals(entry.getLevel())){
                    list.add(entry);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath + "\n" + e.getMessage());
        }
    }
}
