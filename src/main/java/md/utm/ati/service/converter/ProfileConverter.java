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
        view.setEmail(profile.getEmail());
        view.setHeight(profile.getHeight());
        view.setSugarLevel(profile.getSugarLevel());

        return view;
    }

    @Override
    protected Profile doBackward(ProfileView view) {
        Profile profile = new Profile();
        profile.setId(view.getId());
        profile.setEmail(view.getEmail());
        profile.setHeight(view.getHeight());
        profile.setSugarLevel(view.getSugarLevel());

        return profile;
    }
}
