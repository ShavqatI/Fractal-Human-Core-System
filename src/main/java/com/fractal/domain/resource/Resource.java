package com.fractal.domain.resource;


import com.fractal.domain.abstraction.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "resource",schema = "resource_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @Column(name = "url")
    private  String url;

    @Column(name = "file_name")
    private  String fileName;

    @Column(name = "content_type")
    private  String contentType;

    @Column(name = "size_in_bytes")
    private  Long sizeInBytes;

}
