package com.SpringBoot.project.Controller;

import com.SpringBoot.project.Entry.BatchEntry;
import com.SpringBoot.project.Service.BatchEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchEntryController {

    @Autowired
    private BatchEntryService batchEntryService;

    @GetMapping
    public ResponseEntity<List<BatchEntry>> getAll() {
        return new ResponseEntity<>(batchEntryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BatchEntry> create(@RequestBody BatchEntry entry) {
        return new ResponseEntity<>(batchEntryService.saveEntry(entry), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchEntry> update(@PathVariable String id, @RequestBody BatchEntry entry) {
        return new ResponseEntity<>(batchEntryService.updateEntryById(id, entry), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        batchEntryService.deleteById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}