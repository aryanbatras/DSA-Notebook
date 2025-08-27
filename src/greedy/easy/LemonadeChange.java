package greedy.easy;

public class LemonadeChange {
// This question says that the price for a lemonade is 5$ only. But the customer pays in three variations as 5$, 10$, 20$. We have returned the rest of money to customer so that each person pays only 5$ for the lemonade. Since there are variations in how money is paid, we have different bills for each payment amount. We have to find whether we are able to give change to the next customers from the bills that we have collected. Initially, the shopkeeper has no bills. The answer is in boolean.

// bills = [5,5,10, 20]
// output = true
// First, taking two 5$ bills
// Then, taking one 10$ bill and giving one 5$ bill back
// Then, taking one 20$ bill and giving one 5$ bill and one 10$ bill

// bills = [5,5,10,10,20]
// output = false
// First, taking two 5$ bills
// Then, taking one 10$ bill and giving one 5$ bill back
// Then, taking one 10$ bill again and giving one 5$ bill back
// Then, taking one 20$ bill, since we have only two 10$ bills
// It is not possible to return 15$ money to the 20$ customer

// Approach Think of the best case at each step. As a shopkeeper, we would like to keep each of bills separately. And then treating customers one by one in the same order as they have come on shop.

// Note There is a edge case here where even if you have no 10$ bills, you could also give three 5$ bills if you have and not just a 10$ bill - 5$ bill to customer.
    public static boolean lemonadeChange(int[] bills) {

        // 3 cases, 5$ 10$ 20$
        // [5,5,10,10,20]

        int billIndex = 0;
        int tenDollorChange = 0;
        int fiveDollorChange = 0;
        int twentyDollorChange = 0;
        while (billIndex < bills.length) {
            if (bills[billIndex] == 5) {
                billIndex++;
                fiveDollorChange++;
            } else if (bills[billIndex] == 10) {
                if (fiveDollorChange == 0) {
                    return false;
                }
                tenDollorChange++;
                fiveDollorChange--;
                billIndex++;
            } else {
                if (fiveDollorChange == 0 || tenDollorChange == 0 && fiveDollorChange < 3) {
                    return false;
                }
                // edge case
                if (tenDollorChange == 0 && fiveDollorChange >= 3) {
                    fiveDollorChange -= 3;
                } else {
                    fiveDollorChange--;
                    tenDollorChange--;
                }
                twentyDollorChange++;
                billIndex++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
//                findContentChildren(
//                        new int[]{1, 2, 3},
//                        new int[]{1, 1}
//                )
                lemonadeChange(
                        new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}
                )
        );
    }
}
