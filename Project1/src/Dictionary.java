import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	static String [] word = new String[200000]; // 단어
	static	String [] wordclass = new String[200000]; // 품사
	static String [] explain = new String[200000]; // 설명
	
	public static void main(String[] args) {

	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("$ ");
			String command = sc.nextLine();
			String [] split = command.split(" "); // 띄어쓰기가 나오면 끊겨서 저장
			if(split[0].equals("read")) {  // split[0]은 read나 find 등등 일수있음. 그중에 read일때
				Read(split[1]);	
			}	
			sc.close();
		}
	}
	static void Read(String FileName) {
		int n=0;
		try {
			Scanner sc = new Scanner(new File(FileName));
			
		while(sc.hasNext()) {
			
			String str = sc.nextLine(); // 라인으로 끊어줌. 여기서 이제 단어, 품사, 설명으로 나눌거임
			
			int i= str.indexOf("("); // 
			int j= str.indexOf(")");
			
			word[n]=str.substring(0, i-1);
			wordclass[n]=str.substring(i,  j+1);
			explain[n] = str.substring(j+1);
			n++;
			
		}
		sc.close(); 
			
		} 

		catch (FileNotFoundException e) {
			System.out.println("Not Found");
		}	
	}
}
