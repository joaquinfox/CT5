package com.joaquin.ct5studentgradesv1.repo;

import android.content.Context;

import com.joaquin.ct5studentgradesv1.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository {
    private static GradeRepository gradeRepo;
    private final List<Student> studentList;



    // Instantiate a single instance???
    public static GradeRepository getInstance(Context context) {
        if (gradeRepo == null) {
            gradeRepo = new GradeRepository(context);
        }
        return gradeRepo;
    }
    private GradeRepository(Context context){
        studentList = new ArrayList<>();
        addStarterData();
    }

    private void addStarterData() {
        // Add some students
        Student student = new Student("Chuck","Finkleton", 60.20);
        student.setId(1);
        addStudent(student);
    }

    private void addStudent(Student student) {
        studentList.add(student);
    }


}
