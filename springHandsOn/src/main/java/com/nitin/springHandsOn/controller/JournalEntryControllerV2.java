package com.nitin.springHandsOn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.nitin.springHandsOn.entity.JournalEntry;
import com.nitin.springHandsOn.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable String myId) {
        return journalEntryService.getEntryById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable String myId) {
        journalEntryService.deleteEntryById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById(@PathVariable String myId, @RequestBody JournalEntry entry) {
       JournalEntry old = journalEntryService.getEntryById(myId).orElse(null);
       if (old != null) {
           old.setTitle(entry.getTitle());
           old.setContent(entry.getContent());
           journalEntryService.saveEntry(old);
           return old;
       }
       return null;
    }
}