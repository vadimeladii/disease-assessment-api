package md.utm.ati.controller;

import lombok.RequiredArgsConstructor;
import md.utm.ati.controller.view.EmailView;
import md.utm.ati.controller.view.ProfileView;
import md.utm.ati.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}/profile")
    public ResponseEntity<ProfileView> retrieveProfileByEmail(@PathVariable("email") String email) {
        return ResponseEntity.of(userService.retrieveProfileByEmail(email));
    }

    @PostMapping("/profile")
    public ResponseEntity<Void> createProfile(@RequestBody EmailView emailView) {
        userService.createProfile(emailView);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{email}/profile")
    public ResponseEntity<Void> createProfile(@PathVariable("email") String email, @RequestBody ProfileView profileView) {
        userService.updateProfile(email, profileView);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{email}/disseases")
    public ResponseEntity<List<Object>> retrieveDiseases(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.retrieveDiseases(email));
    }
}
