package com.example.punchclock.service;

import com.example.punchclock.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    EntityRepository entityRepository;

    @Autowired
    public EntryService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<Entry> findAll() {
        return (List<Entry>) entityRepository.findAll();
    }

    public Entry createEntry(Entry entry){
        entityRepository.save(entry);
        return entry;
    }

    public Entry update(Long id, Entry entry) {
        Entry entryToUpdate = entityRepository.findById(id).get();
        entryToUpdate.setCheckIn(entry.getCheckIn());
        entryToUpdate.setCheckOut(entry.getCheckOut());
        entityRepository.save(entryToUpdate);
        return entryToUpdate;
    }

    public void delete(long id) {
        entityRepository.deleteById(id);
    }
}
