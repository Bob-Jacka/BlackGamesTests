import java.io.IOException;

public class AllureReport {

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
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        full_chain();
    }
}
