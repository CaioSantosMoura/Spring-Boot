package net.weg.banco.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pj")
public class Pjuridica extends Cliente {
    private Long cnpj;
    private String razaoSocial;
}
