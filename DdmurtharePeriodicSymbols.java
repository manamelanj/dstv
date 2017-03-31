import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  Given two strings,
 *  one an element name and one a proposed symbol for that element, this
 *  determines whether the symbol follows the rules.
 */
public class DdmurtharePeriodicSymbols {

    public static void main(String[] agrs) {

        DdmurtharePeriodicSymbols of = new DdmurtharePeriodicSymbols();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter element and its symbol");

        String element = scanner.next();
        String symbol = scanner.next();

        of.validator(element, symbol);

    }

    private boolean checkElementSymbol(String element, String symbol) {

        int first_position = 0;
        int second_position = 0;
        boolean isValid  = false;
        char[] symChar = symbol.toCharArray();

        first_position = element.indexOf(symChar[0]);
        second_position = element.lastIndexOf(symChar[1]);

        if (first_position<second_position)
            isValid = true;

        return isValid;
    }

    private void validator(String element, String symbol) {

        char[] symChar = symbol.toCharArray();

        if (isAlpha(element, symbol)) {

            System.out.println("Both element and symbol should only contain letters");

        } else if ((symbol.length() != 2) || element.length() < symbol.length()) {

            System.out.println("Please enter valid element and Symbol.");

        } else if ((element.indexOf(symChar[0]) == -1 ) || (element.indexOf(symChar[1]) == -1)) {

            System.out.println("Please enter characters that are in the element");

        } else {
            System.out.println(toCamelCase(element)+" , "+toCamelCase(symbol)+" -> "+checkElementSymbol(element, symbol));
        }

    }

    // Alternative is to use apache commons Util library
    private boolean isAlpha(String element, String symbol) {

        String matcher = "\\p{L}*+";
        if(!Pattern.matches(matcher, element) || !Pattern.matches(matcher, symbol)) {
           return true;
        }
        return false;
    }

    // Alternative is to use apache commons Util library
    private String toCamelCase(String str) {
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
