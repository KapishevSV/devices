package ru.ksv.devices.model;

import jakarta.persistence.*;

@Entity
@Table(name="counter")
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sn")
    private String sn;
    @Column(name = "type")
    private String type;
    @Column(name = "location")
    private String location;

    public Counter() {
    }

    public Counter(Integer id, String sn, String type, String location) {
        this.id = id;
        this.sn = sn;
        this.type = type;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
