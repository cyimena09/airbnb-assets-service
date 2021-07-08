package be.cyimena.airbnb.assetsservice.config.security;


import be.cyimena.airbnb.assetsservice.domain.Account;
import be.cyimena.airbnb.assetsservice.exceptions.AccountNotFoundException;
import be.cyimena.airbnb.assetsservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public MyUserPrincipal loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email).orElseThrow(() -> new AccountNotFoundException(email));

//        if (!account.isActive()) {
//            if (account.getLastModifiedDate().toLocalDateTime().plusSeconds(1).isBefore(account.getUser().getLastModifiedDate().toLocalDateTime())) {
//                throw new DeactivedAccountException(ExceptionEnum.ACCOUNT_DEACTIVATED.value() + "_" + ExceptionEnum.ACCOUNT_DEACTIVATED.getReasonPhrase());
//            } else {
//                throw new NotActivedAccountException(ExceptionEnum.ACCOUNT_NOT_ACTIVE.value() + "_" + ExceptionEnum.ACCOUNT_NOT_ACTIVE.getReasonPhrase());
//            }
//        }

        return new MyUserPrincipal(account.getUser().getFirstName(), account.getUser().getLastName(), new User(account.getEmail(), account.getPassword(), account.getProfiles().stream().map(profile ->
                new SimpleGrantedAuthority(profile.getName())
        ).collect(Collectors.toList())));
    }

}
