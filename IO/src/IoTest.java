import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Basic I/O in java.
 * <p>
 * These are only examples on how to handle file I/O in Java. There are several
 * other possibilities for the input/output of file contents.
 * <p>
 * Detailed information about the classes and methods used in this example can
 * be found in the JavaDoc of the Java API
 * (https://docs.oracle.com/javase/8/docs/api/).
 * 
 * @author claudia
 */
public class IoTest {

	/**
	 * Executes example methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String content = readFile();
		writeFile(content);

		System.out.println(readBytes());
	}

	/**
	 * Read the contents of a file and return them in a <code>String</code>
	 * object.
	 * <p>
	 * The contents of the file are read with a character stream (
	 * <code>FileReader</code>) which is buffered (<code>BufferedReader</code>).
	 * <p>
	 * The resulting string is built up with a <code>StringBuilder</code> object
	 * which support the incremental built of text.
	 * 
	 * @return the contents of the file
	 */
	private static String readFile() {
		StringBuilder buffer = new StringBuilder();
		BufferedReader input = null;

		File file = new File("files/input.txt");

		if (file.exists() && file.isFile() && file.canRead()) {

			try { // the try/catch forms a block; the variables defined in the
					// try/catch block are only visible within this block
					// (variables
					// which have to be accessed outside the block have to be
					// declared
					// outside the block)
				input = new BufferedReader(new FileReader(file));
				// the file path can be relative or absolute; @see java.io.File
				// for
				// more information
				for (String line = input.readLine(); line != null; line = input.readLine()) {
					buffer.append(line).append(System.getProperty("line.separator"));
					// line breaks are depending on the operating system;
					// System.getProperty("line.separator") fetches the suitable
					// line break for the running system.
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally { // not matter if the read operation was successful the
				// input stream has to be closed
				if (input != null) { // input might not have been initialized
										// due to
					// an exception
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return buffer.toString();
	}

	/**
	 * Read the contents of a file and return them in a <code>String</code>
	 * object.
	 * <p>
	 * The contents of the file are read with a byte stream (
	 * <code>InputStream</code>) which is buffered (
	 * <code>BufferedInputStream</code>).
	 * <p>
	 * The resulting string is built up with a <code>StringBuilder</code> object
	 * which support the incremental built of text.
	 * 
	 * @return the contents of the file
	 */
	private static String readBytes() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		File file = new File("files/input.txt");

		if (file.exists() && file.isFile() && file.canRead()) {
			// user autocloseable
			try (InputStream input = new BufferedInputStream(new FileInputStream(file))) {

				byte[] data = new byte[1024];
				int length = 0;

				while ((length = input.read(data)) != -1) {
					buffer.write(data, 0, length);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	/**
	 * Write the given <code>String</code> to a file.
	 * <p>
	 * The content of the file are written through a character stream.
	 * 
	 * @param content
	 */
	private static void writeFile(String content) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new BufferedWriter(new FileWriter("files/output.txt")));
			output.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // the output stream has to be closed even if there was an
			// exception during output.
			output.close();
		}
	}
}
