package com.fractal;

import com.fractal.domain.navigation.action.ActionService;
import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.action.MenuAction;
import com.fractal.domain.navigation.menu.action.MenuActionService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "com.fractal")
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final MenuActionService menuActionService;
    private final ActionService actionService;
    private final MenuService menuService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Map<String, String> values = Map.of(
                "docDate", "2025-01-01",
                "branchName", "DMB",
                "fullBankName", "CJSC ICB",
                "employeeName", "Test test",
                "employeePosition", "Officer",
                "punishmentType", "Blblalal",
                "sourceDocument", "#12354788",
                "hrHead", "Jigarakt"
        );
        wordTemplateProcessorService.process(Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\document-template-manager\\0af7c45b-dda8-4293-824f-88415484eda8_37_Фармон - Танбех.docx"), Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\test_temp2.DOCX"), values);
        wordToPdfConverterService.convert(Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\test_temp2.DOCX"),Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\test_temp2.pdf"));
    }

    private String buildUrl(MenuAction menuAction) {
        var actionUrl = actionService.getById(menuAction.getAction().getId()).getUrl();
        var menuUrl = buildMenuUrl(menuService.getById(menuAction.getMenu().getId()));
        return menuUrl + "/" + actionUrl;
    }

    private String buildMenuUrl(Menu menu) {
        if (menu == null) {
            return "";
        }
        String urlPart = Optional.ofNullable(menu.getUrl()).orElse("").replaceAll("^/+", "").replaceAll("/+$", "");
        if (menu.getParent() == null) {
            return "/" + urlPart;
        }

        String parentUrl = buildMenuUrl(menu.getParent()).replaceAll("/+$", "");
        return parentUrl + "/" + urlPart;
    }
}
