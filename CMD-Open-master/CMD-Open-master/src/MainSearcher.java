import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MainSearcher {
	public static void main(String args[]){
		//File f=new File("C:\\Users\\Andrea\\git\\Memory\\src\\App.java"); //file da cui si avvia il comando
		File f=new File("C:\\Users\\Andrea\\workspace\\KeyboardApp\\src\\KeyboardApp.java");
		File f2=f.getParentFile();
		File[] list=f2.listFiles();
		int i=0;
		boolean t=false;
		String s="s";
		while(i<list.length && !t){
			s=search(list[i]);
			if(s!="")
				t=true;
			System.out.println(t+" "+list[i]);
			i++;
		}
		System.out.println(s);
	}
	public static String search(File f){
		Scanner s;
		try {
			s = new Scanner(f);
			while(s.hasNextLine()){
				if(s.nextLine().contains(" main(String"))
					return f.getAbsolutePath();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}
}