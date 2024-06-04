package com.ssofaaa.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryForm {
    private Long supplier;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;
    private Map<Long, Integer> countOfFruits;
}
