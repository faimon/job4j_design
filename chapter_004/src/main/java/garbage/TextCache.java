package garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class TextCache implements Cache<String, StringBuilder> {
    private final Map<String, SoftReference<StringBuilder>> cacheMap;

    public TextCache() {
        cacheMap = new HashMap<>();
    }

    @Override
    public StringBuilder get(String key) {
        if (cacheMap.get(key) == null) {
            try (BufferedReader in = new BufferedReader(new FileReader(key))) {
                StringBuilder fileContent = new StringBuilder();
                in.lines().forEach(line -> fileContent.append(line).append(System.lineSeparator()));
                cacheMap.put(key, new SoftReference<>(fileContent));
                return fileContent;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cacheMap.get(key).get();
    }

    public static void main(String[] args) {
        TextCache textCache = new TextCache();
        System.out.println(textCache.get("./input.txt"));
    }
}
