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
				
				System.out.print(">선택 : ");

				int answer = scan.nextInt();
				if (answer == 1) {
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------\n");
					System.out.println(f1);
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------\n");
					m.setMemberRank("양심이없는회원👻");
					m.setMoney(m.getMoney() - failMoney);
					System.out.println("당신의 정보 : " + m);
					run = false;

				} else if (answer == 3) {
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------\n");
					System.out.println(f2);
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------");
					run = false;

				} else if (answer == 2) {
					//성공시 
					System.out.println("");
					m.setMoney(m.getMoney() + succesMoney);
					System.out.println("🎊🎊🎊🎊☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆\n");
					System.out.println(t);
					System.out.println(succesMoney + "만원 획득, 나의 지갑에 들어 있는 돈 : " + m.getMoney() + "원");
					System.out.println("\n🎊🎊🎊🎊☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					runF = false;
					run = false;
				}
			}

		}
		return memberList;
	}

}
