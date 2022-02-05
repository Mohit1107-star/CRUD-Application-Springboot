package com.mohitproject.crudprojectupdated.service;

import com.mohitproject.crudprojectupdated.model.Student;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentService {
    private static List<Student> studentRepo = new ArrayList<>();

    static {
        Student student1 = new Student();
        student1.setId(7);
        student1.setName("Mohit");
        student1.setStd("10");
        student1.setPercentage("100");
        studentRepo.add(student1);

        Student student2 = new Student();
        student2.setId(10);
        student2.setName("Yash");
        student2.setStd("10");
        student2.setPercentage("99");
        studentRepo.add(student2);
    }


    public List<Student> getAll() {
        return studentRepo;
    }

    public void addStudent(Student student) {
        Student tempstud = new Student();
        tempstud.setId(student.getId());
        tempstud.setStd(student.getStd());
        tempstud.setPercentage(student.getPercentage());
        tempstud.setName(student.getName());
        studentRepo.add(tempstud);
    }

    public void editStudent(Student student) {
        for (Student value : studentRepo) {
            if (student.getId() == value.getId()) {
                value.setName(student.getName());
                value.setStd(student.getStd());
                value.setPercentage(student.getPercentage());
                break;
            }
        }
    }

    public void deleteStudent(int idNo) {
        for(Student value: studentRepo){
            if(idNo == value.getId()){
                studentRepo.remove(value);
                break;
            }
        }
    }
}
