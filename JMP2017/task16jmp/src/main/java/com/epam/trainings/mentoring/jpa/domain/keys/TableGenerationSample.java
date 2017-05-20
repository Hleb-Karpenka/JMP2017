package com.epam.trainings.mentoring.jpa.domain.keys;

import javax.persistence.*;

@Entity
@TableGenerator(name = "ID_TABLE_GEN",
        table = "SEQUENCES",
        pkColumnName = "SEQ_NAME",
        valueColumnName = "SEQ_NUMBER",
        allocationSize = 1)
public class TableGenerationSample {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_TABLE_GEN")
    @Column(name = "ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
