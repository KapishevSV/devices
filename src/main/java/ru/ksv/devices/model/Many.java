package ru.ksv.devices.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="many", schema = "public")
public class Many {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_1")
    private Long id_many;

    @Column(name = "column_2")
    private String name_many;

    @ManyToOne(fetch = FetchType.LAZY)
    private One one;
}
