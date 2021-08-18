package com.polestar.study;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Study {

    private String patientId;
    private String patientName;

    public Study(){

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "study{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';
    }

}
