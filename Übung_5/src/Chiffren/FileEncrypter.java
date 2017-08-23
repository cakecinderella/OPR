package Chiffren;

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

public class FileEncrypter {

	public static void main(String[] args) {
		String content = readFile();
		writeFile(content);
		System.out.println(readBytes());
	}
	
	private static String readFile() {
		StringBuilder buffer = new StringBuilder();
		BufferedReader input = null;
		File fileName = new File("Files/testInput.txt");
		if(fileName.exists() && fileName.isFile() && fileName.canRead()) {
			try{
				input = new BufferedReader(new FileReader(fileName));
				for(String line = input.readLine(); line != null; line = input.readLine()){
					buffer.append(line).append(System.getProperty("line.separator"));
				}
			} catch (FileNotFoundException message){
				message.printStackTrace();
			} catch (IOException message){
				message.printStackTrace();
			} finally {
				if(input != null){
					try {
						input.close();
					} catch (IOException message) {
						message.printStackTrace();
					}
				}
			}
		}
		return buffer.toString();
	}
	
	private static String readBytes(){
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		File fileName = new File("Files/testInput.txt");
		if(fileName.exists() && fileName.isFile() && fileName.canRead()) {
			try(InputStream input = new BufferedInputStream(new FileInputStream(fileName))){
				byte[] data = new byte[1024];
				int length = 0;
				while((length = input.read(data)) != -1){
					buffer.write(data, 0, length);
				}
			} catch(FileNotFoundException message){
				message.printStackTrace();
			} catch(IOException message){
				message.printStackTrace();
			}
		}
		return buffer.toString();
	}
	
	private static void writeFile(String content) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new BufferedWriter(new FileWriter("files/output.txt")));
			output.write(content);
		} catch(IOException message){
			message.printStackTrace();
		} finally {
			output.close();
		}
	}
	
	public void encrypt(final String inputPath){
		
		
		
		
		
	//	File fileName = new File(inputPath);
	//	String content = new String ((byte[]) Files.readAllBytes(Paths.get(fileName)));
		
		
		
//		fileName.exists(inputPath);
//		
//		
//		FileEncrypter fileInputStream = null;
//		byte[] bFile = new byte[(int) inputPath.length()];
//		try{
//			fileInputStream = new FileInputStream(inputPath);
//			fileInputStream.read(bFile);
//			fileInputStream.close();
//		} catch (Exception e){
//			e.printStackTrace();
//		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static byte[] readContentIntoByteArray(File file)
//	{
//	  FileInputStream fileInputStream = null;
//	  byte[] bFile = new byte[(int) file.length()];
//	  try
//	  {
//	     //convert file into array of bytes
//	     fileInputStream = new FileInputStream(file);
//	     fileInputStream.read(bFile);
//	     fileInputStream.close();
//	  }
//	  catch (Exception e)
//	  {
//	     e.printStackTrace();
//	  }
//	  return bFile;
//	}
	
	
	
	
	
	
	

}
