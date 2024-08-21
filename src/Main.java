import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(myCalculator(scan));
    }

    public static String myCalculator(Scanner scan) {
        String entstr = scan.nextLine();
        String result = new String();
        String operator;
        if (!entstr.contains("+") && !entstr.contains("-")
                && !entstr.contains("*") && !entstr.contains("/")) {
            result = "Калькулятор работает только с операциями: +, -, *, /. Используйте их, " +
                    "пожалуйста, либо завершите работу.";
        } else {
            for (int g = 0; g < entstr.length(); g++) {
                if (entstr.charAt(g) == '-' || entstr.charAt(g) == '/') {
                    char ch;
                    String line1;
                    String line2;
                    ch = entstr.charAt(g);
                    operator = Character.toString(ch);
                    String[] lines = entstr.split(operator);
                    if (lines.length != 2) {
                        result = "Некорректный ввод данных. Чтобы программа вас поняла, " +
                                "отделите строки и оператор, используя пробелы.";
                    } else {
                        line1 = lines[0];
                        line2 = lines[1];
                        line1 = line1.trim();
                        line2 = line2.trim();
                        result = subCalc(line1, line2, operator);
                    }
                } else if(entstr.charAt(g) == '+') {
                    String line1;
                    String line2;
                    String[] lines = entstr.split("\\+");
                    if (lines.length != 2) {
                        result = "Некорректный ввод данных. Чтобы программа вас поняла, " +
                                "отделите строки и оператор, используя пробелы.";
                    } else {
                        line1 = lines[0];
                        line2 = lines[1];
                        line1 = line1.trim();
                        line2 = line2.trim();
                        String oper = new String();
                        oper = "+";
                        result = subCalc(line1, line2, oper);
                    }
                } else if(entstr.charAt(g) == '*') {
                    String line1;
                    String line2;
                    String[] lines = entstr.split("\\*");
                    if (lines.length != 2) {
                        result = "Некорректный ввод данных. Чтобы программа вас поняла, " +
                                "отделите строки и оператор, используя пробелы.";
                    } else {
                        line1 = lines[0];
                        line2 = lines[1];
                        line1 = line1.trim();
                        line2 = line2.trim();
                        String oper = new String();
                        oper = "*";
                        result = subCalc(line1, line2, oper);
                    }
                }
            }
        }
        return (result);
    }

    public static String subCalc(String line1, String line2, String operator) {
        String result = new String();
        if (line1.charAt(0) != '"' || line1.charAt(line1.length() - 1) != '"') {
            result = "Чтобы калькулятор считал данные, " +
                    "заключите строки в кавычки. Числа заключать в кавычки не нужно. " +
                    "ВНИМАНИЕ: первый операнд не может быть числом!";
        } else if (line1.length() > 12
                || line2.length() > 12) {
            result = "К сожалению, калькулятор работает со строками, " +
                    "содержащими не более 10-ти символов.";
        } else if (line2.charAt(0) != '"' || line2.charAt(line2.length() - 1) != '"') {
            if (line2.equals("1") || line2.equals("2") || line2.equals("3") || line2.equals("4") ||
                    line2.equals("5") || line2.equals("6") || line2.equals("7") || line2.equals("8") ||
                    line2.equals("9") || line2.equals("10")) {
                String str = line1.substring(1, line1.length() - 1);
                int x = Integer.parseInt(line2);
                if (operator.equals("+")) {
                    result = "Нельзя умножить строку на число. Строковый " +
                            "калькулятор не производит подобные операции.";
                }
                if (operator.equals("-")) {
                    result = "Нельзя вычесть число из строки. Строковый калькулятор" +
                            "не производит подобные операции.";
                }
                if (operator.equals("*")) {
                    int k = 0;
                    String str2 = new String();
                    String res = new String();
                    while (k < x) {
                        str2 += str;
                        k++;
                    }
                    res = "\"" + str2 + "\"";
                    if (res.length() > 40) {
                        result = res.substring(0, 41) + "..." + "\"";
                    } else {
                        result = res;
                    }
                }
                if (operator.equals("/")) {
                    if (str.length() < x) {
                        result = "Количество символов в строке меньше разделителя либо " +
                                "равно нулю. Деление не может произойти.";
                    } else {
                        int k = str.length();
                        int d = k / x;
                        String str2 = str.substring(0, d);
                        result = "\"" + str2 + "\"";
                    }
                }
            } else {
                result = "Некорректный ввод данных. Попробуйте еще раз.";
            }
        } else if (line2.charAt(0) == '"' || line2.charAt(line1.length() - 1) == '"') {
            String str = line1.substring(1, line1.length() - 1);
            String str2 = line2.substring(1, line2.length() - 1);
            if (operator.equals("+")) {
                result = "\"" + str + str2 + "\"";
            }
            if (operator.equals("-")) {
                if (str.contains(str2)) {
                    str = str.replace(str2, "");
                    result = "\"" + str + "\"";
                } else {
                    result = "\"" + str + "\"";
                }
            }
            if (operator.equals("*")) {
                result = "Нельзя умножить строку на строку.";
            }
            if (operator.equals("/")) {
                result = "Нельзя разделить строку на строку.";
            }
        } else {
            result = "Некорректный ввод данных. Попробуйте еще раз.";
        }
        return(result);
    }
}