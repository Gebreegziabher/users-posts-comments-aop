package edu.ggg.waarestfullab4.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String principle;
    private String operation;
    private String exception;

    public Log(LocalDate date, LocalTime startTime, LocalTime endTime, String principle, String operation, String exception){
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.principle = principle;
        this.operation = operation;
        this.exception = exception;
    }
}
