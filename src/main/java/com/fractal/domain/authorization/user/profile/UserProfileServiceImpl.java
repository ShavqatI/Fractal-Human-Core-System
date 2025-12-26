package com.fractal.domain.authorization.user.profile;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.authorization.mapping.user_candidate.UserCandidateMappingService;
import com.fractal.domain.authorization.mapping.user_employee.UserEmployeeMappingService;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.dto.ChangePasswordRequest;
import com.fractal.domain.authorization.user.profile.dto.UserProfileResponse;
import com.fractal.domain.employee_management.employee.mapper.EmployeeMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserService userService;
    private final AuthenticatedService authenticatedService;
    private final UserEmployeeMappingService userEmployeeMappingService;
    private final UserCandidateMappingService userCandidateMappingService;
    private final EmployeeMapperService employeeMapperService;

    @Override
    public void changePassword(ChangePasswordRequest dto) {
        try {
            userService.changePassword(authenticatedService.getUser().getId(),dto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User get() {
        return userService.getById(authenticatedService.getUser().getId());
    }

    @Override
    public UserProfileResponse toDTO(User user) {
        try{
            var userEmployee = userEmployeeMappingService.getByUserId(user.getId());
        }
        catch (Exception e){
            var userCandidate = userCandidateMappingService.getCandidate(user);
        }
        return new UserProfileResponse(
                user.getUsername(),
                null,
                null,
                //userEmployeeMappingService.toDTO(userEmployeeMappingService.getByUserId(user.getId())).employee(),
                //employeeMapperService.getProfilePhoto(userEmployeeMappingService.getEmployee(user)),
                user.getCreatedDate()
        );
    }

   /* @Override
    public UserCompactResponse toCompactDTO(User user) {
        return mapperService.toCompactDTO(user);
    }*/



}

