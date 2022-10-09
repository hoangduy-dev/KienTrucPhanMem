package com.youtube.jwt.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String source;
    private String message;



    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
