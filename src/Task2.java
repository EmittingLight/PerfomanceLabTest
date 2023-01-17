import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> circle = readFile(args[0]);
        List<String> points = readFile(args[1]);
        String[] split = circle.get(0).split(" ");
        float x = Float.parseFloat(split[0]);
        float y = Float.parseFloat(split[1]);
        float r = Float.parseFloat(circle.get(1));
        for (String point : points) {
            String[] s = point.split(" ");
            float pX = Float.parseFloat(s[0]);
            float pY = Float.parseFloat(s[1]);
            float pR = (float) Math.sqrt(Math.pow(pX - x, 2) + Math.pow(pY - y, 2));
            if (pR == r) {
                System.out.println(0);
            } else if (pR < r) {
                System.out.println(1);
            } else {
                System.out.println(2);
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
}
