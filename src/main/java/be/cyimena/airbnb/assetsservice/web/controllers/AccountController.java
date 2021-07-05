package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.requests.ChangeEmailRequestDto;
import be.cyimena.airbnb.assetsservice.requests.ChangePasswordRequestDto;
import be.cyimena.airbnb.assetsservice.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping(path = "/api/v1")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @PutMapping(path = "/accounts/email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccountEmail(@RequestBody @Valid ChangeEmailRequestDto emailDto) {
        accountService.updateAccountEmail(emailDto);
    }

    @PutMapping(path = "/accounts/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccountPassword(@RequestBody @Valid ChangePasswordRequestDto passwordDto) {
        accountService.updateAccountPassword(passwordDto);
    }

    @GetMapping(path = "/accounts/registration/{token}")
    public ResponseEntity<Object> accountActivation(@PathVariable(name = "token") @NotBlank(message = "1414_Missing token") String token) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
