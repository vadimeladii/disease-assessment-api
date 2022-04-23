package md.utm.ati.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/{email}/profile")
    public String createProfile(@PathVariable("email") String email){
        return email;
    }

    @GetMapping("{email}/disseases")
    public String retrieveDiseases(@PathVariable("email") String email) {
        return email;
    }
}
