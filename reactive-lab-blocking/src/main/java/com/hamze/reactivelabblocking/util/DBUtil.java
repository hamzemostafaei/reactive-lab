package com.hamze.reactivelabblocking.util;

import com.hamze.reactivelabblocking.model.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class DBUtil {

    private final EntityManager entityManager;


    public Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    public Serializable getId() {
        return getCurrentSession().getIdentifier(new Employee());
    }
}
