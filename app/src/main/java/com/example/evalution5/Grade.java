package com.example.evalution5;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "grades")
public class Grade {
    @PrimaryKey(autoGenerate = true)
    public int id; // Changed from cid to id for clarity
    public String courseName;
    public double courseNumber;
    public String category; // Changed from letterGrade to category

    public Grade() {
        // Empty constructor for Room
    }

    // Updated constructor to match the fields used in AddCourseFragment


    public Grade(String courseName, double courseNumber, String category) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.category = category;
    }

    public double getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(double courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}