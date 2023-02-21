package com.example.student.service.Impl;
import com.example.student.model.Classroom;
import com.example.student.model.Student;
import com.example.student.service.ICrudService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements ICrudService<Student> {
    @Value("${file-upload}")
    private String fileUpload;
    static List<Student> studentList;
    static ICrudService<Classroom> classroomICrudService;
    public StudentServiceImpl(ICrudService<Classroom> classroomICrudService){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"hoang.jpg","hoang",28,"Thai Binh",classroomICrudService.findAll().get(0)));
        studentList.add(new Student(2,"lien.jpg","lien",34,"Nam Dinh ",classroomICrudService.findAll().get(1)));
        studentList.add(new Student(3,"vu.jpg","vu",20,"Ha Noi",classroomICrudService.findAll().get(2)));
        this.classroomICrudService = classroomICrudService;
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        student.setImagePath(getFileName(student));
        studentList.add(student);
    }

    @Override
    public void update(int id, Student student) {
        Student studentUpdate = findById(id);
        int index = studentList.indexOf(studentUpdate);
        student.setImagePath(getFileName(student));
        studentList.set(index,student);
    }

    @Override
    public void delete(int id) {
        Student student = findById(id);
        if(student!= null){
            studentList.remove(student);
        }
    }

    @Override
    public Student findById(int id) {
        Student student =null;
        for (Student e : studentList) {
            if(e.getId()==id){
                student = e;
                break;
            }
        }return student;
    }
    public String getFileName(Student student) {
        MultipartFile image = student.getImage();
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileName;
    }
}
