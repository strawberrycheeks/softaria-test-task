package ru.softaria.test;

import ru.softaria.test.demo.DemoDataLoader;

import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.runDemo();
    }

    public void run() {

    }

    public void runDemo() {
        DemoDataLoader demoDataLoader = new DemoDataLoader();

        Map<String, String> map = demoDataLoader.loadPreviousUrls();
        for (String key : map.keySet()) {
            System.out.println(key + "\n" + map.get(key));
        }

        map = demoDataLoader.loadCurrentUrls();
        for (String key : map.keySet()) {
            System.out.println(key + "\n" + map.get(key));
        }
    }
}
