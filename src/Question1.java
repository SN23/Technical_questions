public class Question1 {

    public static void main(String args[]) {


        String s = "weather";
        String t = "therapyw";

        String s2 = "good";
        String t2 = "odg";

        String output = sortByStrings(s, t);
        String output2 = sortByStrings(s2, t2);

        System.out.println("Output: " + output);
        System.out.println("Output2: " + output2);

    }


    private static String sortByStrings(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        String output;
        StringBuilder sb = new StringBuilder(sArray.length);

        for (int i = 0; i < tArray.length; i++) {

            for (int j = 0; j < sArray.length; j++) {
                if (sArray[j] == tArray[i]) {
                    sb.append(sArray[j]);
                }
            }
        }

        output = sb.toString();

        return output;
    }
}
