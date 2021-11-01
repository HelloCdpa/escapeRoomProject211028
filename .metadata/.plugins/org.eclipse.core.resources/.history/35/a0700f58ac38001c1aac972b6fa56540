package escapeRoom1;

import java.util.*;

import escapeRoom.RoomDTO;
import escapeRoom.RoomService;

public class RoomMain0 {

	public static void main(String[] args) {
		
		int input;
		String a;
		Scanner scan = new Scanner(System.in);
		List<RoomDTO> memberList = new ArrayList<>();
		RoomService r = new RoomService();
		GameService0 g = new GameService0();
		
		System.out.println("엔터를 누르세요.");
		
		boolean run = true;
		while (run) {
			a = scan.nextLine();
			
			System.out.println("----------------------------🔒🔑🔒🔑-------------------------------------------");
			System.out.println("1.회원가입💋 | 2.회원정보조회 🔎 3.게임실행 🎮 | 4.명예회원의 전당 🏆 | 5.상점 💎 | 6.종료 ");
			System.out.println("----------------------------🔒🔑🔒🔑-------------------------------------------");
			System.out.print("선택> ");
			
			try {
			input = scan.nextInt();

			if (input == 1) {
				memberList = r.memberJoin(memberList);

			} else if (input == 2) {
				r.memberView(memberList);

			} else if (input == 3) {
				memberList = g.escapeGame(memberList);

			} else if (input == 4) {
				r.honoraryMember(memberList);

			} else if (input == 5) {
				memberList = r.store(memberList);
				
			
			} else if (input == 6) {
				System.out.println("종료");
				run = false;
			} else {
				System.out.println("다시 입력해주세요.");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하세요.");
			
			
		}
	}	
		
	}
}


