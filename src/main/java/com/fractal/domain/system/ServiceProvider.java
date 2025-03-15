package com.fractal.domain.system;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.ServiceProviderType;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "service_provider", schema = "system_schema", catalog = "fractal")
public class ServiceProvider extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "service_provider_id", referencedColumnName = "id")
    private ServiceProviderType serviceProviderType;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "port")
    private Integer port;
    @Basic
    @Column(name = "protocol")
    private String protocol;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public ServiceProviderType getServiceProviderType() {
        return serviceProviderType;
    }

    public void setServiceProviderType(ServiceProviderType serviceProviderType) {
        this.serviceProviderType = serviceProviderType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
