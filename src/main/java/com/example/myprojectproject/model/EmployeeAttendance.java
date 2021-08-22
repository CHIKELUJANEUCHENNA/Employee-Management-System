package com.example.myprojectproject.model;

import com.example.myprojectproject.enums.AttendanceEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_attendance")
public class EmployeeAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendance_id;
    @Column
    @DateTimeFormat(pattern = "yy:mm:dd")
    private LocalDate date;
    @Column
    @DateTimeFormat(pattern = "HH:ss:mm")
    private LocalTime time;
    @Column
    @Enumerated(EnumType.STRING)
    private AttendanceEnums attendanceEnums;
    @ManyToOne
    private Employee employee;


}
