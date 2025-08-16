package com.fractal.domain.identification_document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Long> {

}
