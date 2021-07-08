package be.cyimena.airbnb.assetsservice.utils;

import be.cyimena.airbnb.assetsservice.domain.Profile;
import be.cyimena.airbnb.assetsservice.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Helper {
    private final ProfileRepository profileRepository;

    public Set<Profile> mergeProfiles(Collection<Profile> profiles){
        return profiles.stream().map(p-> profileRepository.findByName(p.getName()).orElseGet(()->p)).collect(Collectors.toSet());
    }
}

