import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	static String [] word = new String[200000]; // �ܾ�
	static	String [] wordclass = new String[200000]; // ǰ��
	static String [] explain = new String[200000]; // ����
	static int n=0;// ����
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("$ ");
			String command = sc.nextLine();
			String [] split = command.split(" "); // ���Ⱑ ������ ���ܼ� ����
			if(split[0].equals("read"))  // split[0]�� read�� find ��� �ϼ�����. ���߿� read�϶�
				Read(split[1]);
			else if(split[0].equals("size"))
				System.out.println(n);
			else if(split[0].equals("exit"))
				break;
			else if(split[0].equals("find")) {
				int result=	Find(split[1]);

			}
			else {
				System.out.println("No No No");
				break;
			}


		}

	}
	static void Read(String FileName) {
		try {
			Scanner sc = new Scanner(new File(FileName));

			while(sc.hasNext()) {

				String str = sc.nextLine(); // �������� ������. ���⼭ ���� �ܾ�, ǰ��, �������� ��������

				int i= str.indexOf("("); // 
				int j= str.indexOf(")");
				if(i<0) continue;
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
	static int Find(String FindWord) {  // ���� Ž�� �ؾ��� 

		int count=0;
		for(int k=0;k<=n;k++) 
			if(word[k].equalsIgnoreCase(FindWord)) 


				return count;

	}
}
