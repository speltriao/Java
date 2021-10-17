package com.example.demo;

import javax.persistence.*;

@Entity (name="student") //This class is also an Entity, mapped to a table (bellow) on the DataBase
@Table (//Set table parameters
        name = "student", //table name
        uniqueConstraints = { //Set a custom constraint name for email (which is an unique field)
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
public class Student {
    @Id //Mark the variable bellow (id) as the PRIMARY KEY for this entity
    @SequenceGenerator( //Create an ID sequence generator, so that the first student has ID 1, the second has ID 2 and so on (automatically)
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1 //How much the sequence will increase
    )
    @GeneratedValue( //The generated value will be...
            strategy =  GenerationType.SEQUENCE,
            generator = "student_sequence" //Name of sequence name
    )
    @Column(
            name = "ID",
            updatable = false  //The ID column cannot be changed
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false, //Cannot be null
            columnDefinition = "TEXT" //Type of variable
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false, //Cannot be null
            columnDefinition = "TEXT" //Type of variable
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false, //Cannot be null
            columnDefinition = "TEXT" //Type of variable
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
