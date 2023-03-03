package inflator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		
//		if(args.length == 0) {
//			System.exit(1);
//		}
//		
//		File originalfile = new File(args[0]);
		
		String path = "F:\\midia\\Trollface.png";
		
		int b = 1024;
		long v = 1024 * 1;
		
		byte[] result = new byte[b * 1024];
		System.arraycopy("0".getBytes(), 0, result, 100 - "0".length(), "0".length());

		File file = new File(path);
	    
	    try (
	    	      InputStream inputStream = new FileInputStream(file);
	    	      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

	    	      OutputStream outputStream = new FileOutputStream("result.png");
	    	  ) {
	    	    byte[] buffer = new byte[4 * 1024];
	    	    int read;
	    	    while ((read = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
	    	    	outputStream.write(buffer, 0, read);
	    	    }
	    	    for(long i = 0; i<v;i++ ) {
	    	    	outputStream.write(result);
	    	    }
	    	  }
	    
		System.out.println("DONE");	
		System.exit(0);
		
		System.out.println("DONE");	
		System.exit(0);
		
	}

}
