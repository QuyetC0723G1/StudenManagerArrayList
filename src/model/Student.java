package model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private String gender;
    private double[] score = new double[3];
    private static int toUpId = 1;

    public Student(String name, String gender, double[] score) {
        this.id = toUpId;
        this.name = name;
        this.gender = gender;
        this.score = score;
        toUpId++;
    }

    public Student() {
        this.id = toUpId;
        toUpId++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public int getToUpId() {
        return toUpId;
    }

    public void setToUpId(int toUpId) {
        this.toUpId = toUpId;
    }
    public double getAvg(){
        double sum = 0;
        for (int i = 0; i < getScore().length; i++) {
            sum += getScore()[i];
        }return  sum/3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name = " + name  +
                ", gender = " + gender  +
                ", score = " + Arrays.toString(score) +
                '}';
    }
}
