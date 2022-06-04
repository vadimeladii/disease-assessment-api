package md.utm.ati.service;

import md.utm.ati.client.PredictorClient;
import md.utm.ati.client.view.*;
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
                        predictorClient.heartpartial(buildHearPartialRequestView(profile)),
                        predictorClient.diabetes(buildDiabeteRequestView(profile)),
                        predictorClient.bodyFat(buildBodyFatRequestView(profile)),
                        predictorClient.bodyFatPartial(buildBodyFatPartialRequestView(profile)),
                        predictorClient.stress(buildStressRequestView(profile))))
                .orElse(List.of());
    }

    private void update(ProfileView profileView, Profile profile) {
        profile.setFirstName(profileView.getFirstName());
        profile.setLastName(profileView.getLastName());
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
        profile.setPolyuria(profileView.getPolyuria());
        profile.setPolydipsia(profileView.getPolydipsia());
        profile.setSuddenWeightLoss(profileView.getSuddenWeightLoss());
        profile.setWeakness(profileView.getWeakness());
        profile.setPolyphagia(profileView.getPolyphagia());
        profile.setGenitalThrush(profileView.getGenitalThrush());
        profile.setVisualBlurring(profileView.getVisualBlurring());
        profile.setItching(profileView.getItching());
        profile.setIrritability(profileView.getIrritability());
        profile.setDelayedHealing(profileView.getDelayedHealing());
        profile.setPartialParesis(profileView.getPartialParesis());
        profile.setMuscleStiffness(profileView.getMuscleStiffness());
        profile.setAlopecia(profileView.getAlopecia());
        profile.setObesity(profileView.getObesity());
        profile.setWeight(profileView.getWeight());
        profile.setHeight(profileView.getHeight());
        profile.setNeck(profileView.getNeck());
        profile.setChest(profileView.getChest());
        profile.setAbdomen(profileView.getAbdomen());
        profile.setHip(profileView.getHip());
        profile.setThigh(profileView.getThigh());
        profile.setKnee(profileView.getKnee());
        profile.setAnkle(profileView.getAnkle());
        profile.setBiceps(profileView.getBiceps());
        profile.setForearm(profileView.getForearm());
        profile.setWrist(profileView.getWrist());
        profile.setHumidity(profileView.getHumidity());
        profile.setTemperature(profileView.getTemperature());
        profile.setStepCount(profileView.getStepCount());
    }

    private StressRequestView buildStressRequestView(Profile profile) {
        StressRequestView stressRequestView = new StressRequestView();
        stressRequestView.setHumidity(profile.getHumidity());
        stressRequestView.setTemperature(profile.getTemperature());
        stressRequestView.setStepCount(profile.getStepCount());

        return stressRequestView;
    }

    private BodyFatPartialRequestView buildBodyFatPartialRequestView(Profile profile) {
        BodyFatPartialRequestView bodyFatPartialRequestView = new BodyFatPartialRequestView();
        bodyFatPartialRequestView.setHeight(profile.getHeight());
        bodyFatPartialRequestView.setAbdomen(profile.getAbdomen());
        bodyFatPartialRequestView.setWrist(profile.getWrist());

        return bodyFatPartialRequestView;
    }

    private BodyFatRequestView buildBodyFatRequestView(Profile profile) {
        BodyFatRequestView bodyFatRequestView = new BodyFatRequestView();
        bodyFatRequestView.setAge(profile.getAge());
        bodyFatRequestView.setWeight(profile.getWeight());
        bodyFatRequestView.setHeight(profile.getHeight());
        bodyFatRequestView.setNeck(profile.getNeck());
        bodyFatRequestView.setChest(profile.getChest());
        bodyFatRequestView.setAbdomen(profile.getAbdomen());
        bodyFatRequestView.setHip(profile.getHip());
        bodyFatRequestView.setThigh(profile.getThigh());
        bodyFatRequestView.setKnee(profile.getKnee());
        bodyFatRequestView.setAnkle(profile.getAnkle());
        bodyFatRequestView.setBiceps(profile.getBiceps());
        bodyFatRequestView.setForearm(profile.getForearm());
        bodyFatRequestView.setWrist(profile.getWrist());

        return bodyFatRequestView;

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

    private DiabeteRequestView buildDiabeteRequestView(Profile profile) {
        DiabeteRequestView diabeteRequestView = new DiabeteRequestView();
        diabeteRequestView.setAge(profile.getAge());
        diabeteRequestView.setSex(profile.getSex());
        diabeteRequestView.setPolyuria(profile.getPolyuria());
        diabeteRequestView.setPolydipsia(profile.getPolydipsia());
        diabeteRequestView.setSuddenWeightLoss(profile.getSuddenWeightLoss());
        diabeteRequestView.setWeakness(profile.getWeakness());
        diabeteRequestView.setPolyphagia(profile.getPolyphagia());
        diabeteRequestView.setGenitalThrush(profile.getGenitalThrush());
        diabeteRequestView.setVisualBlurring(profile.getVisualBlurring());
        diabeteRequestView.setItching(profile.getItching());
        diabeteRequestView.setIrritability(profile.getIrritability());
        diabeteRequestView.setDelayedHealing(profile.getDelayedHealing());
        diabeteRequestView.setPartialParesis(profile.getPartialParesis());
        diabeteRequestView.setMuscleStiffness(profile.getMuscleStiffness());
        diabeteRequestView.setAlopecia(profile.getAlopecia());
        diabeteRequestView.setObesity(profile.getObesity());

        return diabeteRequestView;
    }
}
