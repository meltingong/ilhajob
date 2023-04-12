package com.itwill.ilhajob.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.entity.Review;
import com.itwill.ilhajob.user.entity.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	//findBy+entity의 컬럼이름 으로 찾아줌
	List<Review> findByUser(String userEmail);
	
	//위 메소드 안되면 -> 아래꺼사용
	//List<Review> findByUser(User user);
	
	//Optional이 필요한경우
	//Optional<List<Review>> findByUser(String userEmail);
	
	List<Review> findByCorp(String corpLoginId);
	
		//위 메소드 안되면 -> 아래꺼사용
		//List<Review> findByCorp(Corp corp);
	
	//Optional<List<Review>> findByCorp(String corpLoginId);
 }
/* <<ServiceImpl에서 작성이 필요한 부분>>
 * Optional<List<Person>> optionalPersons = personRepository.findByFirstName("John");
 
if (optionalPersons.isPresent()) {
List<Person> persons = optionalPersons.get();
// 결과를 처리하는 코드 작성
} else {
// 결과가 없는 경우 처리하는 코드 작성
}
*/