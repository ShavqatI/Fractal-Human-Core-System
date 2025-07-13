package com.fractal.domain.employee_management.order;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

public interface OrderService {
    Order getById(Long id);
    void save(Order order);

}
