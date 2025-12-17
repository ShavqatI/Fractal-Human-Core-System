package com.fractal.domain.system.message;

import com.fractal.domain.system.message.dto.MessageRequest;
import com.fractal.domain.system.message.dto.MessageResponse;

import java.util.List;

public interface MessageService {

    Message create(MessageRequest dto);

    List<Message> getAll();

    Message getByCode(String code);

    Message getById(Long id);

    Message update(Long id, MessageRequest dto);

    void deleteById(Long id);

    MessageResponse toDTO(Message message);
}
