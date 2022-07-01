package com.example.demo.student;

import java.nio.channels.IllegalSelectorException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class studentService
 {  

    private studentRepository studentrepository;

    @Autowired
    public studentService(studentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }
    public List<student> getStudents()
        {
          return studentrepository.findAll();
        }
        
    public void addNewStudent(student student) {
       studentrepository.save(student);

    }
    public void deleteStudByID(Long studentId) {
       boolean exist= studentrepository.existsById(studentId);

       if (!exist){
           throw new IllegalSelectorException();
       }
       studentrepository.deleteById(studentId);
    }
    @Transactional
    public ResponseEntity<student> UpdateStudent(Long StudendId, student student) {
        
        student updatestudent = studentrepository.findById(StudendId).orElseThrow(()->new IllegalStateException("Student Does not exist")); 
      
        updatestudent.setName(student.getName());
        updatestudent.setEmail(student.getEmail());

        studentrepository.save(student);

        return ResponseEntity.ok(updatestudent);

    }
    public Optional<student> getStudentsbyID(Long studid) {
        
        return studentrepository.findById(studid);
        
    }

}