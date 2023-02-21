package com.example.student.controller;

import com.example.student.model.Classroom;
import com.example.student.model.Student;
import com.example.student.service.ICrudService;
import com.example.student.service.Impl.ClassroomServiceImpl;
import com.example.student.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private  ICrudService<Classroom> classroomICrudService;
    @Autowired
    private  ICrudService<Student> studentICrudService;
    @GetMapping
    private String listStudent(Model model){
        List<Student> student = studentICrudService.findAll();
        model.addAttribute("student",student);
        return "student/list";
    }
    @GetMapping("/create")
    private ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("classroom",classroomICrudService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    private String createStudent(@ModelAttribute Student student, RedirectAttributes attributes){
        studentICrudService.save(student);
        attributes.addFlashAttribute("message","Tạo mới thành công");
        return "redirect:/students";
    }
    @GetMapping("/update/{id}")
    private ModelAndView updateForm(@PathVariable("id")int id){
        ModelAndView modelAndView = new ModelAndView("student/update");
        modelAndView.addObject("student",studentICrudService.findById(id));
        modelAndView.addObject("classroom",classroomICrudService.findAll());
        return modelAndView;
    }
    @PostMapping("/update/{id}")
    private String updateStudent(@PathVariable("id")int id,@ModelAttribute Student student, RedirectAttributes attributes){
        studentICrudService.update(id,student);
        attributes.addFlashAttribute("message","Update thành công");
        return "redirect:/students";
    }
    @GetMapping("/delete/{id}")
    private String deleteClassroom(@PathVariable("id")int id){
        studentICrudService.delete(id);
        return "redirect:/students";
    }
}
