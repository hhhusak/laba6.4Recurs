import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest64 {

    @Test
    void arrayCrRecurs() {
        int size = 25;
        int min = -10; int max = 10;
        int[] a = new int[size];
        Main.arrayCrRecurs(a, size, min, max, 0);
        for (int i = 0; i < size; i++) {
            assertTrue(a[i] >= min && a[i] <= max);
        }
    }
}