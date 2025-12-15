package com.fractal.domain.order.recognition;

import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.order.business_trip.BusinessTripOrder;
import com.fractal.domain.order.business_trip.record.BusinessTripOrderRecord;
import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import com.fractal.domain.utilities.converter.NumberToWordConverter;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
class RecognitionOrderTemplateProcessorService {

    private final EmployeeUseCaseService employeeUseCaseService;
    private final EmployeeEmploymentService employeeEmploymentService;


    public Map<String,String> process(RecognitionOrder order){
        return switch (order.getOrderType().getCode()) {
            case "SALARYREDUCTION" -> getDecreaseSalaryValues(order);
            case "PAYCHG" -> getIncreaseSalaryValues(order);
            case "BONUSPAY" -> getAdditionalSalaryValues(order);
            case "ONETIMEBONUS" -> getOneTimeBonusValues(order);
            default -> new HashMap<>();
        };
    }

    private Map<String,String> getDecreaseSalaryValues(RecognitionOrder order) {
        Map<String,String> values = new HashMap<>();
        var employeeEmployment = getEmployment(order.getRecords().getFirst());
        var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
        var compensationComponent = employment.compensationComponents().getLast();

        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("justification",order.getJustification());
        values.put("startDate", compensationComponent.startDate().toString());
        values.putAll(getSalaryValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map<String,String> getIncreaseSalaryValues(RecognitionOrder order) {
        Map<String,String> values = new HashMap<>();
        var employeeEmployment = getEmployment(order.getRecords().getFirst());
        var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
        var compensationComponent = employment.compensationComponents().getLast();
        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("justification",order.getJustification());
        values.put("startDate", compensationComponent.startDate().toString());
        values.putAll(getSalaryValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
        return values;
    }
    private Map<String,String> getAdditionalSalaryValues(RecognitionOrder order) {
        Map<String,String> values = new HashMap<>();
        var employeeEmployment = getEmployment(order.getRecords().getFirst());
        var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
        var compensationComponent = employment.compensationComponents().getLast();

        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("justification",order.getJustification());
        values.put("startDate", compensationComponent.toString());
        values.putAll(getSurchargeValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }
    private Map<String,String> getOneTimeBonusValues(RecognitionOrder order) {
        Map<String,String> values = new HashMap<>();
        var employeeEmployment = getEmployment(order.getRecords().getFirst());
        var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();

        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("shortBankName", employment.organization().name());
        values.put("justification",order.getJustification());
        values.putAll(getSurchargeValues(employment));
        values.put("sourceDocument", order.getSourceDocument());
      return values;
    }
    public XWPFDocument getTenYearServiceBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }
    public XWPFDocument getRemittanceBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }
    public XWPFDocument getNewCustomersBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }
    public XWPFDocument getLoanRecoveryBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }
    public XWPFDocument getCustomerServiceBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }
    public XWPFDocument getDFSBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }
    public XWPFDocument getTreasureBonusValues(XWPFDocument document,RecognitionOrder order) {
        List<List<String>> tableData = new ArrayList<>();
        int number = 1;
        for (RecognitionOrderRecord record : order.getRecords()) {
            var employeeEmployment = getEmployment(record);
            var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
            var employeeName = employeeUseCaseService.getFullName(employeeEmployment.getEmployee());
            var organizationName = employment.organization().name();
            var amount = record.getCompensationComponent().getGrossAmount();
            tableData.add(List.of(String.valueOf(number++), employeeName, organizationName, amount.toString()));
        }
        try {
          document =  writeTable(document,tableData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
      return document;
    }


    private Map<String,String> getSalaryValues(InternalEmploymentResponse employment) {
        Map<String,String> values = new HashMap<>();
        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("BASICSALARY")).sorted(Comparator.comparing(CompensationComponentResponse::startDate).reversed()).findFirst().get();
        values.put("newSalary", compensationComponent.grossAmount().toString());
        values.put("newSalaryInLetters", NumberToWordConverter.convert(compensationComponent.grossAmount().longValue()));
        return values;
    }
    private Map<String,String> getSurchargeValues(InternalEmploymentResponse employment){
        Map<String,String> values = new HashMap<>();
        var compensationComponent  = employment.compensationComponents().stream().filter(cc-> cc.salaryClassification().code().equals("BASICSALARY")).sorted(Comparator.comparing(CompensationComponentResponse::startDate).reversed()).findFirst().get();
        values.put("surcharge", compensationComponent.grossAmount().toString());
        values.put("surchargeInLetters", NumberToWordConverter.convert(compensationComponent.grossAmount().longValue()));
        return values;
    }

    private EmployeeEmployment getEmployment(RecognitionOrderRecord record) {
        var employment = (Employment) Hibernate.unproxy(record.getEmployment().getEmployment());
        EmployeeEmployment employeeEmployment = null;
        if (employment instanceof InternalEmployment internalEmployment) {
            internalEmployment.setCompensationComponents(List.of(record.getCompensationComponent()));
            employeeEmployment = record.getEmployment();
            employeeEmployment.setEmployment(internalEmployment);
        }
        return employeeEmployment;
    }

    private XWPFDocument writeTable(XWPFDocument document, List<List<String>> data) throws Exception {
        XWPFTable targetTable = document.getTables().get(1);
        var headerRow = targetTable.getRow(0);
        int i = 0;
        data.forEach(rowData->
        {
            XWPFTableRow row;
            row = i + 1 < targetTable.getNumberOfRows() ? targetTable.getRow(i + 1) : targetTable.createRow();

            for (int j = 0; j < rowData.size(); j++) {
                XWPFTableCell cell;
                if (j < row.getTableCells().size()) {
                    cell = row.getCell(j);
                } else {
                    cell = row.addNewTableCell();
                }
                cell.setText(rowData.get(j));

                if (j < headerRow.getTableCells().size()) {
                    XWPFTableCell headerCell = headerRow.getCell(j);
                    cell.getCTTc().setTcPr(headerCell.getCTTc().getTcPr());

                    // Remove any existing paragraph
                    cell.removeParagraph(0);

                    for (XWPFParagraph headerParagraph : headerCell.getParagraphs()) {
                        XWPFParagraph p = cell.addParagraph();
                        p.getCTP().setPPr(headerParagraph.getCTP().getPPr());

                        XWPFRun run = p.createRun();
                        if (!headerParagraph.getRuns().isEmpty()) {
                            XWPFRun headerRun = headerParagraph.getRuns().get(0);
                            run.getCTR().setRPr(headerRun.getCTR().getRPr());
                            run.setBold(false);
                            run.setFontSize(8);
                        }
                        run.setText(rowData.get(j));
                    }
                } else {
                    cell.setText(rowData.get(j));
                }
            }
        });
        return document;
    }


}
