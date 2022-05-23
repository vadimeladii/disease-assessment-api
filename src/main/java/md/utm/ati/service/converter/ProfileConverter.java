package md.utm.ati.service.converter;

import com.google.common.base.Converter;
import md.utm.ati.controller.view.ProfileView;
import md.utm.ati.repository.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter extends Converter<Profile, ProfileView> {

    @Override
    protected ProfileView doForward(Profile profile) {
        ProfileView view = new ProfileView();
        view.setId(profile.getId());
        view.setFirstName(profile.getFirstName());
        view.setLastName(profile.getLastName());
        view.setEmail(profile.getEmail());
        view.setAge(profile.getAge());
        view.setSex(profile.getSex());
        view.setRestingBp(profile.getRestingBp());
        view.setCholesterol(profile.getCholesterol());
        view.setFastingBs(profile.getFastingBs());
        view.setMaxHr(profile.getMaxHr());
        view.setExerciseAngina(profile.getExerciseAngina());
        view.setOldpeak(profile.getOldpeak());
        view.setChestPainTypeAta(profile.getChestPainTypeAta());
        view.setChestPainTypeNap(profile.getChestPainTypeNap());
        view.setChestPainTypeTa(profile.getChestPainTypeTa());
        view.setRestingEcgNormal(profile.getRestingEcgNormal());
        view.setRestingEcgSt(profile.getRestingEcgSt());
        view.setStSlopeFlat(profile.getStSlopeFlat());
        view.setStSlopeUp(profile.getStSlopeUp());

        return view;
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
