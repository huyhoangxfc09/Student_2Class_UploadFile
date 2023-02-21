package com.example.student.model;

import org.springframework.web.multipart.MultipartFile;

public class Student {
    private int id;
    private String imagePath;
    private MultipartFile image;
    private String name;
    private int age;
    private String address;
    private Classroom classroom;

    public Student() {
    }

    public Student(int id, String imagePath, MultipartFile image, String name, int age, String address, Classroom classroom) {
        this.id = id;
        this.imagePath = imagePath;
        this.image = image;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classroom = classroom;
    }

    public Student(int id, String imagePath, String name, int age, String address, Classroom classroom) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classroom = classroom;
    }

    public Student(int id, MultipartFile image, String name, int age, String address, Classroom classroom) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
