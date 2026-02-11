package com.nitin.springHandsOn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nitin.springHandsOn.entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String>{
    
}
    