package com.fractal;

import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.navigation.action.ActionService;
import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.action.MenuAction;
import com.fractal.domain.navigation.menu.action.MenuActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.fractal")
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final MenuActionService menuActionService;
    private final ActionService actionService;
    private final MenuService menuService;
    //private final EmployeeUseCaseService employeeUseCaseService;
    //private final EmployeeService employeeService;

    private final EmployeeEmploymentService employeeEmploymentService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
       //employeeEmploymentService.getAll().size();
    }

   /* private String buildUrl(MenuAction menuAction) {
        var actionUrl = actionService.getById(menuAction.getAction().getId()).getUrl();
        var menuUrl = buildMenuUrl(menuService.getById(menuAction.getMenu().getId()));
        return menuUrl + "/" + actionUrl;
    }*/

  /*  private String buildMenuUrl(Menu menu) {
        if (menu == null) {
            return "";
        }
        String urlPart = Optional.ofNullable(menu.getUrl()).orElse("").replaceAll("^/+", "").replaceAll("/+$", "");
        if (menu.getParent() == null) {
            return "/" + urlPart;
        }

        String parentUrl = buildMenuUrl(menu.getParent()).replaceAll("/+$", "");
        return parentUrl + "/" + urlPart;
    }*/
}
