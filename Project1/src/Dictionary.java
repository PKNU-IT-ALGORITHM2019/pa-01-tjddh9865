import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	static String [] word = new String[200000]; // �ܾ�
	static	String [] wordclass = new String[200000]; // ǰ��
	static String [] explain = new String[200000]; // ����
	
	public static void main(String[] args) {

	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("$ ");
			String command = sc.nextLine();
			String [] split = command.split(" "); // ���Ⱑ ������ ���ܼ� ����
			if(split[0].equals("read")) {  // split[0]�� read�� find ��� �ϼ�����. ���߿� read�϶�
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
			
			String str = sc.nextLine(); // �������� ������. ���⼭ ���� �ܾ�, ǰ��, �������� ��������
			
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
