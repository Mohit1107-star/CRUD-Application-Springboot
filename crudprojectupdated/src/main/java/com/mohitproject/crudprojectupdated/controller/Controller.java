package com.mohitproject.crudprojectupdated.controller;

import com.mohitproject.crudprojectupdated.model.Student;
import com.mohitproject.crudprojectupdated.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    StudentService studentService;

    // CREATE
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Successfully added", HttpStatus.OK);
    }

    // READ
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    // UPDATE
    @RequestMapping(value = "/students/put", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> edit(@RequestBody Student student){
        studentService.editStudent(student);
        return new ResponseEntity<>("Successfully edited", HttpStatus.OK);
    }

    // DELETE
    @RequestMapping(value = "/students/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam int idNo){
        studentService.deleteStudent(idNo);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

}
