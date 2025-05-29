package leetcode.random.task67;

/**
 * Cool looking solution from 1ms
 */
public class SimpleLookSolution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop through both strings from the end
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2); // Append the bit
            carry = sum / 2;        // Update carry
        }

        return result.reverse().toString();

    }
}
