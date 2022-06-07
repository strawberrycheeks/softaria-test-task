package ru.softaria.test.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DemoDataLoader {
    private static final String previousUrlsPath = "demo-data/previousUrls.txt";
    private static final String currentUrlsPath  = "demo-data/currentUrls.txt";

    private static final String doctypeMarker = "!DOCTYPE";
    private static final String htmlEndMarker = "</html>";

    public Map<String, String> loadPreviousUrls() {
        return loadUrlsMap(previousUrlsPath);
    }

    public Map<String, String> loadCurrentUrls() {
        return loadUrlsMap(currentUrlsPath);
    }

    public Map<String, String> loadUrlsMap(String path) {
        Map<String, String> urls = new HashMap<>();

        try (
                InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))
        ) {
            StringBuilder html = new StringBuilder();
            String url = "";
            String line;

            while ((line = br.readLine()) != null) {
                html.append(line);

                if (line.contains(doctypeMarker)) {
                    url = line.split("\"")[1];
                }

                if (line.contains(htmlEndMarker)) {
                    urls.put(url, html.toString());
                    html = new StringBuilder();
                    url = "";
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred:: failed to load the data from " + path);
            e.printStackTrace();
        }

        return urls;
    }
}
