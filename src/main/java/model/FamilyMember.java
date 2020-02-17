package model;

import java.util.List;

public class FamilyMember {

    private String memberName;
    private String memberFatherName;
    private String memberMotherName;
    private String husbandName;
    private String wifeName;
    private List<String> brothersName;
    private List<String> sistersName;
    private List<String> sonsName;
    private List<String> daughtersName;
    private Gender gender;

    public FamilyMember() {

    }

    public Gender getGender() {
        return gender;
    }

    public String getHusbandName() {
        return husbandName;
    }

    public String getWifeName() {
        return wifeName;
    }


    public String getMemberName() {
        return memberName;
    }

    public String getMemberFatherName() {
        return memberFatherName;
    }

    public String getMemberMotherName() {
        return memberMotherName;
    }

    public List<String> getBrothersName() {
        return brothersName;
    }

    public List<String> getSonsName() {
        return sonsName;
    }

    public List<String> getSistersName() {
        return sistersName;
    }


    public List<String> getDaughtersName() {
        return daughtersName;
    }

    public FamilyMember(String memberName, String memberFatherName, String memberMotherName, String husbandName, String wifeName, List<String> brothersName, List<String> sistersName, List<String> sonsName, List<String> daughtersName, Gender gender) {
        this.memberName = memberName;
        this.memberFatherName = memberFatherName;
        this.memberMotherName = memberMotherName;
        this.husbandName = husbandName;
        this.wifeName = wifeName;
        this.brothersName = brothersName;
        this.sistersName = sistersName;
        this.sonsName = sonsName;
        this.daughtersName = daughtersName;
        this.gender = gender;
    }

    public void addChild(String childName, String gender) {
        switch (gender) {
            case "Female":
                this.addDaughter(childName);
                break;
            case "Male":
                this.addSon(childName);
                break;

        }
    }

    public void addHusband(String husbandName) {
        this.husbandName = husbandName;
    }

    public void addWife(String wifeName) {
        this.wifeName = wifeName;
    }

    public void addSon(String sonName) {
        this.sonsName.add(sonName);
    }

    public void addDaughter(String daughterName) {
        this.daughtersName.add(daughterName);
    }

    public void addBrother(String brotherName) {
        this.brothersName.add(brotherName);
    }

    public void addSister(String sisterName) {
        this.sistersName.add(sisterName);
    }

    public void addMother(String motherName) {
        this.memberMotherName = motherName;
    }

    public void addFather(String fatherName) {
        this.memberFatherName = fatherName;
    }

    public void addGender(Gender gender) {
        this.gender = gender;
    }

    public void addMember(String memberName) {
        this.memberName = memberName;
    }

}
