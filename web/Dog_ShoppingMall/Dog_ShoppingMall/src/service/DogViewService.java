package service;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import static db.JdbcUtil.*;

import dao.DogDAO;
import vo.Dog;

public class DogViewService {
	// 멤버변수
	
	// 기본 생성자
		
	// 메서드
	
	// 해당 개 상품의 '조회수 1증가' -> 'id로 조회한 개 상품 정보를 Dog객체로 반환'
	public Dog getDogView(int id) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection connection = getConnection();
		
		// 2. 싱글톤 패턴으로 DogDao객체 생성
		DogDAO dogDAO = DogDAO.getInstance();
				
		// 3. DB작업에 사용될 Connection객체를 DogDAO의 멤버변수에  전달하여 DB연결하여 작업하도록 서비스 해줌
		dogDAO.setConnection(connection);
		
		/** DogDAO의 해당 메서드를 호출하여 처리 **/
		int updateCount = dogDAO.updateReadCount(id);
		
		/** 
		 * (insert,update,delete) 성공하면 commit, 실패하면 rollback
		 * (select)제외 
		 */
		if(updateCount > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		// 'id로 조회한 개 상품 정보를 Dog객체로 변환'
		Dog dog = dogDAO.selectDog(id);
		
		// 4. r객체
		close(connection);
		
		return dog;
	}
	
}
