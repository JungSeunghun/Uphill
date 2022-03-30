package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import dao.DogDAO;
import vo.Dog;

public class DogListService {
	// 멤버변수
	
	// 기본 생성자
	
	// 메서드
	public List<Dog> getDogList() {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection connection = getConnection();
		
		// 2. 싱글톤 패턴으로 DogDao객체 생성
		DogDAO dogDAO = DogDAO.getInstance();
				
		// 3. DB작업에 사용될 Connection객체를 DogDAO의 멤버변수에  전달하여 DB연결하여 작업하도록 서비스 해줌
		dogDAO.setConnection(connection);
		
		/** DogDAO의 해당 메서드를 호출하여 처리 **/
		List<Dog> dogList = dogDAO.selectDogList();
		
		/** 
		 * (insert,update,delete) 성공하면 commit 실패하면 rollback
		 * (select)제외 
		 */
		
		// 4. 해제
		close(connection); // Connection객체 해제
		
		return dogList;
	}
}
