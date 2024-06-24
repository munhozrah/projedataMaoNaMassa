package org.munhoz.rafael.tstpratico.inif.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@EqualsAndHashCode
@Getter
public class Pessoa {
    String nome;
    LocalDate dtNascimento;
};
