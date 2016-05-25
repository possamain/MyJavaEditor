import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
public class Cmd {
	static Robot r;
	public static void main(String[] args){
		try {
			Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","start"});
			r=new Robot();
			r.setAutoDelay(5);
			String s="cd C:\\Users\\Andrea\\Desktop";
			for(int i=0;i<s.length();i++)
				pressKey(Character.toString(s.charAt(i)));
			pressKey("ENTER");
			s="cls";
			for(int i=0;i<s.length();i++)
				pressKey(Character.toString(s.charAt(i)));
			pressKey("ENTER");
			s="javac ciao.java";
			r.delay(100);
			for(int i=0;i<s.length();i++)
				pressKey(Character.toString(s.charAt(i)));
			pressKey("ENTER");
			r.delay(1000);
			s="java ciao";
			for(int i=0;i<s.length();i++)
				pressKey(Character.toString(s.charAt(i)));
			pressKey("ENTER");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void pressKey(String s){
		//all keys
		switch (s){
		case " ":
			r.keyPress(KeyEvent.VK_SPACE);
			break;
		case "!":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_1);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_1);
			break;
		case "\"":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_2);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_2);
			break;
		case "#":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD3);
			r.keyPress(KeyEvent.VK_NUMPAD5);
			r.keyRelease(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_NUMPAD5);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "$":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_4);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_4);
			break;
		case "%":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_5);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_5);
			break;
		case "&":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_6);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_6);
		case "'":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD3);
			r.keyPress(KeyEvent.VK_NUMPAD9);
			r.keyRelease(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_NUMPAD9);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "(":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_8);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_8);
			break;
		case ")":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_9);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_9);
			break;
		case "*":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_PLUS);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_PLUS);
		case "+":
			r.keyPress(KeyEvent.VK_PLUS);
			break;
		case ",":
			r.keyPress(KeyEvent.VK_COMMA);
			break;
		case "-":
			r.keyPress(KeyEvent.VK_MINUS);
			break;
		case ".":
			r.keyPress(KeyEvent.VK_PERIOD);
			break;
		case "/":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_7);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_7);
			break;
		case "0":
			r.keyPress(KeyEvent.VK_0);
			break;
		case "1":
			r.keyPress(KeyEvent.VK_1);
			break;
		case "2":
			r.keyPress(KeyEvent.VK_2);
			break;
		case "3":
			r.keyPress(KeyEvent.VK_3);
			break;
		case "4":
			r.keyPress(KeyEvent.VK_4);
			break;
		case "5":
			r.keyPress(KeyEvent.VK_5);
			break;
		case "6":
			r.keyPress(KeyEvent.VK_6);
			break;
		case "7":
			r.keyPress(KeyEvent.VK_7);
			break;
		case "8":
			r.keyPress(KeyEvent.VK_8);
			break;
		case "9":
			r.keyPress(KeyEvent.VK_9);
			break;
		case ":":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_PERIOD);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_PERIOD);
			break;
		case ";":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_COMMA);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_COMMA);
			break;
		case "<":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD6);
			r.keyPress(KeyEvent.VK_NUMPAD0);
			r.keyRelease(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_NUMPAD0);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "=":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_0);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_0);
			break;
		case ">":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD6);
			r.keyPress(KeyEvent.VK_NUMPAD2);
			r.keyRelease(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_NUMPAD2);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "?":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD6);
			r.keyPress(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "@":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD6);
			r.keyPress(KeyEvent.VK_NUMPAD4);
			r.keyRelease(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_NUMPAD4);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "a":
			r.keyPress(KeyEvent.VK_A);
			break;
		case "b":
			r.keyPress(KeyEvent.VK_B);
			break;
		case "c":
			r.keyPress(KeyEvent.VK_C);
			break;
		case "d":
			r.keyPress(KeyEvent.VK_D);
			break;
		case "e":
			r.keyPress(KeyEvent.VK_E);
			break;
		case "f":
			r.keyPress(KeyEvent.VK_F);
			break;
		case "g":
			r.keyPress(KeyEvent.VK_G);
			break;
		case "h":
			r.keyPress(KeyEvent.VK_H);
			break;
		case "i":
			r.keyPress(KeyEvent.VK_I);
			break;
		case "j":
			r.keyPress(KeyEvent.VK_J);
			break;
		case "k":
			r.keyPress(KeyEvent.VK_K);
			break;
		case "l":
			r.keyPress(KeyEvent.VK_L);
			break;
		case "m":
			r.keyPress(KeyEvent.VK_M);
			break;
		case "n":
			r.keyPress(KeyEvent.VK_N);
			break;
		case "o":
			r.keyPress(KeyEvent.VK_O);
			break;
		case "p":
			r.keyPress(KeyEvent.VK_P);
			break;
		case "q":
			r.keyPress(KeyEvent.VK_Q);
			break;
		case "r":
			r.keyPress(KeyEvent.VK_R);
			break;
		case "s":
			r.keyPress(KeyEvent.VK_S);
			break;
		case "t":
			r.keyPress(KeyEvent.VK_T);
			break;
		case "u":
			r.keyPress(KeyEvent.VK_U);
			break;
		case "v":
			r.keyPress(KeyEvent.VK_V);
			break;
		case "w":
			r.keyPress(KeyEvent.VK_W);
			break;
		case "x":
			r.keyPress(KeyEvent.VK_X);
			break;
		case "y":
			r.keyPress(KeyEvent.VK_Y);
			break;
		case "z":
			r.keyPress(KeyEvent.VK_Z);
			break;
		case "[": 
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD9);
			r.keyPress(KeyEvent.VK_NUMPAD1);
			r.keyRelease(KeyEvent.VK_NUMPAD9);
			r.keyRelease(KeyEvent.VK_NUMPAD1);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "\\":
			r.keyPress(KeyEvent.VK_BACK_SLASH);
			break;
		case "]":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD9);
			r.keyPress(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_NUMPAD9);
			r.keyRelease(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "^":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD9);
			r.keyPress(KeyEvent.VK_NUMPAD4);
			r.keyRelease(KeyEvent.VK_NUMPAD9);
			r.keyRelease(KeyEvent.VK_NUMPAD4);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "_": 
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_MINUS);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_MINUS);
			break;
		case "`":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD9);
			r.keyPress(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_NUMPAD9);
			r.keyRelease(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "A":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_A);
			break;
		case "B":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_B);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_B);
			break;
		case "C":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_C);
			break;
		case "D":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_D);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_D);
			break;
		case "E":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_E);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_E);
			break;
		case "F":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_F);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_F);
			break;
		case "G":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_G);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_G);
			break;
		case "H":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_H);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_H);
			break;
		case "I":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_I);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_I);
			break;
		case "J":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_J);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_J);
			break;
		case "K":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_K);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_K);
			break;
		case "L":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_L);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_L);
			break;
		case "M":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_M);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_M);
			break;
		case "N":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_N);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_N);
			break;
		case "O":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_O);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_O);
			break;
		case "P":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_P);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_P);
			break;
		case "Q":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_Q);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_Q);
			break;
		case "R":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_R);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_R);
			break;
		case "S":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_S);
			break;
		case "T":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_T);
			break;
		case "U":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_U);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_U);
			break;
		case "V":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_V);
			break;
		case "W":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_W);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_W);
			break;
		case "X":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_X);
			break;
		case "Y":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_Y);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_Y);
			break;
		case "Z":
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_Z);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_Z);
			break;
		case "{":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD1);
			r.keyPress(KeyEvent.VK_NUMPAD2);
			r.keyPress(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_NUMPAD1);
			r.keyRelease(KeyEvent.VK_NUMPAD2);
			r.keyRelease(KeyEvent.VK_NUMPAD3);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "|":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD1);
			r.keyPress(KeyEvent.VK_NUMPAD2);
			r.keyPress(KeyEvent.VK_NUMPAD4);
			r.keyRelease(KeyEvent.VK_NUMPAD1);
			r.keyRelease(KeyEvent.VK_NUMPAD2);
			r.keyRelease(KeyEvent.VK_NUMPAD4);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "}":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD1);
			r.keyPress(KeyEvent.VK_NUMPAD2);
			r.keyPress(KeyEvent.VK_NUMPAD5);
			r.keyRelease(KeyEvent.VK_NUMPAD1);
			r.keyRelease(KeyEvent.VK_NUMPAD2);
			r.keyRelease(KeyEvent.VK_NUMPAD5);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "~":
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_NUMPAD1);
			r.keyPress(KeyEvent.VK_NUMPAD2);
			r.keyPress(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_NUMPAD1);
			r.keyRelease(KeyEvent.VK_NUMPAD2);
			r.keyRelease(KeyEvent.VK_NUMPAD6);
			r.keyRelease(KeyEvent.VK_ALT);
			break;
		case "ENTER":
			r.keyPress(KeyEvent.VK_ENTER);
			break;
		case "TAB":
			r.keyPress(KeyEvent.VK_TAB);
			break;
		}
	}
}