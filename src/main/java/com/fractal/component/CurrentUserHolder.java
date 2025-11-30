package com.fractal.component;

import com.fractal.domain.authorization.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserHolder {
    private static final ThreadLocal<User> USER = new ThreadLocal<>();

    public void set(User user) {
       USER.set(user);
    }

    public User get() {
        return USER.get();
    }

    public void clear() { USER.remove(); }
}
