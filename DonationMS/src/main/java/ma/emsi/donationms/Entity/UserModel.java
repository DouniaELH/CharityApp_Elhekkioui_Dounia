package ma.emsi.donationms.Entity;


import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String username;
    private int age;
    private int tel;
    private String email;
    private String role;
}