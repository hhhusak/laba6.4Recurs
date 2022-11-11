import java.util.Scanner;

public class Main {
    static Scanner scan  = new Scanner(System.in);

    static void arrayCrRecurs(int[] a, int size, int min, int max, int i){
        if(i < size){
            a[i] = (int) (Math.random() * (max - min) + min);
            arrayCrRecurs(a, size, min, max, i + 1);
        }
    }

    static void printRecurs(int[] a, int size, int i){
        if(i < size){
            System.out.printf("%d\t", a[i]);
            printRecurs(a, size, i + 1);
        } else {
            System.out.println();
        }
    }

    static int taskOneRecurs(int[] a, int size, int i, int highest){
        if(i < size){
            if(highest < a[i]){
                highest = a[i];
            }
            return taskOneRecurs(a, size, i + 1, highest);
        }
        return highest;
    }

    static void printTaskOne(int highest){
        System.out.println("Найбільше значення масиву: " + highest);
    }

    static int taskTwoRecursA(int[] a, int size, int i, int n){
        if(i < size){
            if (a[i] > 0){
                n = i;
            }
            return taskTwoRecursA(a, size, i + 1, n);
        }
        return n;
    }
    static int taskTwoRecursB(int[] a, int size, int i, int n, int sumToTheLast){
        if(i < n){
            return taskTwoRecursB(a, size, i + 1, n, sumToTheLast + a[i]);
        }
        return sumToTheLast;
    }

    static void printTaskTwo(int sumToTheLast){
        System.out.println("Сума до останнього додатнього числа: " + sumToTheLast);
    }

    static void enterTaskThreeInterval(int[] a, int size){
        System.out.print("Введіть перше число інтервалу: "); int ld = scan.nextInt();
        System.out.print("Введіть останнє число інтервалу: "); int rd = scan.nextInt();
        taskThreeRecursA(a, size, 0, 0, ld, rd);
    }

    static int taskThreeRecursA(int[] a, int size, int i, int n, int ld, int rd){
        if (i + n < size){
            if (ld <= a[i] && a[i] <= rd) {
                for (int j = i; j < size - n - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[size - n - 1] = 0;
                i--;
                n++;
            }
            return taskThreeRecursA(a, size, i + 1, n, ld, rd);
        }
        return n;
    }

    public static void main(String[] args) {

        System.out.print("Введіть кількість елементів: ");int size = scan.nextInt();
        System.out.print("Введіть мінімальний елемент: ");int min = scan.nextInt();
        System.out.print("Введіть максимальний елемент: ");int max = scan.nextInt();

        int[] a = new int[size];
        int highest = a[0];
        int n = 0;
        int sumToTheLast = 0;

        arrayCrRecurs(a, size, min, max, 0);
        printRecurs(a, size, 0);

        highest = taskOneRecurs(a, size, 1, highest);
        printTaskOne(highest);

        n = taskTwoRecursA(a, size, 0, n);
        sumToTheLast = taskTwoRecursB(a, size, 0, n, sumToTheLast);
        printTaskTwo(sumToTheLast);

        enterTaskThreeInterval(a, size);
        printRecurs(a, size, 0);
    }
}