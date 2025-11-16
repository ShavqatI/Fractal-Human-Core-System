package com.fractal.domain.abstraction;

public abstract class DTOMapper<Entity, DTO> {
    protected abstract DTO toDTO(Entity entity);

    protected abstract Entity toEntity(DTO dto);
}

