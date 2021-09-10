package com.msa.server.adapter.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name="EXAMPLE")
public class Example {

    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="value")
    private Integer value;
}
