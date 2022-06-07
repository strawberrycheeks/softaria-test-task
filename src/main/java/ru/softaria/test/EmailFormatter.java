package ru.softaria.test;

import java.util.List;
import java.util.Map;

public class EmailFormatter {

    public static String generateStatusMessage(String name,
                                               Map<WebsiteStatus, List<String>> websiteStatus) {

        StringBuilder emailBuilder = new StringBuilder();

        emailBuilder.append("Здравствуйте, ").append(name).append("!\n");

        if (websiteStatus.isEmpty()) {
            emailBuilder.append("За последние сутки во вверенных Вам сайтах не произошло никаких изменений.\n");
        } else {
            emailBuilder.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n");

            addUrlsList(emailBuilder, "Были удалены следующие страницы:\n", websiteStatus.get(WebsiteStatus.DELETED));
            addUrlsList(emailBuilder, "Были добавлены следующие новые страницы:\n", websiteStatus.get(WebsiteStatus.NEW));
            addUrlsList(emailBuilder, "Были изменены следующие страницы:\n", websiteStatus.get(WebsiteStatus.CHANGED));
        }

        return emailBuilder.toString();
    }

    private static void addUrlsList(StringBuilder builder, String comment, List<String> urls) {
        if (urls.isEmpty()) {
            return;
        }

        builder.append(comment);
        for (String url : urls) {
            builder.append(url).append("\n");
        }
    }

}
