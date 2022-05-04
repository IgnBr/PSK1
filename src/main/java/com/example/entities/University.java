package com.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "UNIVERSITY")
@Getter @Setter
@NamedQueries({
        @NamedQuery(name = "University.findAll", query = "select u from University as u")
})
public class University implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max=50)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(mappedBy = "university", fetch = FetchType.EAGER)
    private List<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University university = (University) o;
        return Objects.equals(name, university.name) &&
                Objects.equals(address, university.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
