import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;

/**
 * Command line entry point
 */
public class Main {

    private static final String allureCommand = "allure serve";
    private static final String allureGetReportCommand = "gradle allureReport";
    private static final String buildCommand = "gradlew build";
    private static final String testCommand = "gradlew test";

    private static void full_chain() {
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(testCommand);
            runtime.exec(buildCommand);
            runtime.exec(allureGetReportCommand);
            runtime.exec(allureCommand);
        } catch (IOException e) {
            System.out.println("Error in executing full chain script");
        }
    }

    private static boolean check_gradle() {
        try {
            Runtime.getRuntime().exec("gradle");
            return true;
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Maybe there is no gradle, installed in the system");
            System.out.println("To install gradle go " + "https://gradle.org/install/");
        }
        return false;
    }

    private static boolean check_allure() {
        try {
            Runtime.getRuntime().exec("allure");
            return true;
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Maybe there is no allure, installed in the system");
            System.out.println("To install allure go " + "https://allurereport.org/docs/install/");
        }
        return false;
    }

    private static void get_allure_report() {
        try {
            Runtime.getRuntime().exec(allureCommand);
            Runtime.getRuntime().exec(allureGetReportCommand);
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Some problems with allure report");
        }
    }

    private static void get_gradle_build() {
        try {
            Runtime.getRuntime().exec(buildCommand);
            Runtime.getRuntime().exec(testCommand);
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Some problems with gradle build");
        }
    }

    private static void gradle_build() {
        try {
            Runtime.getRuntime().exec(buildCommand);
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Some problems with gradle build");
        }
    }

    private static void test() {
        try {
            Runtime.getRuntime().exec(testCommand);
            get_allure_report();
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Some problems with allure report");
        }
    }

    public static void main(String[] @NotNull args) {
        if (args.length > 2) {
            if (check_gradle() && check_allure()) {
                switch (args[0]) {
                    case "Test" -> test();
                    case "Build" -> gradle_build();
                    case "Full" -> full_chain();
                    default -> throw new RuntimeException("Illegal argument exception");
                }
            } else {
                System.out.println("Main function failed");
            }
        } else {
            System.out.println("Error in command line arguments");
            System.out.println("You can write 3 types of argument (one of them)");
            System.out.println("CMD arguments:");
            System.out.println("1. Test");
            System.out.println("2. Build");
            System.out.println("3. Full (build and then test)");
        }
    }
}
