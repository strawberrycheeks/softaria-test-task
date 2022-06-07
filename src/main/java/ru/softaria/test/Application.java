package ru.softaria.test;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.runDemo();
    }

    public void run() {}

    public void runDemo() {
        Map<WebsiteStatus, List<String>> statusUrl = WebsiteStatusChecker.checkStatus(
                DemoDataLoader.loadPreviousUrls(),
                DemoDataLoader.loadCurrentUrls()
        );

        String username = "сотрудник компании Softaria";
        String email = EmailFormatter.generateStatusMessage(username, statusUrl);
        System.out.println(email);
    }

}
