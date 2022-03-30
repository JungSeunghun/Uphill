package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DogDAO;
import vo.Dog;

public class DogRegistService {

	public boolean registDog(Dog dog) {
		boolean isRegistSuccess = false; // 지역변수 초기화

		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection connection = getConnection();
		
		// 2. 싱글톤 패턴으로 DogDao객체 생성
		DogDAO dogDAO = DogDAO.getInstance();
				
		// 3. DB작업에 사용될 Connection객체를 DogDAO의 멤버변수에  전달하여 DB연결하여 작업하도록 서비스 해줌
		dogDAO.setConnection(connection);
		
		/** DogDAO의 해당 메서드를 호출하여 처리 **/
		int insertCount = dogDAO.insertDog(dog); // 새로운 개 상품의 insert 성공하면 
		
		/** 
		 * (insert,update,delete) 성공하면 commit, 실패하면 rollback
		 * (select)제외 
		 */
		if(insertCount > 0) {
			isRegistSuccess = true;
			commit(connection);
		} else {
			rollback(connection);
		}
		
		// 4. r객체
		close(connection);
		
		return isRegistSuccess;
	}

}
