package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.User;
import Service.UserService;
import until.AuthRequest;
import until.JwtUtil;

@RestController
public class USerController {
	  @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserService userService;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private UserDetailsService userDetailsService;

	    @PostMapping("/register")
	    public User register(@RequestBody User user) {
	        return userService.register(user);
	    }

	    @PostMapping("/authenticate")
	    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	            );
	        } catch (Exception e) {
	            throw new Exception("Invalid username or password");
	        }

	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
	        return jwtUtil.generateToken(userDetails.getUsername());
	    }
}
