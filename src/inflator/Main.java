package inflator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

	public static void main(String[] args) throws IOException {
		
		if(args.length == 0) {
			System.exit(1);
		}
		
		File originalfile = new File(args[0]);
		
//		File originalfile = new File("F:\\papo_de_rato_1.zip");

		long v = Long.parseLong(args[1]);
		
//		long v = 758128745;
		
		byte[] bytes = Files.readAllBytes(originalfile.toPath());

		int f = (int) (v - originalfile.length());
		if (f < 0) {
			System.out.println("nah, the file is bigger :\\");
			System.exit(1);
		}
		
		String str = "0";
		byte[] byteArr = str.getBytes();
		
		byte[] finalArray = new byte[bytes.length + f];
		System.arraycopy(bytes, 0, finalArray, 0, bytes.length);
		
		for (int i = 0; i < f; i++) {
			System.arraycopy(byteArr, 0, finalArray, bytes.length + i, byteArr.length);		
		}

		Files.write(originalfile.toPath(), finalArray);
		
		System.out.println("DONE");	
		System.exit(0);
		
	}

}
