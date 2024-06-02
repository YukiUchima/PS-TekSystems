package com.glab.glab30791.services;

import com.glab.glab30791.model.Tutorial;
import com.glab.glab30791.repository.TutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServices {

    @Autowired
    private TutorialRepo tutorialRepo;

    public List<Tutorial> getAllTutorials(){
        return new ArrayList<>(tutorialRepo.findAll());
    }

//    Optional checks if it is found or not... sometimes the id may not exist
    public Optional<Tutorial> getTutorialById(long id) {
        System.out.println(tutorialRepo.findById(id));
        return tutorialRepo.findById(id);
    }

    public void addTutorial(Tutorial newTutorial) {
        tutorialRepo.save(newTutorial);
    }

    public void updateTutorial(long id, Tutorial newTutorial){
        Optional<Tutorial> tutorialData = tutorialRepo.findById(id);
        if(tutorialData.isPresent()){
            Tutorial oldTutorial = tutorialData.get();
            oldTutorial.setTitle(newTutorial.getTitle());
            oldTutorial.setDescription(newTutorial.getDescription());
            oldTutorial.setPublished(newTutorial.isPublished());
            tutorialRepo.save(oldTutorial);
        }
    }

    public void deleteTutorial(long id){
        tutorialRepo.deleteById(id);
    }

    public void deleteAllTutorials(){
        tutorialRepo.deleteAll();
    }

    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutorialRepo.findByPublished(true);
            if(tutorials.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
