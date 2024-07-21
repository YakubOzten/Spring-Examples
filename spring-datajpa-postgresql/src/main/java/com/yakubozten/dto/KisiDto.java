package com.yakubozten.dto;

import com.yakubozten.entity.Adres;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Transactional
public class KisiDto {

    private  long id;

    @NotNull
    private String adi;

    private String soyadi;

    private List<String> adresler;
}
