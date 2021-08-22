package com.example.myprojectproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leave")
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leave_id;
    @Column
    private Date leaveStart_date;
    @Column
    private Date leaveEnd_date;
    @Column
    private String leaveStatus;
    @Column
    private String leaveType;
    @ManyToOne
    private Employee employee;
}
