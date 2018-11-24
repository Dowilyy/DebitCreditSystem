package system;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void getDescription() {
        Account account = new Account("atlyginimas", 555.43);
        assertEquals("atlyginimas", account.getDescription());
    }

    @Test
    public void toStringTest() {
        Account account = new Account("atlyginimas", 555.56);
        assertEquals("555.56 EUR - atlyginimas",account.toString().trim());
    }
}