package by.testtask.bootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampApplication {
	private static final Logger logger = LogManager.getLogger(BootcampApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BootcampApplication.class, args);

//		logger.trace("Trace log message");
//		logger.debug("Debug log message");
//		logger.info("Info log message");
//		logger.error("Error log message");
		logger.warn("Warn log message");
		logger.fatal("Fatal log message");
	}
}
