package com.fractal.domain.system.message.type;

import com.fractal.domain.insurance.type.InsuranceType;
import com.fractal.domain.system.message.type.dto.MessageTypeRequest;
import com.fractal.domain.system.message.type.dto.MessageTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MessageTypeServiceImpl implements MessageTypeService {

    private final MessageTypeRepository messageTypeRepository;

    @Override
    public MessageType create(MessageTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<MessageType> getAll() {
        return messageTypeRepository.findAll();
    }

    @Override
    public MessageType getByCode(String code) {
        return messageTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public MessageType getById(Long id) {
        return findById(id);
    }

    @Override
    public MessageType update(Long id, MessageTypeRequest dto) {
        try {
            MessageType messageType = findById(id);
            messageType.setCode(dto.code());
            messageType.setName(dto.name());
            messageType.setDescription(dto.description());
            return save(messageType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        messageTypeRepository.delete(findById(id));
    }

    @Override
    public MessageTypeResponse toDTO(MessageType messageType) {
        return new MessageTypeResponse(
                messageType.getId(),
                messageType.getCode(),
                messageType.getName(),
                messageType.getDescription(),
                messageType.getCreatedDate()
        );
    }

    private MessageType toEntity(MessageTypeRequest dto) {
        return MessageType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private MessageType save(MessageType messageType) {
        try {
            return messageTypeRepository.save(messageType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private MessageType findById(Long id) {
        return messageTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
