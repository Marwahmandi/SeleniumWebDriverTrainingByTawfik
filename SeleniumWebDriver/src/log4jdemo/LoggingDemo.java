/*
package log4jdemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;





public class LoggingDemo {

    // set log4j 2 configuration
    static {
        System.setProperty("log4j.configurationFile", "./log4j2.xml");
    }

    private static Logger logger = LogManager.getLogger();


    @Before
    public void setUp() throws Exception {
        //System.out.println("Executed before class...");
        logger.info("Executed before class...");
    }


    @Test
    public void test1() {
        logger.debug("This is a debug message");

        logger.info("This is an info message");

        logger.warn("This is a warn message");

        logger.error("This is an error message");

        logger.fatal("This is a fatal message");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //System.out.println("Executed after class...");
        logger.info("Executed after class...");
    }
}

*/
