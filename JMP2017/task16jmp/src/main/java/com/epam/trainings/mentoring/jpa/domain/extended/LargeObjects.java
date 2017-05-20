package com.epam.trainings.mentoring.jpa.domain.extended;

import javax.persistence.*;

@Embeddable
public class LargeObjects {

    @Lob
    @Column(name = "PROFILE_PHOTO")
    private byte[] profilePhoto;
    @Lob
    @Column(name = "SKYPE_PHOTO")
    @Basic(fetch = FetchType.LAZY)
    private Byte[] skypePhoto;
    @Lob
    @Column(name = "HISTORY")
    private History history;
    @Lob
    @Column(name = "REVIEWS")
    @Basic(fetch = FetchType.LAZY)
    private String reviews;
    @Lob
    @Column(name = "DOCS")
    @Basic(fetch = FetchType.LAZY)
    private char[] documentation;
    @Lob
    @Column(name = "ADDITIONAL_INFO")
    @Basic(fetch = FetchType.LAZY)
    private Character[] additionalInfo;

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Byte[] getSkypePhoto() {
        return skypePhoto;
    }

    public void setSkypePhoto(Byte[] skypePhoto) {
        this.skypePhoto = skypePhoto;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public char[] getDocumentation() {
        return documentation;
    }

    public void setDocumentation(char[] documentation) {
        this.documentation = documentation;
    }

    public Character[] getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Character[] additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
