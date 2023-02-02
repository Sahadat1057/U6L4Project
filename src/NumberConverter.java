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

    public int[] convertToDecimal() {
        return null;
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


}
