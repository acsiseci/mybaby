package com.mybaby.app.controller;

import com.mybaby.app.domain.Story;
import com.mybaby.app.security.CurrentUser;
import com.mybaby.app.security.UserPrincipal;
import com.mybaby.app.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/story")
public class StoryController {

    @Autowired
    private StoryService storyService;


    @GetMapping("/mobile")
    public List<Story> mobileFindAllStory(@CurrentUser UserPrincipal currentUser) {
        return storyService.getAllMobileStories();
    }


    @GetMapping
    public List<Story> findAllStory() {
        return storyService.getAllStories();
    }

    @GetMapping("/{storyId}")
    private Story getStory(@PathVariable("storyId") Long storyId)
    {
        return storyService.getStoryById(storyId);
    }

    @PostMapping
    public void saveStory(@RequestBody Story story) {
        storyService.saveStory(story);
    }

    @DeleteMapping("/{storyId}")
    private void deleteBook(@PathVariable("storyId") Long storyId)
    {
        storyService.deleteStory(storyId);
    }

    @PutMapping
    public void updateStory(@RequestBody Story story){
        storyService.saveStory(story);
    }
}

