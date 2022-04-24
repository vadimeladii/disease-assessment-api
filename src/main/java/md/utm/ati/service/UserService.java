package md.utm.ati.service;

import md.utm.ati.controller.view.ProfileView;
import md.utm.ati.repository.ProfileRepository;
import md.utm.ati.service.converter.ProfileConverter;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public record UserService(ProfileRepository profileRepository, ProfileConverter profileConverter) {

    public Optional<ProfileView> retrieveProfileByEmail(String email) {
        return profileRepository.findByEmail(email).map(profileConverter::convert);
    }

    public void createProfile(ProfileView profileView) {
        profileRepository.save(Objects.requireNonNull(profileConverter.reverse().convert(profileView)));
    }
}
