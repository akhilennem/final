package com.attendance.login.RestController.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "asd")

public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    public String para;
    private String phone;
    private LocalDate date=LocalDate.now();
    public String time;

    public String month=LocalDate.now().format(DateTimeFormatter.ofPattern("MM-YYYY"));
//    public String time;
}
