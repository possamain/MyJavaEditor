import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import org.apache.log4j.Level;

public class RunnableHelper {
	private String errorStream = "";
	private String outputStream = "";
	private String errorRAS = "";

	// FUNZIONE PER ESEGUIRE UN FILE .EXE O .BAT
	public int runFile(String pathfile) {

		int exitVal = 0;
		String errors = "";

		try {

			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(pathfile);

			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");

			errorGobbler.start();
			outputGobbler.start();

			exitVal = proc.waitFor();

			// 1 secondo di attesa (i thread potrebbero star ancora leggendo
			// sulle macchine più veloci)
			Thread.sleep(1000);
			errorStream = errorGobbler.getTextStream();
			outputStream = outputGobbler.getTextStream();

			errors = errors + "Process exitValue: " + exitVal;

		} catch (Throwable t) {

			exitVal = -1;

		}

		return exitVal;

	}

	public String getErrorStream() {
		return errorStream;
	}

	public String getOutputStream() {
		return outputStream;
	}

	// CLASSE INTERNA PER LETTURA STREAM
	class StreamGobbler extends Thread {
		InputStream is;
		String type;
		String textStream;

		StreamGobbler(InputStream is, String type) {
			this.is = is;
			this.type = type;
		}

		public void run() {
			try {
				boolean firstErr = false;
				textStream = "";
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					if (type.equalsIgnoreCase("ERROR")) {
						// lh.debugOperazioni(LOGGER_PREFIX, "OUTPUT STREAM >" +
						// line, this.getClass().getName(), "run()",
						// Level.ERROR_INT);
					} else {
						// lh.debugOperazioni(LOGGER_PREFIX, "OUTPUT STREAM >" +
						// line, this.getClass().getName(), "run()",
						// Level.INFO_INT);
					}

					// memorizzo tutto l'output
					textStream = textStream + line + "\r\n";

				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		public String getTextStream() {
			return textStream;
		}

	}

}