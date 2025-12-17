package com.fractal.domain.authorization.user.profile;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.dto.ChangePasswordRequest;
import com.fractal.domain.authorization.user.profile.dto.UserProfileResponse;

public interface UserProfileService {

    void changePassword(ChangePasswordRequest dto);
    User get();
    UserProfileResponse toDTO(User user);
    //UserProfileResponse toCompactDTO(User user);

}
