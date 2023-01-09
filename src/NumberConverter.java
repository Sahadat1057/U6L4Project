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

    public int[] convertToBinary(int number) {
        String binary = "";
        if(base != 2) {
            if (base == 10) {
               while (number > 2) {
                   number = number / 2;
                   remainder = number % 2;
                   if (remainder == 0) {
                        binary += "0";
                   }
                   else if (remainder == 1) {
                       binary += "1";
                   }
               }

               for(int i = 0; i < binary.length(); i++) {
                   String binaryDigit = binary.substring(i,i+1);
                   int [] binaryDigits = binaryDigit.add();

               }
            }
            if (base == 8) {
                while (number > 2) {
                    number = number / 2;
                    remainder = number % 2;
                    if (remainder == 0) {
                        binary += "0";
                    }
                    else if (remainder == 1) {
                        binary += "1";
                    }
                }
            }

        }
    }

    public int[] convertToOctal() {
        return null;
    }

}
