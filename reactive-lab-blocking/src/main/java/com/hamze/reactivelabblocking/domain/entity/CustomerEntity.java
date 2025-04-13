package com.hamze.reactivelabblocking.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@Table(name = "CUSTOMER")
public class CustomerEntity extends ABaseVersionedEntity {

    @Id
    @Basic
    @Column(name = "ID", length = 10, unique = true)
    private Integer customerId;

    @Basic
    @Column(name = "FIRST_NAME", length = 128)
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME", length = 128)
    private String lastName;

    @Basic
    @Column(name = "NATIONAL_ID", length = 11)
    private String nationalId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(nationalId, that.nationalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, nationalId);
    }
}