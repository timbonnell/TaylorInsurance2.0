package BEANS.InfoObjects;

import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public interface CustomerInsurable extends Insurable {

    public LocalDate getBirthDate();

    public String getId();

}
