package escapeRoom;

import java.util.*;

public class RoomService {

	/*
	 * 메서드 이름 : memberJoin 회원가입 매개변수 : List<RoomDTO> memberList 리턴 : memberList
	 */
	List<RoomDTO> memberJoin(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		int memberNum = memberList.size() + 1;

		RoomDTO r = new RoomDTO(id, password, "😀그냥회원😀", memberNum, 1000);
		memberList.add(r);
		System.out.println(id + "님 가입을 축하드립니다! 가입기념으로 1000원 지급됐습니다.");

		return memberList;
	}

	/*
	 * 메서드 이름 : memberView 회원정보조회 매개변수 : List<RoomDTO> memberList 리턴 : void
	 */

	void memberView(List<RoomDTO> memberList) {

		for (RoomDTO r : memberList) {
			System.out.println(r.toString());
		}
	}

	/*
	 * 메서드 이름 : LoginCheck 로그인체크 매개변수 : List<RoomDTO> memberList 리턴 : int
	 */

	int LoginCheck(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);

		int loginNum = -1;

		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();

		RoomDTO m = null;
		for (int i = 0; i < memberList.size(); i++) {
			m = memberList.get(i);
			if (id.equals(m.getId()) && password.equals(m.getPassword())) {
				loginNum = i;
			}
		}
		return loginNum;
	}

	List<RoomDTO> store(List<RoomDTO> memberList) {

		int num = LoginCheck(memberList);
		if (num >= 0) {
			RoomDTO m = memberList.get(num);
			System.out.println("상점에서는 당신의 랭크를 살 수 있습니다. 물건을 고르고 번호를 입력하세요.");
			System.out
					.println("1. 🛕💰부자회원🛕💰(90만원) 2. 거지회원🥺(10원) 3. 👥빚쟁이 회원👥 (100만원) 4. 🐛벌레회원🐛(0원에 모십니다.) 5.종료");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			switch (input) {
			case 1:
				if (m.getMoney() >= 900000) {
					System.out.println("부자회원이 되셨습니다!");
					m.setMemberRank("🛕💰부자회원🛕💰");
					m.setMoney(m.getMoney() - 900000);
					System.out.println(m);
				} else {
					System.out.println("돈이 부족합니다.");
				}
				break;
			case 2:
				if (m.getMoney() >= 10) {
					System.out.println("거지회원이 되셨습니다!");
					m.setMemberRank("거지회원🥺");
					m.setMoney(m.getMoney() - 10);
					System.out.println(m);
				} else {
					System.out.println("돈이 부족합니다.");
				}
				break;
			case 3:
				if (m.getMoney() <= -1000000) {
					System.out.println("빚쟁이회원이 되셨습니다!");
					m.setMemberRank("👥빚쟁이 회원👥");
					m.setMoney(m.getMoney() + 1000000);
					System.out.println(m);
				} else {
					System.out.println("당신 지갑엔 돈이 너무 많습니다.");
				}
				break;
			case 4:
				if (m.getMoney() >= 0) {
					System.out.println("벌레회원이 되셨습니다!");
					m.setMemberRank("🐛벌레회원🐛");
					System.out.println(m);
				} else {
					System.out.println("빚이 있어 살 수 없습니다.");
				}
				break;
			case 5:
				System.out.println("상점을 나갑니다.");
				break;

			}

		} else {
			System.out.println("로그인 실패");
		}

		return memberList;
	}

	/*
	 * 메서드 이름 : honoraryMember 명예의 전당 매개변수 : List<RoomDTO> memberList 리턴 :
	 * memberList
	 */
	void honoraryMember(List<RoomDTO> memberList) {
		RoomDTO m = null;
		for (int i = 0; i < memberList.size(); i++) {
			m = memberList.get(i);
			if (m.getMemberRank().equals("🥰🤸‍♀️✨🎖♥명예회원🥰🤸‍♀️✨🎖♥")) {
				System.out.println("🥰🤸‍♀️✨🎖♥위대하신 " + m.getId() + "님!🥰🤸‍♀️✨🎖♥");
			}
		}
	}
}