package escapeRoom;

import java.util.*; 
import java.io.*;

public class RoomService implements RoomInterface {

	@Override
	public List<RoomDTO> memberJoin(List<RoomDTO> memberList) {

		Scanner scan = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		int memberNum = memberList.size() + 1;

		RoomDTO r = new RoomDTO(id, password, "😀그냥회원😀", memberNum, 1000);
		memberList.add(r);
		System.out.println(id + "님 가입을 축하드립니다! 가입기념으로 1000원 지급됐습니다.");
		System.out.println("팁 💡 : 이 게임에서는 빚도 재산입니다. 빚을 져야만 살 수 있는 물건이 있습니다."
				+ "게임 후에 5번 상점에 가셔서 구매 가능한 회원등급을 구경하세요!");

		return memberList;

	}

	@Override
	public void memberView(List<RoomDTO> memberList) {

		for (RoomDTO r : memberList) {
			System.out.println(r.toString());
		}

	}

	@Override
	public int LoginCheck(List<RoomDTO> memberList) {

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

	@Override
	public List<RoomDTO> store(List<RoomDTO> memberList) {
		int num = LoginCheck(memberList);
		if (num >= 0) {
			RoomDTO m = memberList.get(num);
			System.out.println("상점에서는 당신의 등급을 살 수 있습니다. 물건을 고르고 번호를 입력하세요.");
			System.out
					.println("1. 🛕💰부자회원🛕💰(90만원) 2. 거지회원🥺(10원) 3. 👥빚쟁이 회원👥 (빚100만원) 4. 🐛벌레회원🐛(0원에 모십니다.) 5.종료");
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

	@Override
	public void honoraryMember(List<RoomDTO> memberList) {
		
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberRank().equals("🥰🤸‍♀️✨🎖♥명예회원🥰🤸‍♀️✨🎖♥")) {
				System.out.println("최근 명예를 얻은 회원 : ");
				System.out.println("🥰🤸‍♀️✨🎖♥위대하신 " + memberList.get(i).getId() + "님!🥰🤸‍♀️✨🎖♥");
			}
		}
		
		System.out.println("🎊🎊🎊🎊==========+=============🎊🎊🎊🎊");
		System.out.println("           역대 명예 회원                ");
		System.out.println("   이 게임은 당신들을 영원히 기억할 것 입니다.   ");
		System.out.println("🎊🎊🎊🎊==========+=============🎊🎊🎊🎊");
		 try{
		        //파일 객체 생성
		        File file = new File("D:\\development_Phl\\source\\escapeRoom\\EscapeRoom.text");
		         //입력 스트림 생성
		         FileReader file_reader = new FileReader(file);
		         int cur = 0;
		         while((cur = file_reader.read()) != -1){
		            System.out.print((char)cur);
		         }
		         file_reader.close();
		        }catch (FileNotFoundException e) {
		            e.getStackTrace();
		        }catch(IOException e){
		            e.getStackTrace();
		        }
		 
	}

	@Override
	public List<RoomDTO> escapeGame(List<RoomDTO> memberList) {
		GameService g = new GameService();
		System.out.println("숫자를 입력하는 란에 다른 값을 넣으시면 게임이 초기화 됩니다.");
		g.login(memberList);
		g.stage1(memberList);
		g.stage2(memberList);
		g.stage3(memberList);
		g.stage4(memberList);
			
		return memberList;
	}
		

}
