package org.example.PolymorphismChallenge;

import java.time.LocalDate;

public class Course {
    int id;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    int capacity;
    double price;
    int numberOfStudentsEnrolled;

    public Course(int id, String name, LocalDate startDate, LocalDate endDate, int capacity, double price, int numberOfStudentsEnrolled) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.capacity = capacity;
        this.price = price;
        this.numberOfStudentsEnrolled = numberOfStudentsEnrolled;
    }

    @Override
    public String toString() {
        return String.format("%s course has %d places remaining", name, NumPlacesRemaining());
    }

    public int NumPlacesRemaining() {
        return (capacity-numberOfStudentsEnrolled);
    }
}
