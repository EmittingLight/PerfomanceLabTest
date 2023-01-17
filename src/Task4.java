import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> fileData = readFile(args[0]);
        int[] array = convert(fileData);
        System.out.println(find(array));
    }

    private static int find(int[] array) {
        sort(array);
        int mainValue = array[array.length / 2];
        int sum = 0;
        for (int element : array) {
            sum += Math.abs(element - mainValue);
        }
        return sum;
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] convert(List<String> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(list.get(i));
        }
        return array;
    }
}
