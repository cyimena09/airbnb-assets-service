package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.requests.ChangeEmailRequestDto;
import be.cyimena.airbnb.assetsservice.requests.ChangePasswordRequestDto;

public interface IAccountService {
    void updateAccountEmail(ChangeEmailRequestDto emailDto);
    void updateAccountPassword(ChangePasswordRequestDto passwordDto);
    String accountActivation(String email);
}
