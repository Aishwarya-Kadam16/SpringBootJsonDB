package com.SpringBoot.project.Service;

import com.SpringBoot.project.Entry.BatchEntry;

import io.jsondb.JsonDBTemplate;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BatchEntryService {

    @Autowired
    private JsonDBTemplate jsonDBTemplate;

    @PostConstruct
    public void initCollection() {
        if (!jsonDBTemplate.collectionExists(BatchEntry.class)) {
            jsonDBTemplate.createCollection(BatchEntry.class);
        }
    }

    public List<BatchEntry> getAll() {
        return jsonDBTemplate.findAll(BatchEntry.class);
    }

    public BatchEntry saveEntry(BatchEntry entry) {
        entry.setId(UUID.randomUUID().toString());
        jsonDBTemplate.insert(entry);
        return entry;
    }

    public BatchEntry findById(String id) {
        return jsonDBTemplate.findById(id, BatchEntry.class);
    }

    public BatchEntry updateEntryById(String id, BatchEntry updatedEntry) {
        BatchEntry existing = jsonDBTemplate.findById(id, BatchEntry.class);
        if (existing == null) {
            throw new RuntimeException("Record not found with id: " + id);
        }
        updatedEntry.setId(id);
        jsonDBTemplate.save(updatedEntry, BatchEntry.class);
        return updatedEntry;
    }

    public void deleteById(String id) {
        BatchEntry entry = jsonDBTemplate.findById(id, BatchEntry.class);
        if (entry == null) {
            throw new RuntimeException("Record not found with id: " + id);
        }
        jsonDBTemplate.remove(entry, BatchEntry.class);
    }
}