package com.joaquin.ct5studentgradesv1.viewmodel;

import android.app.Application;

import com.joaquin.ct5studentgradesv1.model.Student;
import com.joaquin.ct5studentgradesv1.repo.GradeRepository;

import java.util.List;

public class StudentListViewModel {
    private GradeRepository gradeRepo;

    public StudentListViewModel(Application application) {
        gradeRepo = GradeRepository.getInstance(application.getApplicationContext());
    }

    public List<Student> getStudents() {
        return gradeRepo.getStudents();
    }

    public void addStudent(Student student) {
        gradeRepo.addStudent(student);
    }
}
