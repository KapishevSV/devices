package ru.ksv.devices.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="usd", schema = "public")
public class Usd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usd")
    private Long id;

    @Column(name = "sn")
    private String sn;

    @Column(name = "locate")
    private String locate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;
}
