package edu.ggg.waarestfullab4.repo;

import edu.ggg.waarestfullab4.domain.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepo extends CrudRepository<Log, Integer> {
}
