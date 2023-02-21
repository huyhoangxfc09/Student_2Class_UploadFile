package com.example.student.formatter;

import com.example.student.model.Classroom;
import com.example.student.service.Impl.ClassroomServiceImpl;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ClassroomFormatter implements Formatter<Classroom> {
    private final ClassroomServiceImpl classroomService;
    public ClassroomFormatter(ClassroomServiceImpl classroomService){
        this.classroomService = classroomService;
    }
    @Override
    public Classroom parse(String text, Locale locale) throws ParseException {
        return classroomService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Classroom object, Locale locale) {
        return null;
    }
}
