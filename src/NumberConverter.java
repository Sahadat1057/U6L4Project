public class NumberConverter {
    private String[] digits;
    private int base;

    public NumberConverter(String number, int base) {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i,i+1);
            digits[i] = single;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits() {
        return digits;
    }

    public String[] convertToDecimal() {
        String[] decimalDigits;
        String possibleVals = "0123456789ABCDEF";
        int decimalVal = 0;
        int value = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            decimalVal += value * possibleVals.indexOf(digits[i]);
            value *= base;
        }
        String numString = decimalVal + "";
        decimalDigits = stringToStringList(numString);
        return decimalDigits;
    }

    public String[] convertToBinary() {
        String[] decimalForm = convertToDecimal();
        int power = 0;
        String binaryVal = "";
        int decimalDigit = Integer.parseInt(stringListToString(decimalForm));
        while (decimalDigit - Math.pow(2, power) >= 0) power++;
        if (decimalDigit - Math.pow(2, power) < 0) {
            power--;
        }
        int quotient;
        while (power >= 0) {
            quotient = decimalDigit / (int) Math.pow(2, power);
            binaryVal = binaryVal + quotient;
            decimalDigit -= Math.pow(2, power) * quotient;
            power--;
        }
        String[] binaryDigits = stringToStringList(binaryVal);
        return binaryDigits;

    }

    public String[] convertToOctal() {
        String[] decimalForm = convertToDecimal();
        int power = 0;
        String octalValue = "";
        int decimalDigit = Integer.parseInt(stringListToString(decimalForm));
        while (decimalDigit - Math.pow(8, power) >= 0) {
            power++;
        }
        if (decimalDigit - Math.pow(8,power) < 0) {
            power--;
        }
        int quotient;
        while (power >= 0) {
            quotient = decimalDigit / (int) Math.pow(8, power);
            octalValue = octalValue + quotient;
            decimalDigit -= Math.pow(8, power) * quotient;
            power--;
        }
        String[] octalDigits = stringToStringList(octalValue);
        return octalDigits;
    }

    public String[] convertToHexadecimal() {
        String[] hexaForm = convertToDecimal();
        int power = 0;
        String hexaValue = "";
        int hexaDigit = Integer.parseInt(stringListToString(hexaForm));
        while (hexaDigit - Math.pow(16, power) >= 0) {
            power++;
        }
        if (hexaDigit - Math.pow(16, power) < 0) {
            power--;
        }
        int quotient;
        while (power >= 0) {
            quotient = hexaDigit / (int) Math.pow(8, power);
            hexaValue = hexaValue + quotient;
            hexaDigit -= Math.pow(16, power) * quotient;
            power--;
        }
        String[] hexaDigits = stringToStringList(hexaValue);
        return hexaDigits;
    }

    public String stringListToString(String[] stringList) {
        String numString = "";
        for (int i = 0; i < stringList.length; i++) {
            numString = numString + stringList[i];
        }
        return numString;
    }

    public String[] stringToStringList(String numString) {
        String[] numList = new String[numString.length()];
        for (int i = 0; i < numString.length(); i++) {
            String num = numString.substring(i,i+1);
            numList[i] = num;
        }
        return numList;
    }

    public static boolean checkInputs(int base, String num) {
        String digit = "";
        String possibleValues = "0123456789ABCDEF";
        String availableBaseValues = possibleValues.substring(0,base);
        String[] numList = new String[num.length()];
        for (int i = 0; i < numList.length; i++) {
            numList[i] = num.substring(i,i+1);
            digit = num.substring(i,i+1);
        }
        for (int i = 0; i < numList.length; i++) {
            if (availableBaseValues.indexOf(digit) < 0) {
                return false;
            }
        }
        return true;
    }

    public static String convertToBase64(int decimal, int base) {
        String base64Val = "";
        if (base == 1) {
            for (int i = 0; i < decimal; i++){
                base64Val = base64Val + "1";
            }
            return base64Val;
        }
        else if (decimal == 0) return "0";
        String allPossibleValues = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        int power = 0;
        while (decimal - Math.pow(base, power) >= 0) {
            power++;
        }
        if (decimal - Math.pow(base, power) < 0) {
            power--;
        }
        int quotient;
        while (power >= 0) {
            quotient = decimal / (int) Math.pow(base, power);
            base64Val = base64Val + allPossibleValues.substring(quotient, quotient + 1);
            decimal -= Math.pow(base, power) * quotient;
            power--;
        }
        return base64Val;
    }

    public String toString() {
        String str = "";
        if (base != 2) str += "Binary Value: " +  convertToBase64(Integer.parseInt(stringListToString(convertToDecimal())), 2) + "\r";
        if (base != 8) str +=  "Octal Value: " + convertToBase64(Integer.parseInt(stringListToString(convertToDecimal())),8) + "\r";
        if (base != 10) str += "Decimal Value: " + convertToBase64(Integer.parseInt(stringListToString(convertToDecimal())),10) + "\r";
        if (base != 16) str += "Hexadecimal Value: " + convertToBase64(Integer.parseInt(stringListToString(convertToDecimal())),16);
        return str;
    }




}
