package escapeRoom;

import java.util.List;
import java.util.Scanner;

public class GameService2 {
	int num;
	String question; 
	String choose1;
	String choose2;
	String choose3;
	String f1;
	String f2;
	String t;
	int succesMoney;
	int failMoney;
	
	
	
	public List<RoomDTO> stage3(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);
		RoomDTO m = null;
		
		m = memberList.get(num);
		//run final
		boolean runF = true;

		while (runF) {

			boolean run = true;

			while (run) {
				System.out.println("");
				System.out.println(
						"Q." + m.getId() + question);

				System.out.println(choose1);
				System.out.println(choose2);
				System.out.println(choose3);
				
				System.out.print(">μ ν : ");

				int answer = scan.nextInt();
				if (answer == 1) {
					System.out.println("\n-------π‘π»π»π»π‘π»π»π»--------------\n");
					System.out.println(f1);
					System.out.println("\n-------π‘π»π»π»π‘π»π»π»--------------\n");
					m.setMemberRank("μμ¬μ΄μλνμπ»");
					m.setMoney(m.getMoney() - failMoney);
					System.out.println("λΉμ μ μ λ³΄ : " + m);
					run = false;

				} else if (answer == 3) {
					System.out.println("\n-------π‘π»π»π»π‘π»π»π»--------------\n");
					System.out.println(f2);
					System.out.println("\n-------π‘π»π»π»π‘π»π»π»--------------");
					run = false;

				} else if (answer == 2) {
					//μ±κ³΅μ 
					System.out.println("");
					m.setMoney(m.getMoney() + succesMoney);
					System.out.println("ππππβββββββββββββββββββββββββββββββββββββββββββββββββββ\n");
					System.out.println(t);
					System.out.println(succesMoney + "λ§μ νλ, λμ μ§κ°μ λ€μ΄ μλ λ : " + m.getMoney() + "μ");
					System.out.println("\nππππβββββββββββββββββββββββββββββββββββββββββββββββββββ");
					runF = false;
					run = false;
				}
			}

		}
		return memberList;
	}

}
