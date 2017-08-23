import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
public class NioTest {

	public static void main(String[] args) {
		listing("files");
		listing("D:\\Development\\workspace\\IO");
		listing("D:/Development/workspace/IO");
		copy("files/input.txt");
	}

	private static void listing(final String directory) {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
			for (Path path : directoryStream) {
				System.out.println(path.toAbsolutePath().toString() + " " + Files.size(path) + " bytes");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copy(final String file) {
		try (InputStream in = Files.newInputStream(Paths.get(file))) {
			Files.copy(in, Paths.get(file + ".bkp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
