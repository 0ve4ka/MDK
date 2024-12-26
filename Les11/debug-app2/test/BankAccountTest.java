import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount = new BankAccount("Артём","Архипов");



    @Test
    void shouldReturnNullAmountWhenNotActive() {
        String result = bankAccount.getCurrency();

        Assertions.assertNull(result);
    }

    @Test
    void shouldBeBlockedAfterBlockIsCalled() {
        bankAccount.block();
        boolean result = bankAccount.isBlocked();

        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnFirstNameThenSecondName() {
        String[] waitResult = {"Артём", "Архипов"};
        String[] result = bankAccount.getFullName();

        Assertions.assertArrayEquals(waitResult,result);
    }
}