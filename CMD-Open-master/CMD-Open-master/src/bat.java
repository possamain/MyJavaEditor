import java.io.FileWriter;
import java.io.IOException;
public class bat {
	public static void main(String[] args) {
		try {
			FileWriter fw=new FileWriter("start.bat");
			fw.write("@echo Hello world!\npause");
			fw.close();
			Runtime.getRuntime().exec("cmd /c start start.bat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}