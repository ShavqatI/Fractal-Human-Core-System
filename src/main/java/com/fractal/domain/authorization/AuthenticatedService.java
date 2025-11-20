package com.fractal.domain.authorization;

import com.fractal.domain.authorization.user.User;

public interface AuthenticatedService {
    User getUser();
}
