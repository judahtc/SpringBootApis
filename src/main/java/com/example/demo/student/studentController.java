package com.example.demo.student;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path="api/v1/student")

public class studentController {

    private studentService studentservice;

    @Autowired
    public studentController(studentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
	public List<student> getStudents()
        {
           return studentservice.getStudents();
        }
        
    @GetMapping(path="{studid}")
	public Optional<student> getStudentsbyID(@PathVariable("studid") Long studid)
        {
           return studentservice.getStudentsbyID(studid);
        }

        
    @PostMapping
    public void addNewStudent( @RequestBody student student){
        studentservice.addNewStudent(student);
    }    

    @DeleteMapping (path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long StudentId){
        studentservice.deleteStudByID(StudentId);
    }

    @PutMapping(path="{StudentId}")
    public void updateStudent(@PathVariable("StudentId") Long StudendId,@RequestBody student student){
        
        studentservice.UpdateStudent(StudendId, student);

    }

}

