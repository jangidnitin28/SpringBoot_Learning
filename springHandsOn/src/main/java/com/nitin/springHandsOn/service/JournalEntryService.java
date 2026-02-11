package com.nitin.springHandsOn.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.nitin.springHandsOn.repository.JournalEntryRepo;
import com.nitin.springHandsOn.entity.JournalEntry;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.List;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getEntryById(String id) {
        return journalEntryRepo.findById(id);
    }

    public void deleteEntryById(String id) {
        journalEntryRepo.deleteById(id);
    }
}
