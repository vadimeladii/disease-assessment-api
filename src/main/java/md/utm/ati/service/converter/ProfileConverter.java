package md.utm.ati.service.converter;

import com.google.common.base.Converter;
import md.utm.ati.controller.view.ProfileView;
import md.utm.ati.repository.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter extends Converter<Profile, ProfileView> {

    @Override
    protected ProfileView doForward(Profile profile) {
        return ProfileView.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .age(profile.getAge())
                .sex(profile.getSex())
                .restingBp(profile.getRestingBp())
                .cholesterol(profile.getCholesterol())
                .fastingBs(profile.getFastingBs())
                .maxHr(profile.getMaxHr())
                .exerciseAngina(profile.getExerciseAngina())
                .oldpeak(profile.getOldpeak())
                .chestPainTypeAta(profile.getChestPainTypeAta())
                .chestPainTypeNap(profile.getChestPainTypeNap())
                .chestPainTypeTa(profile.getChestPainTypeTa())
                .restingEcgNormal(profile.getRestingEcgNormal())
                .restingEcgSt(profile.getRestingEcgSt())
                .stSlopeFlat(profile.getStSlopeFlat())
                .stSlopeUp(profile.getStSlopeUp())
                .build();
    }

    @Override
    protected Profile doBackward(ProfileView view) {
        Profile profile = new Profile();
        profile.setId(view.getId());
        profile.setFirstName(view.getFirstName());
        profile.setLastName(view.getLastName());
        profile.setEmail(view.getEmail());
        profile.setAge(view.getAge());
        profile.setSex(view.getSex());
        profile.setRestingBp(view.getRestingBp());
        profile.setCholesterol(view.getCholesterol());
        profile.setFastingBs(view.getFastingBs());
        profile.setMaxHr(view.getMaxHr());
        profile.setExerciseAngina(view.getExerciseAngina());
        profile.setOldpeak(view.getOldpeak());
        profile.setChestPainTypeAta(view.getChestPainTypeAta());
        profile.setChestPainTypeNap(view.getChestPainTypeNap());
        profile.setChestPainTypeTa(view.getChestPainTypeTa());
        profile.setRestingEcgNormal(view.getRestingEcgNormal());
        profile.setRestingEcgSt(view.getRestingEcgSt());
        profile.setStSlopeFlat(view.getStSlopeFlat());
        profile.setStSlopeUp(view.getStSlopeUp());

        return profile;
    }
}
