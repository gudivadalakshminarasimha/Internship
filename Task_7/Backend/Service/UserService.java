package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Dto.User;
import Repository.UserRespository;

@Service
public class UserService {
	 @Autowired
	    private UserRespository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public User register(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }

	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
}
