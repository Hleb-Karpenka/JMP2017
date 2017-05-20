package com.epam.trainings.mentoring.jpa.domain.extended;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class TemporalTypes {

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Temporal(TemporalType.TIME)
    private Date hiringDay;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dismissalDay;


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getHiringDay() {
        return hiringDay;
    }

    public void setHiringDay(Date hiringDay) {
        this.hiringDay = hiringDay;
    }

    public Date getDismissalDay() {
        return dismissalDay;
    }

    public void setDismissalDay(Date dismissalDay) {
        this.dismissalDay = dismissalDay;
    }
}
