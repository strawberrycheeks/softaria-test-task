package ru.softaria.test;

import java.util.*;

public class WebsiteStatusChecker {

    public static Map<WebsiteStatus, List<String>> checkStatus(final Map<String, String> previousUrls,
                                                               final Map<String, String> currentUrls) {
        Map<WebsiteStatus, List<String>> statusUrl = new HashMap<>();
        statusUrl.put(WebsiteStatus.CHANGED, new ArrayList<>());
        statusUrl.put(WebsiteStatus.DELETED, new ArrayList<>());
        statusUrl.put(WebsiteStatus.NEW,     new ArrayList<>());

        previousUrls.keySet().forEach(url -> {
            if (!currentUrls.containsKey(url)) {
                statusUrl.get(WebsiteStatus.DELETED).add(url);
            }
        });

        currentUrls.keySet().forEach(url -> {
            if (!previousUrls.containsKey(url)) {
                statusUrl.get(WebsiteStatus.NEW).add(url);
            } else if (!Objects.equals(previousUrls.get(url), currentUrls.get(url))) {
                statusUrl.get(WebsiteStatus.CHANGED).add(url);
            }
        });

        return statusUrl;
    }

}
