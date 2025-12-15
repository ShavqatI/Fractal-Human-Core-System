package com.fractal.domain.authorization.user.profile;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.dto.*;
import com.fractal.domain.authorization.user.profile.dto.UserProfileResponse;
import com.fractal.domain.authorization.user.role.UserRole;

import java.util.List;

public interface UserProfileService {

    void changePassword(ChangePasswordRequest dto);
    User get();
    UserProfileResponse toDTO(User user);
    //UserProfileResponse toCompactDTO(User user);

}
