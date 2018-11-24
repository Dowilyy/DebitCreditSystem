package file;

import system.Account;
import system.Transaction;


/**
 * Pagrindinis programos algoritmas
 */
public class Program {
    private Transaction transaction;
    private Dialog dialog;

    /**
     * Veiksmu pasirinkimas ir vykdymas
     */

    public void start() {
        dialog = new Dialog();
        transaction = Storage.load();
        while (true) {
            showMenu();
            String item = dialog.input("Iveskite meniu punkta: ");
            switch (item) {
                case "1":
                    addIncome();
                    break;//prideti pajamas
                case "2":
                    addExpenses();
                    break;//prideti islaidas
                case "3":
                    showTransactions();
                    break;//parodyti visas transakcijas
                case "4":
                 showBalance();
                 break;//apskaiciuoti balansa
                case "0":
                    if (doExit())
                        return;//baigti darba
                    break;
                default:
                    dialog.println("Iveskite meniu punkta nuo 0 iki 4");
                    break;
            }
        }
    }

    private void showMenu() {
        dialog.println("-=PAGRINDINIS Meniu=-");
        dialog.println("1. Prideti pajamas");
        dialog.println("2. Prideti islaidas");
        dialog.println("3. Parodyti visas transakcijas");
        dialog.println("4. Parodyti balansa");
        dialog.println("0. Issaugoti ir iseiti");
    }

    private void addIncome() {
        try {
            String description = dialog.input("Iveskite aprasyma: ");
            double sum = Double.parseDouble(dialog.input("Iveskite suma: "));
            if (sum < 1)
                throw new IllegalArgumentException("Ivedama suma turi buti teigiamas skaicius, ivesta: " + sum);
            Account acc = new Account(description, sum);
            transaction.add(acc);
        }catch (NumberFormatException e) {
            System.out.println("Suma ivesta neteisingai");
        }
    }

    private void addExpenses() {
        try{
        String description = dialog.input("Iveskite aprasyma: ");
        double sum = Double.parseDouble(dialog.input("Iveskite suma: "));
        if (sum < 1)
            throw new IllegalArgumentException("Ivedama suma turi buti teigiamas skaicius, ivesta: " + sum);
        sum = -sum;
        Account acc = new Account(description, sum);
        transaction.add(acc);
        }catch (NumberFormatException e) {
            System.out.println("Suma ivesta neteisingai");
        }
    }

    private void showTransactions() {
        if (transaction.getAccounts().size() == 0) {
            dialog.println("Transakciju sarasas yra tuscias");
            return;
        }
        for (Account acc : transaction.getAccounts())
            dialog.println(acc + "");
    }

     private void showBalance() {
        dialog.println("Balansas yra: "  + String.format("%7.2f",transaction.getBalance()) + " EUR");
     }

    private boolean doExit() {
        boolean result = Storage.save(transaction);
        if (result)
            dialog.println(" Issaugota, sekmes!");
        else
            dialog.println("Nepavyko issaugoti");
        return result;
    }
}




