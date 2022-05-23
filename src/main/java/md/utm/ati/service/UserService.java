package md.utm.ati.service;

import md.utm.ati.client.PredictorClient;
import md.utm.ati.client.view.HeartFullRequestView;
import md.utm.ati.client.view.HeartPartialRequestView;
import md.utm.ati.controller.view.ProfileView;
import md.utm.ati.repository.ProfileRepository;
import md.utm.ati.repository.entity.Profile;
import md.utm.ati.service.converter.ProfileConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public record UserService(ProfileRepository profileRepository, ProfileConverter profileConverter, PredictorClient predictorClient) {

    public Optional<ProfileView> retrieveProfileByEmail(String email) {
        return profileRepository.findByEmail(email).map(profileConverter::convert);
    }

    public void createProfile(ProfileView profileView) {
        profileRepository.save(Objects.requireNonNull(profileConverter.reverse().convert(profileView)));
    }

    public List<Object> retrieveDiseases(String email) {
        return profileRepository.findByEmail(email)
                .map(profile -> List.of(
                        predictorClient.heartfull(buildHearFullRequestView(profile)),
                        predictorClient.heartpartial(buildHearPartialRequestView(profile))))
                .orElse(List.of());

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
