package model;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Class that work same as a log Design pattern Singleton.
 * 
 *
 */
public final class Log {
	
	private static Log instance = null;
	private File file = new File("src/main/java/main/notwist.log");
	private Logger logger;
	private FileHandler fh = new FileHandler(file.getPath(), true);

	private Log() throws IOException, SecurityException {
		if (instance == null) {
			try {
				instance = new Log();
			} catch (SecurityException | IOException e) {

				System.out.println("Error log \n " + e);
			}
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		logger = Logger.getLogger("logFile");
		logger.setUseParentHandlers(false);
		logger.addHandler(fh);
		SimpleFormatter form = new SimpleFormatter();
		fh.setFormatter(form);

	}

	/**
	 * write info message in log file.
	 * 
	 * @param s details of info
	 */
	public void logInfo(final String s) {
		logger.log(Level.INFO, s);
	}

	/**
	 * write warning message in log file.
	 * 
	 * @param s details of warning
	 */
	public void logWarning(final String s) {
		logger.log(Level.WARNING, s);
	}

	/**
	 * 
	 * @return instance of this class
	 */
	public static Log getInstance() {
		return instance;
	}

}
