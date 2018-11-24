package file;
import system.Account;
import system.Transaction;
import java.io.*;

/**
 * Pajamu ir islaidu irasymas/skaitymas i/is tekstinio failo.
 */

class Storage {
    private static final String FILENAME = "money.txt";

    /**
     * Tekstinio failo skaitymas
     * @return transakcijos, jeigu transakciju nera - tuscias failas
     */
    static Transaction load() {
        Transaction transaction = new Transaction();
        try {
            FileReader reader = new FileReader(FILENAME);
            BufferedReader buffer = new BufferedReader(reader);
            while (true) {
                String description = buffer.readLine();
                if (description == null) break;
                double sum = Double.parseDouble(buffer.readLine());
                transaction.add(new Account(description, sum));
            }
            return transaction;
        }
        catch (IOException e) {
            return transaction;
        }
    }


    static boolean save(Transaction transaction){
        try {
            FileWriter writer = new FileWriter(FILENAME);
            for (Account account : transaction.getAccounts()) {
                writer.write(account.getDescription() +  "\n" + account.getSum() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
