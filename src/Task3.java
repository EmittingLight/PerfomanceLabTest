import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        List<String> tests = readFile(args[0]);
        String testsLine = String.join("", tests);

        List<String> strings = readFile(args[1]);
        String valuesLine = String.join("", strings);
        Map<Integer, String> valuesMap = parse(valuesLine);

        int idIndex = testsLine.indexOf("id\"");
        while (idIndex != -1) {
            int idValueIndex = idIndex + 5;
            int id = Integer.parseInt(testsLine.substring(idValueIndex, testsLine.indexOf(",", idValueIndex)));
            testsLine = testsLine.replaceFirst("\"\"", valuesMap.get(id));
            idIndex = testsLine.indexOf("id\"", idIndex + 1);
        }

        try {
            Files.write(Path.of("report.json"), List.of(testsLine));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Map<Integer, String> parse(String text) {
        Map<Integer, String> map = new HashMap<>();
        int index = text.indexOf("id");
        while (index != -1) {
            int idIndex = index + 5;
            int id = Integer.parseInt(text.substring(idIndex, text.indexOf(",", idIndex)));
            int valueIndex = text.indexOf("value", idIndex) + 8;
            String value = text.substring(valueIndex, text.indexOf('"', valueIndex + 1) + 1);
            map.put(id, value);



            index = text.indexOf("id", index + 1);

        }
        return map;
    }


    private static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
