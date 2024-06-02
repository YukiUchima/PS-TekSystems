package com.glab.lab30961.controller;

import com.glab.lab30961.model.Student;
import com.glab.lab30961.model.StudentView;

public class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

}
