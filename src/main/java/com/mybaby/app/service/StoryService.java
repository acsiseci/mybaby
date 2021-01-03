package com.mybaby.app.service;

import com.mybaby.app.domain.Story;
import com.mybaby.app.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoryService {

    @Autowired
    StoryRepository storyRepository;

    public List<Story> getAllStories()
    {
        return storyRepository.findAll();
    }
    public List<Story> getAllMobileStories()
    {
        return storyRepository.mobileFindAll();
    }

    public Story getStoryById(Long id)
    {
        return storyRepository.findById(id).get();
    }

    public void deleteStory(Long id)
    {
        storyRepository.deleteById(id);
    }

    public void saveStory(Story story)
    {
        story.setCreatedBy("Admin");
        story.setCreatedDate(new Date());
        story.setReadingTime((story.getContent().length()/ 228) + 1);
        storyRepository.save(story);
    }



}

