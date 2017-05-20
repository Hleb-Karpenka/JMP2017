package com.epam.trainings.mentoring.jpa.domain.extended;

import javax.persistence.Embeddable;
import java.math.BigInteger;

@Embeddable
public class PrimitiveTypes {
    private byte mappingByte;
    private Byte mappingByte2;

    private short mappingShort;
    private Short mappingShort2;

    private int mappingInt;
    private Integer mappingInt2;

    private long mappingLong;
    private Long mappingLong2;

    private char mappingChar;
    private Character mappingCharacter;

    private String mappingString;

    private boolean mappingBoolean;
    private Boolean mappingBoolean2;

    private double mappingDouble;
    private Double mappingDouble2;

    private BigInteger mappingBigInteger;


    public byte getMappingByte() {
        return mappingByte;
    }

    public void setMappingByte(byte mappingByte) {
        this.mappingByte = mappingByte;
    }

    public Byte getMappingByte2() {
        return mappingByte2;
    }

    public void setMappingByte2(Byte mappingByte2) {
        this.mappingByte2 = mappingByte2;
    }

    public short getMappingShort() {
        return mappingShort;
    }

    public void setMappingShort(short mappingShort) {
        this.mappingShort = mappingShort;
    }

    public Short getMappingShort2() {
        return mappingShort2;
    }

    public void setMappingShort2(Short mappingShort2) {
        this.mappingShort2 = mappingShort2;
    }

    public int getMappingInt() {
        return mappingInt;
    }

    public void setMappingInt(int mappingInt) {
        this.mappingInt = mappingInt;
    }

    public Integer getMappingInt2() {
        return mappingInt2;
    }

    public void setMappingInt2(Integer mappingInt2) {
        this.mappingInt2 = mappingInt2;
    }

    public long getMappingLong() {
        return mappingLong;
    }

    public void setMappingLong(long mappingLong) {
        this.mappingLong = mappingLong;
    }

    public Long getMappingLong2() {
        return mappingLong2;
    }

    public void setMappingLong2(Long mappingLong2) {
        this.mappingLong2 = mappingLong2;
    }

    public char getMappingChar() {
        return mappingChar;
    }

    public void setMappingChar(char mappingChar) {
        this.mappingChar = mappingChar;
    }

    public Character getMappingCharacter() {
        return mappingCharacter;
    }

    public void setMappingCharacter(Character mappingCharacter) {
        this.mappingCharacter = mappingCharacter;
    }

    public String getMappingString() {
        return mappingString;
    }

    public void setMappingString(String mappingString) {
        this.mappingString = mappingString;
    }

    public boolean isMappingBoolean() {
        return mappingBoolean;
    }

    public void setMappingBoolean(boolean mappingBoolean) {
        this.mappingBoolean = mappingBoolean;
    }

    public Boolean getMappingBoolean2() {
        return mappingBoolean2;
    }

    public void setMappingBoolean2(Boolean mappingBoolean2) {
        this.mappingBoolean2 = mappingBoolean2;
    }

    public double getMappingDouble() {
        return mappingDouble;
    }

    public void setMappingDouble(double mappingDouble) {
        this.mappingDouble = mappingDouble;
    }

    public Double getMappingDouble2() {
        return mappingDouble2;
    }

    public void setMappingDouble2(Double mappingDouble2) {
        this.mappingDouble2 = mappingDouble2;
    }

    public BigInteger getMappingBigInteger() {
        return mappingBigInteger;
    }

    public void setMappingBigInteger(BigInteger mappingBigInteger) {
        this.mappingBigInteger = mappingBigInteger;
    }
}
