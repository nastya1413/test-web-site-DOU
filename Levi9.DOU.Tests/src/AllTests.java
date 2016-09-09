// Test cases or mini test suites will be managed by this file
// There are @SuiteClasses annotation which describes classes included in that test suite.

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ DOU_TestPage.class })
public class AllTests {

}
