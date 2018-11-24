package system;

/**
 * Vienas transakcijos irasas.
 */
public class Account {
    private String description ;
    private double sum;

    /**
     * Transakcijos ivedimas.
     * @param description aprasymas
     * @param sum suma
     */

    public Account(String description, double sum) {
        this.description = description;
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public double getSum() {
        return sum;
    }


    @Override
    public String toString() {
        return String.format("%7.2f", getSum()) + " EUR - " + getDescription();
    }
}
