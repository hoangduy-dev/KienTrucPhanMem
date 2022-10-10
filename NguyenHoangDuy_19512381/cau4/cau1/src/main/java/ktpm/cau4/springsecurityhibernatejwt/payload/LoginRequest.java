package ktpm.cau4.springsecurityhibernatejwt.payload;

import lombok.Data;

@Data
public class LoginRequest {
 
    private String username;

 
    private String password;
}
