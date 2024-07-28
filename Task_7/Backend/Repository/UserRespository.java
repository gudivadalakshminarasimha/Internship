package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Dto.User;

public interface UserRespository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
}
