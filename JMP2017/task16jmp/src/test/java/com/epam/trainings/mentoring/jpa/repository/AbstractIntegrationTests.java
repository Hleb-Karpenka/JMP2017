package com.epam.trainings.mentoring.jpa.repository;

import com.ninja_squad.dbsetup.destination.Destination;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public abstract class AbstractIntegrationTests {
    protected Destination destination;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Before
    public void init() {
        this.destination = new TransactionAwareDestination(dataSource, transactionManager);
    }
}
