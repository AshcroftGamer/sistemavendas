package com.rains.app.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Data
@Table(name="endereco")
public class EnderecoModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String rua;
    @Column
    private Integer numero;
    @Column
    private String bairro, cidade, estado, complemento;
 

}
