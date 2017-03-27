package BEANS.InfoObjects;

import java.time.LocalDate;

/**
 * 
 * @author SPOO
 */
public interface CustomerInsurable extends Insurable {
    
    public String getId();
    public LocalDate getBirthDate();
    
}
