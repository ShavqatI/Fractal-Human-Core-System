package com.fractal.domain.employment.docuemnt_template_manager;

import com.fractal.domain.employment.docuemnt_template_manager.dto.PaymentFrequencyRequest;
import com.fractal.domain.employment.docuemnt_template_manager.dto.PaymentFrequencyResponse;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class PaymentFrequencyServiceImpl implements PaymentFrequencyService {

    private final PaymentFrequencyRepository paymentFrequencyRepository;

    @Override
    public PaymentFrequency create(PaymentFrequencyRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<PaymentFrequency> getAll() {
        return paymentFrequencyRepository.findAll();
    }

    @Override
    public PaymentFrequency getByCode(String code) {
        return paymentFrequencyRepository.findByCode(code).orElseThrow(()-> new ResourceWithCodeNotFoundException(this,code));
    }

    @Override
    public PaymentFrequency getById(Long id) {
        return findById(id);
    }

    @Override
    public PaymentFrequency update(Long id, PaymentFrequencyRequest dto) {
        try {
            PaymentFrequency paymentFrequency = findById(id);
            paymentFrequency.setCode(dto.code());
            paymentFrequency.setName(dto.name());
            return save(paymentFrequency);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        paymentFrequencyRepository.delete(findById(id));
    }

    @Override
    public PaymentFrequencyResponse toDTO(PaymentFrequency paymentFrequency) {
        return new PaymentFrequencyResponse(
                paymentFrequency.getId(),
                paymentFrequency.getCode(),
                paymentFrequency.getName(),
                paymentFrequency.getCreatedDate()
        );
    }

    private PaymentFrequency toEntity(PaymentFrequencyRequest dto) {
        return PaymentFrequency.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private PaymentFrequency save(PaymentFrequency paymentFrequency) {
        try {
            return paymentFrequencyRepository.save(paymentFrequency);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private PaymentFrequency findById(Long id) {
        return paymentFrequencyRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
