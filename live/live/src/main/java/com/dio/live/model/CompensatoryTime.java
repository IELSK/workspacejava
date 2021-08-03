package com.dio.live.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class CompensatoryTime {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public  class   CompTimeId implements Serializable {
        private long idCompTime;
        private long idMovement;
        private long idUser;
    }
    @Id
    @EmbeddedId
    private CompTimeId compTimeId;
    private LocalDateTime workedDate;
    private BigDecimal hoursQuantity;
    private BigDecimal hoursBalance;
}
