package com.modori.smartclassna.model;

public class User {
    public static String name;
    public static String school;
    public static String email;
    public static String area;
    public static String subject;
    public static String detailsubject;
    public static String permission;
    public static String project;

    public User() {
    }

    public User(String name, String school, String email, String area, String subject, String detailsubject, String permission, String project) {
        this.name = name;
        this.school = school;
        this.email = email;
        this.area = area;
        this.subject = subject;
        this.detailsubject = detailsubject;
        this.permission = permission;
        this.project = project;
    }
}
