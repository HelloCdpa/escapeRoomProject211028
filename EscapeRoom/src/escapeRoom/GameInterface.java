package escapeRoom;

import java.util.List;

public interface GameInterface {

	//인터페이스 : 설계도 작성
	List<RoomDTO> login(List<RoomDTO> memberList);
	List<RoomDTO> stage1(List<RoomDTO> memberList);
	List<RoomDTO> stage2(List<RoomDTO> memberList);
	List<RoomDTO> bonusStage(List<RoomDTO> memberList);
	List<RoomDTO> stage3(List<RoomDTO> memberList);
	List<RoomDTO> stage4(List<RoomDTO> memberList);
	
}
