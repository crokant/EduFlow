package eduflow.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import eduflow.models.User;


public record UserDTO(@NotBlank String name, @NotBlank @Email String email) {
    public User getModel() {
        User user = new User();
        user.setUserName(name);
        user.setUserEmail(email);
        return user;
    }
}

