package TestSuits;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages({"TestSuits/Games_suits"})
@SuiteDisplayName("Regression test suit")
public class Regression {

}