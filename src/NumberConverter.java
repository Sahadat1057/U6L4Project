public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
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

    public int[] getDigits() {
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

    public int[] convertToBinary() {
        return null;
    }

    public int[] convertToOctal() {
        return null;
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

    public boolean checkInputs(int base, String num) {
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




}
