package enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Problem {
    private String name;
    private String details;
    private Severity severity;

    /**
     * Default severity
     * @param name
     */
    public Problem(String name) {
        this(name, null, Severity.MINOR);
    }

    public void resolve(){
        System.out.println("Resolving problem '" + name + "'...." + severity.getTimeFrame());
    }
}
