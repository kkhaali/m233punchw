package com.example.punchclock.controller;

import com.example.punchclock.model.Entry;
import com.example.punchclock.model.Tag;
import com.example.punchclock.service.EntryService;
import com.example.punchclock.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public List<Tag> get() {
        return tagService.findAll();
    }

    @PostMapping("/tags")
    public ResponseEntity create(@RequestBody Tag tag) {
        if(tag.getTitle().length() > 0) {
            tagService.createTag(tag);
            return new ResponseEntity(tag, HttpStatus.OK);
        } else {
            return new ResponseEntity("Title unchanged!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity update(@RequestBody Tag tag, @PathVariable Long id) {
        if(tag.getTitle().length() > 0) {
            tagService.update(id, tag);
            tag.setId(id);
            return new ResponseEntity(tag, HttpStatus.OK);
        } else {
            return new ResponseEntity("Title unchanged!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/tags/{id}")
    public void delete(@PathVariable Long id) {
        tagService.delete(id);
    }
}
