package com.glab.glab30791.controller;

import com.glab.glab30791.model.Tutorial;
import com.glab.glab30791.services.TutorialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TutorialController {

    @Autowired
    private TutorialServices tutorialServices;

    @GetMapping("/tutorials")
    public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
        return tutorialServices.getAllTutorials();
    }

    @GetMapping("/tutorials/{id}")
    public Optional<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return tutorialServices.getTutorialById(id);
    }

    //  Add new tutorial
    @PostMapping("/tutorials")
    public void createTutorial(@RequestBody Tutorial tutorial) {
        tutorialServices.addTutorial(tutorial);
    }

    //  UPDATE a tutorial
    @PutMapping("/tutorials/{id}")
    public void updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial newTutorial) {
        Optional<Tutorial> tutorialData = tutorialServices.getTutorialById(id);
        if (tutorialData.isPresent()) {
            Tutorial updateTutorial = tutorialData.get();
            updateTutorial.setTitle(newTutorial.getTitle());
            updateTutorial.setDescription(newTutorial.getDescription());
            updateTutorial.setPublished(newTutorial.isPublished());
            tutorialServices.addTutorial(updateTutorial);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public void deleteTutorial(@PathVariable("id") long id) {
        tutorialServices.deleteTutorial(id);
    }

    @DeleteMapping("/tutorials")
    public void deleteAllTutorials() {
        tutorialServices.deleteAllTutorials();
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        return tutorialServices.findByPublished();
    }
}
