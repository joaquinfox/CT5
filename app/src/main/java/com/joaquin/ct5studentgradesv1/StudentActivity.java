package com.joaquin.ct5studentgradesv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.joaquin.ct5studentgradesv1.model.Student;
import com.joaquin.ct5studentgradesv1.viewmodel.StudentListViewModel;

import java.util.List;

public class StudentActivity extends AppCompatActivity
        implements StudentDialogFragment.OnStudentEnteredListener {

    private StudentAdapter studentAdapter;
    private RecyclerView recyclerView;
    private int[] studentColors;
    private StudentListViewModel studentListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentListViewModel = new StudentListViewModel(getApplication());

        studentColors = getResources().getIntArray(R.array.studentColors);

        findViewById(R.id.add_subject_button).setOnClickListener(view -> addStudentClick());

        // Create 2 grid layout columns
        recyclerView = findViewById(R.id.student_recycler_view);
        RecyclerView.LayoutManager gridLayoutManager =
                new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Show the subjects
        updateUI(StudentListViewModel.getStudents());
    }

    private void updateUI(List<Student> studentList) {
        studentAdapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void onStudentEntered(String studentFirstName, String studentLastName, double studentGrade) {
        if (studentFirstName.length() > 0) {
            Student student = new Student(studentFirstName, studentLastName, studentGrade);
            studentListViewModel.addStudent(student);
            updateUI(studentListViewModel.getStudents());

            Toast.makeText(this, "Added " + studentFirstName, Toast.LENGTH_SHORT).show();
        }
    }

    private void addStudentClick() {
        StudentDialogFragment dialog = new StudentDialogFragment();
        dialog.show(getSupportFragmentManager(), "subjectDialog");
    }

    private class StudentHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Student student;
        private TextView studentTextView;

        public StudentHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.recycler_view_items, parent, false));
            itemView.setOnClickListener(this);
            studentTextView = itemView.findViewById(R.id.student_text_view);
        }

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Student student, int position) {
            student = student;
            studentTextView.setText(student.getFirstName()+" "+student.getLastName()+"\n"+
                   "Grade: "+ student.getGrade());

            studentTextView.setBackgroundColor(studentColors[0]);
        }

        @Override
        public void onClick(View view) {
            // Start QuestionActivity with the selected subject
            Intent intent = new Intent(String.valueOf(StudentActivity.this));

            startActivity(intent);
        }
    }

    private class StudentAdapter extends RecyclerView.Adapter<StudentHolder> {

        private final List<Student> studentList;

        public StudentAdapter(List<Student> students) {
            studentList = students;
        }

        @NonNull
        @Override
        public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new StudentHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(StudentHolder holder, int position) {
            holder.bind(studentList.get(position), position);
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    }
}