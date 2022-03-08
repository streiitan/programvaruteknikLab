package broker;

import domain.Result;
import domain.records.ResultRecord;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A broker class for Result
 * @author jenniferstreit
 */
public class ResultBroker {
    
    /**
     * Gets all the results in the database
     * @return a list of all results in the database
     */
    public List<Result> findAll() {
        return ResultRecord.findAll().stream()
                .map(rec -> new Result((ResultRecord)rec))
                .collect(Collectors.toList());
    }
    
    /**
     * The method gets a result from the database based on the id
     * @param id, the id of a result in the database
     * @return a result object
     */
    public Result findById(Long id) {
        return new Result(ResultRecord.findById(id));
    }
    
     /**
     * Method for creating a new result
     * @return a new result object
     */
    public Result create() {
        return new Result(new ResultRecord());
    }
    
    /**
     * Saves the changes for a specific result
     * @param r, the selected result for saving changes
     */
    public void save(Result r) {
        r.getRecord().saveIt();
    }
}
