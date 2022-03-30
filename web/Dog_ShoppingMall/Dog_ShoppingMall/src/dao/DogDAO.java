package dao;

import static db.JdbcUtil.*; // static : 모든 메서드들을 미리 메모리에 올림

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Dog;

public class DogDAO {
	// 멤버 변수(전역 변수 : 전체 메서드에서 사용 가능)
	private static DogDAO instance = null;
	private Connection connection;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	/** 
	 * 싱글톤 패턴 : DogDAO객체 단 1개만 생성
	 * 이유? : 외부 클래스에서 "처음 생성된 DogDAO객체를 공유해서 사용하도록 하기 위해" 
	 */
	
	// 1. 생성자는 무조건 private : 외부 클래스에서 생성자를 호출 불가하여 직접적으로 객체 생성 불가능
	private DogDAO() {}
	
	
	// 2. static 이유? 객체 생성하기 전에 이미 메모리에 올라간 getInstance()메서드를 통해서만 
	//                DogDAO객체를 1개만 만들수 있도록 하기 위해서
	public static DogDAO getInstance() {
		if(instance == null) { // instance가 null이면
			instance = new DogDAO(); // instance 생성
		}
		
		return instance; // 기존 instance의 주소를 리턴
	}
	
	/**************************************************************************/
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	// 1. 모든 개 상품 정보를 조회하여 ArrayList<Dog>객체 반환
	public List<Dog> selectDogList() {
		List<Dog> dogList = null;
		
		String sql = "select * from dog";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dogList = new ArrayList<Dog>();
				
				do {
					int id = resultSet.getInt("id");
					String kind = resultSet.getString("kind");
					int price = resultSet.getInt("price");
					String image = resultSet.getString("image");
					String country = resultSet.getString("country");
					int height = resultSet.getInt("height");
					int weight = resultSet.getInt("weight");
					String content = resultSet.getString("content");
					int readcount = resultSet.getInt("readcount");
					
					Dog dog = new Dog(id, kind, price, image, country, height, weight, content, readcount);
				
					dogList.add(dog);
				} while(resultSet.next());
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("selectDogList 에러 : " + e); // e : 예외종류 + 예외메세지
		} finally {
			// JdbcUtil.close(resultSet);
			// JdbcUtil.close(preparedStatement);
			close(resultSet);
			close(preparedStatement);
		}
		
		
		return dogList;
	}

	// id로 특정 개 상품을 찾아 조회수 1증가
	public int updateReadCount(int id) {
		int updateCount = 0; // 지역변수는 초기화
		String sql = "update dog set readcount = readcount + 1 where id = " + id;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			updateCount = preparedStatement.executeUpdate(); // update성공하면 1리턴받음
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("updateReadCount 에러 : " + e); // e : 예외종류 + 예외메세지
		} finally {
			// close(resultSet);
			close(preparedStatement);
		}
				
		return updateCount;
	}
	
	// id로 개상품을 조회한 정보를 Dog객체로 반환
	public Dog selectDog(int id) {
		Dog dog = null;
		
		String sql = "select * from dog where id = " + id;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int dog_id = resultSet.getInt("id");
				String kind = resultSet.getString("kind");
				int price = resultSet.getInt("price");
				String image = resultSet.getString("image");
				String country = resultSet.getString("country");
				int height = resultSet.getInt("height");
				int weight = resultSet.getInt("weight");
				String content = resultSet.getString("content");
				int readcount = resultSet.getInt("readcount");
				
				dog = new Dog(dog_id, kind, price, image, country, height, weight, content, readcount);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("selectDog 에러 : " + e); // e : 예외종류 + 예외메세지
		} finally {
			// JdbcUtil.close(resultSet);
			// JdbcUtil.close(preparedStatement);
			close(resultSet);
			close(preparedStatement);
		}
		
		return dog;
	}

	// 새로운 개 상품 정보를 dog를 테이블에 추가 insert
	public int insertDog(Dog dog) {
		int insertCount = 0; // 지역변수는 초기화
		String sql = "insert into dog values(dog_seq.nextval,?,?,?,?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dog.getKind());
			preparedStatement.setInt(2, dog.getPrice());
			preparedStatement.setString(3, dog.getImage());
			preparedStatement.setString(4, dog.getCountry());
			preparedStatement.setInt(5, dog.getHeight());
			preparedStatement.setInt(6, dog.getWeight());
			preparedStatement.setString(7, dog.getContent());
			preparedStatement.setInt(8, dog.getReadcount());
			
			insertCount = preparedStatement.executeUpdate(); // update성공하면 1리턴받음
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("insertDog 에러 : " + e); // e : 예외종류 + 예외메세지
		} finally {
			// close(resultSet);
			close(preparedStatement);
		}
				
		return insertCount;		
	}
	
	// 개 상품 정보를 delete
		public int deleteDog(Dog dog) {
			int deleteCount = 0; // 지역변수는 초기화
			String sql = "delete from dog where kind=" + dog.getKind();
			
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, dog.getKind());
				
				deleteCount = preparedStatement.executeUpdate(); // update성공하면 1리턴받음
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("deleteDog 에러 : " + e); // e : 예외종류 + 예외메세지
			} finally {
				// close(resultSet);
				close(preparedStatement);
			}
					
			return deleteCount;		
		}
	
}
