package in.chandan.dto;


public class AuthResponse {
    private String name;
    private String email;
    private String role;
    private String token;

    public AuthResponse(String name, String email, String role, String token) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.token = token;
    }
}
