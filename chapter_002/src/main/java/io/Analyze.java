package io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Analyze {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            Map<String, String> map = new HashMap<>();
            boolean isNeedValue = false;
            String line;
            String lastKey = null;
            while (in.ready()) {
                line = in.readLine();
                if (isNeedValue) {
                    while (line.contains("400") || line.contains("500")) {
                        line = in.readLine();
                    }
                    map.put(lastKey, line);
                    isNeedValue = false;
                }
                if (line.contains("400") || line.contains("500")) {
                    map.put(line, "");
                    lastKey = line;
                    isNeedValue = true;
                }
            }
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            for (Map.Entry<String, String> elem: map.entrySet()
                 ) {
                out.println(elem.getKey() + ";" + elem.getValue());
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
