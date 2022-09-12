package com.example.punchclock.controller;

import com.example.punchclock.model.Entry;
import com.example.punchclock.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping("/entries")
    public List<Entry> get() {
        return entryService.findAll();
    }

    @PostMapping("/entry")
    public Entry create(@RequestBody Entry entry) {
        entryService.createEntry(entry);
        return entry;
    }

    @PutMapping("/entry/{id}")
    public Entry update(@RequestBody Entry entry, @PathVariable Long id) {
        return entryService.update(id, entry);
    }

    @DeleteMapping("/entry/{id}")
    public void delete(@PathVariable Long id) {
        entryService.delete(id);
    }
}
