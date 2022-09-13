package com.example.punchclock.service;

import com.example.punchclock.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    public Tag createTag(Tag tag){
        tagRepository.save(tag);
        return tag;
    }

    public Tag update(Long id, Tag tag) {
        Tag tagToUpdate = tagRepository.findById(id).get();
        tagToUpdate.setTitle(tag.getTitle());
        tagRepository.save(tagToUpdate);
        return tagToUpdate;
    }

    public void delete(long id) {
        tagRepository.deleteById(id);
    }
}
