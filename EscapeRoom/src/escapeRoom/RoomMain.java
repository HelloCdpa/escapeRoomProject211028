package escapeRoom;

import java.util.*;

public class RoomMain {

	public static void main(String[] args) {
		
		int input;
		
		Scanner scan = new Scanner(System.in);
		List<RoomDTO> memberList = new ArrayList<>();
		RoomService r = new RoomService();
		
		System.out.println("엔터를 누르세요.");
		boolean run = true;
		while (run) {
			scan.nextLine();
			System.out.println("\n----------------------------🔒🔑🔒🔑-------------------------------------------");
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
				memberList = r.escapeGame(memberList);

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
			
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("회원가입 완료 후 게임시작을 해야 합니다.");
		}
	}	
		
	}
}


