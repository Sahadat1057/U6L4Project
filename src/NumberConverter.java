public class NumberConverter {
    int[] digits;
    int base;
    int number;

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
        if(base != 2) {
            if (base == 10) {
                int counter = 0;
                for (int i = 0; number >= 2; counter++ ) {
                    number = number / 2;
                }
                int r = number - b;
               double b = Math.pow(2, counter);
                while (int r != 0 && counter < ) {
                    int r = number - b;
                }
            }

        }
    }

    public int[] convertToOctal() {
        return null;
    }

}
