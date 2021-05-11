package be.cyimena.airbnb.assetsservice.requests;

public class ChangePasswordRequestDto {
    private String email;
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;
}
