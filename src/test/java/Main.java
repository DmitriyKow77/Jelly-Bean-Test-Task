public class Main {
    public static void main(String[] args) throws Throwable {
        String[] cucumberArguments = {
                "src/test/resources/features",
                "--glue", "info.stepdefinitions",
                "--tags", "@all",
                "--no-dry-run",
                "--no-strict"
        };

        cucumber.api.cli.Main.main(cucumberArguments);
    }
}
