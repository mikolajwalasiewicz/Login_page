package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Plik HTML dla strony rejestracji
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Logika rejestracji użytkownika
        return "redirect:/login"; // Po rejestracji przekierowanie do logowania
    }
}
