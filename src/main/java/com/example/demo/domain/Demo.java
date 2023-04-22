package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Demo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String keyText;

    @NonNull
    private String valueText;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt = new Date();
  
}
