package edu.ggg.waarestfullab4.services;

import edu.ggg.waarestfullab4.domain.Log;
import edu.ggg.waarestfullab4.domain.dto.CommentDto;

import java.time.LocalDate;
import java.util.List;

public interface LogService {
    List<Log> findAll();
    Log findById(int id);
    List<Log> findByPrinciple(String principle);
    List<Log> findByDate(LocalDate date);
    List<Log> findByOperation(String operation);
}
