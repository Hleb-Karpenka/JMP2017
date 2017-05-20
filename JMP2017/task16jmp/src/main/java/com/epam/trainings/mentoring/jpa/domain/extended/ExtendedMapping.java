package com.epam.trainings.mentoring.jpa.domain.extended;


import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EXTENDED_MAPPING")
public class ExtendedMapping extends AbstractIdentified {
    @Embedded
    private LargeObjects largeObjects;
    @Embedded
    private PrimitiveTypes primitiveTypes;
    @Embedded
    private TemporalTypes temporalTypes;

    public LargeObjects getLargeObjects() {
        return largeObjects;
    }

    public void setLargeObjects(LargeObjects largeObjects) {
        this.largeObjects = largeObjects;
    }

    public PrimitiveTypes getPrimitiveTypes() {
        return primitiveTypes;
    }

    public void setPrimitiveTypes(PrimitiveTypes primitiveTypes) {
        this.primitiveTypes = primitiveTypes;
    }

    public TemporalTypes getTemporalTypes() {
        return temporalTypes;
    }

    public void setTemporalTypes(TemporalTypes temporalTypes) {
        this.temporalTypes = temporalTypes;
    }
}
