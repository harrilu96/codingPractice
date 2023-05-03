package DCP_2_3_PrintZigZag;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintZigZag {
    public static void PrintZigZag(String stringToPrint, int numRows) {

        if (numRows == 0) {
            throw new RuntimeException("numRows must be more than 0");
        }

        if (numRows == 1) {
            System.out.println(stringToPrint);
            return;
        }

        Character[][] output = new Character[numRows][stringToPrint.length()];
        int rowPointer = 0;
        int incrementer = 1;

        for (int i = 0; i < stringToPrint.length(); i++) {
            output[rowPointer][i] = stringToPrint.charAt(i);
            if (rowPointer == numRows - 1) {
                incrementer = -1;
            } else if (rowPointer == 0) {
                incrementer = 1;
            }
            rowPointer += incrementer;
        }

        for (Character[] charArray : output) {
            StringBuilder builder = new StringBuilder();
            for (Character character : charArray) {
                builder.append(character == null ? " " : character);
            }
            System.out.println(builder.toString());
        }
    }
}
