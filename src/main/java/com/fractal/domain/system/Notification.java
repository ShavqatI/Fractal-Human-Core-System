package com.fractal.domain.system;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.NotificationType;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "notification", schema = "system_schema", catalog = "fractal")
public class Notification extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "notification_type_id", referencedColumnName = "id")
    private NotificationType notificationType;

    @ManyToOne
    @JoinColumn(name = "service_provider_id", referencedColumnName = "id")
    private ServiceProvider serviceProvider;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "sender")
    private String sender;
    @Basic
    @Column(name = "receiver")
    private String receiver;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
