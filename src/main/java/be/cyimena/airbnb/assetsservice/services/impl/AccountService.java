package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.requests.ChangeEmailRequestDto;
import be.cyimena.airbnb.assetsservice.requests.ChangePasswordRequestDto;
import be.cyimena.airbnb.assetsservice.services.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Override
    public void updateAccountEmail(ChangeEmailRequestDto emailDto) {

    }

    @Override
    public void updateAccountPassword(ChangePasswordRequestDto passwordDto) {

    }

    @Override
    public String accountActivation(String email) {
        return null;
    }
}
