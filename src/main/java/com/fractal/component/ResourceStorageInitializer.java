package com.fractal.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class ResourceStorageInitializer {

    @Value("${resource-storage.root-path}")
    private String rootPath;

    @Value("${resource-storage.employee}")
    private String employee;

    @Value("${resource-storage.candidate}")
    private String candidate;

    @Value("${resource-storage.identification-document}")
    private String identificationDocument;

    @Value("${resource-storage.education}")
    private String education;

    @Value("${resource-storage.military-service}")
    private String militaryService;

    @Value("${resource-storage.order}")
    private String order;

    @Value("${resource-storage.agreement}")
    private String agreement;

    @Value("${resource-storage.learning}")
    private String learning;

    @Value("${resource-storage.document-template-manager}")
    private String documentTemplateManager;

    @Value("${resource-storage.business-trip}")
    private String businessTrip;

    @Value("${resource-storage.temporary}")
    private String temporary;

    @EventListener(ApplicationReadyEvent.class)
    public void createFolders() {
        List<String> folders = List.of(
                rootPath, employee, candidate, identificationDocument, education,
                militaryService, order, agreement, learning,
                documentTemplateManager, businessTrip, temporary
        );

        folders.forEach(folder -> {
            File dir = new File(folder);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (created) {
                    System.out.println("Created folder: " + dir.getAbsolutePath());
                }
            }
        });
    }
}
