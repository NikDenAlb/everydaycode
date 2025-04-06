package yandex.coderun.random.task78;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AmbulanceTest {

    @Test
    public void testFindAddressCase1() {
        long k1 = 89;
        long m = 20;
        long k2 = 41;
        long p2 = 1;
        long n2 = 11;
        String expected = "2 3";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase2() {
        long k1 = 11;
        long m = 1;
        long k2 = 1;
        long p2 = 1;
        long n2 = 1;
        String expected = "0 1";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase3() {
        long k1 = 3;
        long m = 2;
        long k2 = 2;
        long p2 = 2;
        long n2 = 1;
        String expected = "-1 -1";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase4() {
        long k1 = 100;
        long m = 3;
        long k2 = 60;
        long p2 = 1;
        long n2 = 1;
        String expected = "1 0";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase5() {
        long k1 = 25;
        long m = 5;
        long k2 = 10;
        long p2 = 2;
        long n2 = 2;
        String expected = "-1 -1";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase6() {
        long k1 = 50;
        long m = 5;
        long k2 = 50;
        long p2 = 4;
        long n2 = 2;
        String expected = "4 2";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase7() {
        long k1 = 1000;
        long m = 3;
        long k2 = 2000;
        long p2 = 5;
        long n2 = 3;
        String expected = "3 2";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase8() {
        long k1 = 12;
        long m = 4;
        long k2 = 6;
        long p2 = 2;
        long n2 = 1;
        String expected = "-1 -1";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAddressCase9() {
        long k1 = 50;
        long m = 10;
        long k2 = 30;
        long p2 = 1;
        long n2 = 3;
        String expected = "1 0";
        String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllCombinations() {
        boolean flag = true;
        for (long k1 = 1; k1 <= 100; k1++) {
            for (long m = 1; m <= 10; m++) {
                for (long k2 = 1; k2 <= 100; k2++) {
                    for (long p2 = 1; p2 <= m; p2++) {
                        for (long n2 = 1; n2 <= m; n2++) {
                            String expected = AmbulanceBrute.findAddressBrute((int) k1, (int) m, (int) k2, (int) p2, (int) n2);
                            String actual = Ambulance.findAddress(k1, m, k2, p2, n2);
                            if (!expected.equals(actual)) {
                                System.out.printf("Mismatch with inputs: k1=%d, m=%d, k2=%d, p2=%d, n2=%d. Expected: %s, but got: %s%n",
                                        k1, m, k2, p2, n2, expected, actual);
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        assert flag;
    }
}
