package md.utm.ati.service;

import md.utm.ati.client.PredictorClient;
import md.utm.ati.client.view.HeartFullRequestView;
import md.utm.ati.client.view.HeartPartialRequestView;
import md.utm.ati.controller.view.EmailView;
import md.utm.ati.controller.view.ProfileView;
import md.utm.ati.exception.BadRequestException;
import md.utm.ati.exception.NotFoundException;
import md.utm.ati.repository.ProfileRepository;
import md.utm.ati.repository.entity.Profile;
import md.utm.ati.service.converter.ProfileConverter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public record UserService(ProfileRepository profileRepository, ProfileConverter profileConverter, PredictorClient predictorClient) {

    public Optional<ProfileView> retrieveProfileByEmail(String email) {
        return profileRepository.findByEmail(email).map(profileConverter::convert);
    }

    public void createProfile(EmailView emailView) {
        profileRepository.findByEmail(emailView.getEmail())
                .ifPresent(profile -> {
                    throw new BadRequestException("Profile with email: [" + emailView.getEmail() + "] already exist");
                });

        ProfileView profileView = ProfileView.builder()
                .firstName(Strings.EMPTY)
                .lastName(Strings.EMPTY)
                .email(emailView.getEmail())
                .build();

        profileRepository.save(Objects.requireNonNull(profileConverter.reverse().convert(profileView)));
    }

    public void updateProfile(String email, ProfileView profileView) {
        Profile profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Profile with email: [" + email + "] doen't exist"));
        update(profileView, profile);

        profileRepository.save(profile);
    }

    public List<Object> retrieveDiseases(String email) {
        return profileRepository.findByEmail(email)
                .map(profile -> List.of(
                        predictorClient.heartfull(buildHearFullRequestView(profile)),
                        predictorClient.heartpartial(buildHearPartialRequestView(profile))))
                .orElse(List.of());
    }

    private void update(ProfileView profileView, Profile profile) {
        profile.setFirstName(profile.getFirstName());
        profile.setLastName(profile.getLastName());
        profile.setAge(profileView.getAge());
        profile.setSex(profileView.getSex());
        profile.setRestingBp(profileView.getRestingBp());
        profile.setCholesterol(profileView.getCholesterol());
        profile.setFastingBs(profileView.getFastingBs());
        profile.setMaxHr(profileView.getMaxHr());
        profile.setExerciseAngina(profileView.getExerciseAngina());
        profile.setOldpeak(profileView.getOldpeak());
        profile.setChestPainTypeAta(profileView.getChestPainTypeAta());
        profile.setChestPainTypeNap(profileView.getChestPainTypeNap());
        profile.setChestPainTypeTa(profileView.getChestPainTypeTa());
        profile.setRestingEcgNormal(profileView.getRestingEcgNormal());
        profile.setRestingEcgSt(profileView.getRestingEcgSt());
        profile.setStSlopeFlat(profileView.getStSlopeFlat());
        profile.setStSlopeUp(profileView.getStSlopeUp());
    }

    private HeartPartialRequestView buildHearPartialRequestView(Profile profile) {
        HeartPartialRequestView heartPartialRequestView = new HeartPartialRequestView();
        heartPartialRequestView.setAge(profile.getAge());
        heartPartialRequestView.setSex(profile.getSex());
        heartPartialRequestView.setMaxHR(profile.getMaxHr());
        heartPartialRequestView.setExerciseAngina(profile.getExerciseAngina());
        heartPartialRequestView.setChestPainTypeAta(profile.getChestPainTypeAta());
        heartPartialRequestView.setChestPainTypeNap(profile.getChestPainTypeNap());
        heartPartialRequestView.setChestPainTypeTa(profile.getChestPainTypeTa());

        return heartPartialRequestView;
    }

    private HeartFullRequestView buildHearFullRequestView(Profile profile) {
        HeartFullRequestView heartFullRequestView = new HeartFullRequestView();
        heartFullRequestView.setAge(profile.getAge());
        heartFullRequestView.setSex(profile.getSex());
        heartFullRequestView.setRestingBp(profile.getRestingBp());
        heartFullRequestView.setCholesterol(profile.getCholesterol());
        heartFullRequestView.setFastingBs(profile.getFastingBs());
        heartFullRequestView.setMaxHr(profile.getMaxHr());
        heartFullRequestView.setExerciseAngina(profile.getExerciseAngina());
        heartFullRequestView.setOldpeak(profile.getOldpeak());
        heartFullRequestView.setChestPainTypeAta(profile.getChestPainTypeAta());
        heartFullRequestView.setChestPainTypeNap(profile.getChestPainTypeNap());
        heartFullRequestView.setChestPainTypeTa(profile.getChestPainTypeTa());
        heartFullRequestView.setRestingEcgNormal(profile.getRestingEcgNormal());
        heartFullRequestView.setRestingEcgSt(profile.getRestingEcgSt());
        heartFullRequestView.setStSlopeFlat(profile.getStSlopeFlat());
        heartFullRequestView.setStSlopeUp(profile.getStSlopeUp());

        return heartFullRequestView;
    }
}
