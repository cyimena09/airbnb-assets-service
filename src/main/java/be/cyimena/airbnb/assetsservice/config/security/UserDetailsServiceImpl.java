package be.cyimena.airbnb.assetsservice.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //private final AccountRepository accountRepository;

    @Override
    public MyUserPrincipal loadUserByUsername(String email) throws UsernameNotFoundException {
//        Account account = accountRepository.findByEmail(email).orElseThrow(()->  {
//            NotFoundException notFound = new NotFoundException(ExceptionEnum.ACCOUNT_NOT_FOUND.getReasonPhrase() + " with email " + email);
//            return notFound;
//        });
//        if(!account.isActive()) {
//            if(account.getLastModifiedDate().toLocalDateTime().plusSeconds(1).isBefore(account.getUser().getLastModifiedDate().toLocalDateTime())) {
//                throw new DeactivedAccountException(ExceptionEnum.ACCOUNT_DEACTIVATED.value() +"_"+ ExceptionEnum.ACCOUNT_DEACTIVATED.getReasonPhrase());
//            } else {
//                throw new NotActivedAccountException(ExceptionEnum.ACCOUNT_NOT_ACTIVE.value() +"_"+ ExceptionEnum.ACCOUNT_NOT_ACTIVE.getReasonPhrase());
//            }
//        }

        return new MyUserPrincipal(
                "Emile",
                "Cyimena",
                new User("cyimena09@hotmail.com",
                        "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC",
                        Collections.singleton(new SimpleGrantedAuthority("ADMIN"))));
    }

}
