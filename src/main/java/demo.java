import java.util.function.IntBinaryOperator;

/**
 * Created by baohg on 25/08/2016.
 */
public class demo {
    public static int getNumTransaction(int[] confirmRate, int[] transactions) {
        if (confirmRate.length == 0 || transactions.length == 0)
            return 0;
        int length = confirmRate.length > transactions.length ? transactions.length : confirmRate.length;
        int totalTransactions = 0;
        for (int i = 0; i < length; i++) {
            totalTransactions += transactions[i] * confirmRate[i] / 100;
        }
        return totalTransactions;
    }

    public static void main(String[] args) {
        int[] confirmRate = {60, 60, 40};
        int[] transactions = {40, 40, 20};
        System.out.println(getNumTransaction(confirmRate, transactions));
    }
}
