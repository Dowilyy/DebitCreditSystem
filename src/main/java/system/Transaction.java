package system;

import java.util.ArrayList;

/**
 * Visu transakciju kolekcija
 */

public class Transaction {

    private ArrayList<Account> list;

    public Transaction() {

        list = new ArrayList<>();
    }


    public void add(Account account) {
        list.add(account);
    }

    public ArrayList<Account> getAccounts() {

        return list;
    }

    /**
     * Balanso apskaiciavimas
     * @return balansas
     */

    public double getBalance() {
        if (list.size() == 0)
            return 0;
        double balance = 0;
        for (Account account : list)
            balance += account.getSum();
        return balance;
    }
}


