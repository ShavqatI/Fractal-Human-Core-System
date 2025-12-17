package com.fractal.domain.system.message.type;

import com.fractal.domain.system.message.type.dto.MessageTypeRequest;
import com.fractal.domain.system.message.type.dto.MessageTypeResponse;

import java.util.List;

public interface MessageTypeService {

    MessageType create(MessageTypeRequest dto);

    List<MessageType> getAll();

    MessageType getByCode(String code);

    MessageType getById(Long id);

    MessageType update(Long id, MessageTypeRequest dto);

    void deleteById(Long id);

    MessageTypeResponse toDTO(MessageType messageType);
}
