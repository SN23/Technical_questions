public class Question3 {

    public static void main(String args[]) {


        int denominations[] = {1, 2, 3};
        System.out.println(changePossibilities(4, denominations, denominations.length));
    }

    private static int changePossibilities(int amount, int denominations[], int arraySize) {

        if (amount == 0)
            return 1;

        if (amount < 0)
            return 0;

        if (arraySize <= 0)
            return 0;

        return changePossibilities(amount, denominations, arraySize - 1) +
                changePossibilities(amount - denominations[arraySize - 1], denominations, arraySize);

    }

}