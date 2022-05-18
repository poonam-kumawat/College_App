package com.example.college;


public class TeacherData {
    private String name,Subject,post,image,Key;

    public TeacherData() {
    }

    public TeacherData(String name, String subject, String post, String image, String key) {
        this.name = name;
        this.Subject = subject;
        this.post = post;
        this.image = image;
        this.Key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
