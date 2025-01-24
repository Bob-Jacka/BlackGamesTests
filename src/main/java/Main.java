import org.example.core.functional.ActionController;

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
            System.out.println("Maybe there is no gradle installed in the system");
        }
        return false;
    }

    private static boolean check_allure() {
        try {
            Runtime.getRuntime().exec("allure");
            return true;
        } catch (IOException e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Maybe there is no allure installed in the system");
        }
        return false;
    }

//        public static void main(String[] args) {
//        if (check_gradle() && check_allure()) {
//            full_chain();
//        } else {
//            System.out.println("Checks failed");
//        }
//    }
    public static void main(String[] args) {
        ActionController.get_terminal();
    }
}
