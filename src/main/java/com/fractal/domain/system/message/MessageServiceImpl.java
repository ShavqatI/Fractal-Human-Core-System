package com.fractal.domain.system.message;

import com.fractal.domain.localization.language.LanguageService;
import com.fractal.domain.system.message.dto.MessageRequest;
import com.fractal.domain.system.message.dto.MessageResponse;
import com.fractal.domain.system.message.type.MessageTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageTypeService messageTypeService;
    private final LanguageService languageService;

    @Override
    public Message create(MessageRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message getByCode(String code) {
        return messageRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public Message getByCodeAndLanguage(String code, String languageCode) {
        return messageRepository.findByCodeAndLanguageAndCode(code,languageCode).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " and language code:" + languageCode + " not found"));

    }

    @Override
    public Message getById(Long id) {
        return findById(id);
    }

    @Override
    public Message update(Long id, MessageRequest dto) {
        try {
            Message message = findById(id);
            message.setMessageType(messageTypeService.getById(dto.messageTypeId()));
            message.setCode(dto.code());
            message.setName(dto.name());
            message.setDescription(dto.description());
            message.setLanguage(languageService.getById(dto.languageId()));
            return save(message);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.delete(findById(id));
    }

    @Override
    public MessageResponse toDTO(Message message) {
        return new MessageResponse(
                message.getId(),
                messageTypeService.toDTO(message.getMessageType()),
                message.getCode(),
                message.getName(),
                message.getDescription(),
                languageService.toDTO(message.getLanguage()),
                message.getCreatedDate()
        );
    }

    private Message toEntity(MessageRequest dto) {
        return Message.builder()
                .messageType(messageTypeService.getById(dto.messageTypeId()))
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .language(languageService.getById(dto.languageId()))
                .build();
    }

    private Message save(Message message) {
        try {
            return messageRepository.save(message);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Message findById(Long id) {
        return messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
