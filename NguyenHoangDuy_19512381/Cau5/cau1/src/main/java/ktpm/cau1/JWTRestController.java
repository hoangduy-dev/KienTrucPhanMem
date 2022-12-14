package ktpm.cau1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.loda.springsecurityhibernatejwt.jwt.JwtTokenProvider;
import me.loda.springsecurityhibernatejwt.payload.LoginRequest;
import me.loda.springsecurityhibernatejwt.payload.LoginResponse;
import me.loda.springsecurityhibernatejwt.payload.RandomStuff;
import springsecurityhibernatejwt.user.CustomUserDetails;
import springsecurityhibernatejwt.user.User;
import springsecurityhibernatejwt.user.UserRepository;

@RestController
@RequestMapping("/api")
public class JWTRestController {

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
//    @PostMapping("register")
//    public User register(@RequestBody User user) {
//    	
//    	return userRepository.save(user);
//    }

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // N???u kh??ng x???y ra exception t???c l?? th??ng tin h???p l???
        // Set th??ng tin authentication v??o Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Tr??? v??? jwt cho ng?????i d??ng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    // Api /api/random y??u c???u ph???i x??c th???c m???i c?? th??? request
    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT H???p l??? m???i c?? th??? th???y ???????c message n??y");
    }

}
