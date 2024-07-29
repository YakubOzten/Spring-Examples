package com.yakubozten.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(of = {"id","message","messageDate"})
public class Kmessage {
    private String message;
    private String id= UUID.randomUUID().toString();
    private LocalDate messageDate=LocalDate.now();
}
