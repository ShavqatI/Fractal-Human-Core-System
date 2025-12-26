package com.fractal.domain.authorization;

import com.fractal.domain.authorization.mapping.user_candidate.UserCandidateMappingService;
import com.fractal.domain.authorization.mapping.user_employee.UserEmployeeMappingService;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthenticatedServiceImpl implements AuthenticatedService {

    private final UserService userService;
    private final UserEmployeeMappingService userEmployeeMappingService;
    private final UserCandidateMappingService userCandidateMappingService;
    @Override
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                var userDetails = (UserDetails) principal;
                User user = userService.findByUsername(userDetails.getUsername());
                return user;
            } else {}
        } else {}
        return null;
    }

    @Override
    public Long getEmployeeId() {
       try{
           return userEmployeeMappingService.getEmployee(getUser()).getId();
       }
       catch (Exception e){
          throw new RuntimeException(e.getMessage());
       }

    }
    @Override
    public Long getCandidateId() {
        try{
            return userCandidateMappingService.getCandidate(getUser()).getId();
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
