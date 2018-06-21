import java.util.Stack;

public class Question2 {

    public static void main(String args[]) {
        
        System.out.println(decodeString("4[ab]"));
        System.out.println(decodeString("2[b3[a]]"));
    }


    private static String decodeString(String string) {


        Stack<Integer> integers = new Stack<>();
        Stack<Character> strings = new Stack<>();
        String temp = "";
        String result = "";

        for (int i = 0; i < string.length(); i++) {
            int count = 0;


            if (Character.isDigit(string.charAt(i))) {
                while (Character.isDigit(string.charAt(i))) {
                    count = count * 10 + string.charAt(i) - '0';
                    i++;
                }

                i--;
                integers.push(count);
            } else if (string.charAt(i) == ']') {
                temp = "";
                count = 0;

                if (!integers.isEmpty()) {
                    count = integers.peek();
                    integers.pop();
                }

                while (!strings.isEmpty() && strings.peek() != '[') {
                    temp = strings.peek() + temp;
                    strings.pop();
                }

                if (!strings.empty() && strings.peek() == '[')
                    strings.pop();


                for (int j = 0; j < count; j++)
                    result = result + temp;

                for (int j = 0; j < result.length(); j++)
                    strings.push(result.charAt(j));

                result = "";
            } else if (string.charAt(i) == '[') {
                if (Character.isDigit(string.charAt(i - 1)))
                    strings.push(string.charAt(i));

                else {
                    strings.push(string.charAt(i));
                    integers.push(1);
                }
            } else
                strings.push(string.charAt(i));
        }

        while (!strings.isEmpty()) {
            result = strings.peek() + result;
            strings.pop();
        }

        return result;
    }
}


