package main;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	private static Log instance = null;
	private File file = new File("src/main/java/main/notwist.log");
	private Logger logger;
	private FileHandler fh = new FileHandler(file.getPath(), true);

	public Log() throws IOException, SecurityException {
		if (!file.exists())
			file.createNewFile();
		logger = Logger.getLogger("ntwst");
		logger.addHandler(fh);
		SimpleFormatter form = new SimpleFormatter();
		fh.setFormatter(form);
	}

	public void logInfo(String s) {
		logger.log(Level.INFO, s);
	}

	public void logWarning(String s) {
		logger.log(Level.WARNING, s);
	}

	public static Log getInstance() {
		if (instance == null)
			try {
				instance = new Log();
			} catch (SecurityException | IOException e) {

				System.out.println("Error log \n " + e);
			}
		return instance;
	}

}
