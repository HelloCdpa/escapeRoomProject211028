package escapeRoom;

import java.io.*;
import java.util.*;

public class GameService {
	int num;

	List<RoomDTO> login(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);
		RoomService r = new RoomService();
		RoomDTO m = null;
		this.num = r.LoginCheck(memberList);

		if (num >= 0) {
			m = memberList.get(num);
			System.out.println("로그인 성공!");
			System.out.println("게임 시작 시 참가비 1000원이 차감됩니다.");
			System.out.println("");
			m.setMoney(m.getMoney() - 1000);

		} else {
			System.out.println("로그인 실패");
		}

		return memberList;

	}
	/*
	 * runF : run 을 true로 초기화 시켜서 스테이지를 다시 하도록 스테이지 클리어 시 runF = false;로! 
	 * run : 틀려도 스테이지를 반복하도록
	 */

	List<RoomDTO> stage1(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);
		RoomDTO m = null;
		m = memberList.get(num);
		
		boolean runF = true;
		while (runF) {

			boolean run = true;

			while (run) {

				System.out.println("\n\n😱");
				System.out.println("어느날 눈을 떠 보니 " + m.getId() + "님은 지금 문이 두개인 방에 갇혀있습니다.🔒");
				System.out.println("Q. 왼쪽문에는 지석이의 방 오른쪽문에는 경진이의 방이라고 쓰여진 종이가 붙여져있습니다. 어디로 갈까요?");
				System.out.println("\n 1. 지석이 방| 2. 경진이 방");
				System.out.print("선택 : ");
				int num1 = scan.nextInt();

				if (num1 == 1) {

					System.out.println("");
					System.out.println("☆★☆★☆★☆★☆🎉🎉🎉🎉★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n");
					System.out.println("지석이의 방에 성공적으로 침입했습니다!🙌만세!");
					System.out.println("\n☆★☆★☆★☆★☆🎉🎉🎉🎉★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("\n\n철컥! 🔒 들어가자마자 들어왔던 문이 잠겼습니다.🙉");
					System.out.println("");
					System.out.println("이 방에는 하나의 숫자 자물쇠로 잠긴 문이 있고\r\n"
							+ "주위에는 쪽지와 📃 케이크🍰가 올려져 있는 책상, 열쇠로 여는 잠겨진 서랍🗄이 있습니다.\r\n"
							+ m.getId() + "님은 책상 앞으로 가서 쪽지를 먼저 펼쳐보았습니다.");
					System.out.println("");
					run = false;
					runF = false;

				} else if (num1 == 2) {
					System.out.println("\n-------------👻👻👻👻-----------------------\n");
					System.out.println("문을 열자마자 누군가가 서 있습니다.");
					System.out.println("파삭!");
					System.out.println("여자친구가 없어 화난 경진이가 당신을 부쉈습니다.");
					System.out.println("\n-------------👻👻👻👻-----------------------");
					m.setMemberRank("경진이를 너무 좋아하고 지석이를 싫어하는 회원");
					System.out.println("\n경진이에게 깽값 50000원을 뜯어냈습니다.");
					m.setMoney(m.getMoney() + 50000);
					System.out.println(m);
					run = false;
				} else {
					System.out.println("잘못 입력하셨습니다.");
					run = false;
				}

			}
		}

		return memberList;
	}

	List<RoomDTO> stage2(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);
		RoomDTO m = null;
		m = memberList.get(num);

		boolean runF = true;

		while (runF) {

			boolean run = true;
			while (run) {
				System.out.println("\nQ.쪽지에는 <오지석! 내가 만든 케이크 맛있게 먹어 - 너의 깐부가> 라고 적혀있습니다.\n 당신은 ?");
				System.out.println("\n1. 케이크를 먹는다. 2. 접시를 뒤집어 케이크를 납작하게 누른다.");
				System.out.print(">선택 : ");
				int num2 = scan.nextInt();

				if (num2 == 1) {

					System.out
							.println("\n🔩---------------------------------------☠☠☠☠☠☠--------------------------🔩\n");
					System.out.println("단백질을 사랑하는 형철이가 만든 프로틴 케이크를 먹어 단백질 과다섭취로 쓰러졌습니다.😒");
					System.out
							.println("\n🔩---------------------------------------☠☠☠☠☠☠--------------------------🔩\n");
					m.setMemberRank("단백질에 절여진 회원");
					System.out.println("당신의 정보 : "+m);
					run = false;

				} else if (num2 == 2) {

					System.out.println("");
					System.out.println("☆★☆★☆★☆🗝🗝🗝🗝🗝🗝☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆\n");
					System.out.println("케이크 안의 열쇠를 발견했습니다!");
					System.out.println("\n☆★☆★☆★☆🗝🗝🗝🗝🗝🗝☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					System.out.println("");
					run = false;
					runF = false;
				}
			}
		}

		return memberList;
	}

	List<RoomDTO> stage3(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);
		RoomDTO m = null;
		m = memberList.get(num);

		boolean runF = true;

		while (runF) {

			boolean run = true;

			while (run) {
				System.out.println("");
				System.out.println("Q." + m.getId() + "님은 열쇠로 잠겨진 서랍을 열었습니다.🔓\n\n 서랍 안에는 '지석이의 비상금'이라 적혀진 100만원💵이 들어있는 봉투✉가 있고,"
						+ " \n그 봉투에는 숫자자물쇠의 힌트💡가 적혀져 있습니다.\n");

				System.out.println("1. 100만원을 들고 비밀번호를 입력하러 간다.");
				System.out.println("2. 티 안나게 3만원만 들고 비밀번호를 입력하러 간다.");
				System.out.println("3. 100만원을 그냥 놔두고 비밀번호를 입력하러 간다.");
				System.out.print(">선택 : ");

				int num3 = scan.nextInt();
				if (num3 == 1) {
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------\n");
					System.out.println("당신은 너무 양심이 없어 받아들일 수 없습니다. \n당신의 지갑에서 100만원을 차감합니다.");
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------\n");
					m.setMemberRank("양심이없는회원👻");
					m.setMoney(m.getMoney() - 1000000);
					System.out.println("당신의 정보 : " + m);
					run = false;

				} else if (num3 == 3) {
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------\n");
					System.out.println(m.getId() + "님의 거짓말을 용서할 수 없습니다.");
					System.out.println("\n-------😡👻👻👻😡👻👻👻--------------");
					runF = false;

				} else if (num3 == 2) {

					System.out.println("");
					m.setMoney(m.getMoney() + 30000);
					System.out.println("🎊🎊🎊🎊☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆\n");
					System.out.println("3만원 획득, 나의 지갑에 들어 있는 돈 : " + m.getMoney() + "원");
					System.out.println("\n🎊🎊🎊🎊☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					runF = false;
					run = false;
				}
			}

	}
		return memberList;
	}
	
	
	List<RoomDTO> stage4(List<RoomDTO> memberList) {
		Scanner scan = new Scanner(System.in);
		RoomDTO m = null;
		m = memberList.get(num);

		boolean runF = true;

		while (runF) {

			boolean run = true;

			while (run) {
	
					System.out.println("");
					System.out.println("Q.드디어 방을 나갈 수 있을 것 같습니다! 숫자 네자리 비밀번호 문제를 푸세요!");
					System.out.println("지석이의 비상금 봉투에 적혀진 내용 : 네 자리 숫자는 내 이름의 성, 깐부가 준 음식의 글자 수, 아이스크림 xx콘\n");
					System.out.print("숫자 비밀번호 입력 : ");
					int num4 = scan.nextInt();

					if (num4 == 5499) {

						System.out.println("🎊🎊🎊🎊☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆\n");
						System.out.println("정답입니다!" + m.getId() + "님은 방을 탈출했습니다.");
						System.out.println("상금 97만원을 지급하고, 명예회원의 등급을 달아드릴게요^^*");
						m.setMoney(m.getMoney() + 970000);
						m.setMemberRank("🥰🤸‍♀️✨🎖♥명예회원🥰🤸‍♀️✨🎖♥");
				
						System.out.println("당신의 정보 : "+m);
						System.out.println("\n🎊🎊🎊🎊☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
						
						

						try {
						    OutputStream output = new FileOutputStream("D:\\development_Phl\\source\\escapeRoom\\EscapeRoom.text",true);
						    String str = "\n" + m.toString();
						    byte[] by= str.getBytes();
						    output.write(by);
								
						} catch (Exception e) {
					            e.getStackTrace();
						}
						
						
						runF = false;
						run = false;
						
					} else if (num4 == 5399) {
						System.out.println("☆✏🖌🖍-----------------------------------------\n");
						System.out.println("cake는 몇 글자 일까요? ㅎ-ㅎ 한 번 더 기회를 드립니다.");
						System.out.println("\n☆✏🖌🖍-----------------------------------------");
						System.out.print("숫자 비밀번호 입력 : ");
						num4 = scan.nextInt();
						System.out.println("-------------👻👻👻👻-----------------------\n");
						System.out.println("이미 지나간 기회는 돌아오지 않습니다. 다시 하세용ㅋ\n");
						System.out.println("갑자기 모기의 요정이" + m.getId() + "님의 지갑에서 돈을 훔쳐갔습니다.");
						System.out.println("\n-------------👻👻👻👻-----------------------");

						int mosquito = (int) (Math.random() * 100000) + 1;
						m.setMoney(m.getMoney() - mosquito);
						m.setMemberRank("피빨린 회원");
						System.out.println("당신의 정보 : "+m);
						System.out.println("");

						runF = false;
					} else {
						System.out.println("-------------👻👻👻👻-----------------------\n");
						System.out.println("땡떄떋ㄸ떄떄떄떄ㅒ떄ㄸ떄땡!!!!");
						m.setMemberRank("바보회원");
						System.out.println("당신의 정보 : "+m);
						System.out.println("\n-------------👻👻👻👻-----------------------");
						runF = false;
					}
			}

		}
			return memberList;
		}

}
