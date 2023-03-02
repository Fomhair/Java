import java.util.Random;

/**
 * lesson01
 */
public class lesson01 {
  public static int randomNumber(int k) {
    return new Random().nextInt(k);
  }

  public static int mostSignificantBit(int n) {
    int msb = 0;
    while (n > 0) {
        n = n >> 1;
        msb++;
    }
    return msb;
  }

  public static int[] multiplicity(int number, int n, int limit) {
    int count = 0;
    for(int i = number; i <= limit; i++) {
      if(i % n == 0) {
        count++;
      }
    }
    int[] result = new int[count];
    count = 0;
    for(int i = number; i <= limit; i++) {
      if(i % n == 0) {
        result[count] = i;
        count++;
      }
    }
    return result;
  }

  public static int[] nonMultiplicity(int number, int n, int limit) {
    int count = 0;
    for(int i = number; i <= limit; i++) {
      if(i % n != 0) {
        count++;
      }
    }
    int[] result = new int[count];
    count = 0;
    for(int i = number; i <= limit; i++) {
      if(i % n != 0) {
        result[count] = i;
        count++;
      }
    }
    return result;
  }

  public static void printArray(int[] arr, String name) {
    for (int i = 0; i < arr.length; i++) {
      if(i == 0) {
        System.out.printf("%s = %d, ", name, arr[i]);
      } else {
        System.out.printf("%d, ", arr[i]);
      }
    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    int i = randomNumber(2000);
    int n = mostSignificantBit(i);
    int[] m1 = multiplicity(i, n, Short.MAX_VALUE);
    int[] m2 = multiplicity(Short.MIN_VALUE, n, i);
    System.out.printf("i = %d\nn = %d\n", i, n);
    printArray(m1, "m1");
    printArray(m2, "m2");
  }
}