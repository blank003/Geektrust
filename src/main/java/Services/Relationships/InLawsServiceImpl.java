package Services.Relationships;

import constants.FamilyTreeConstants;
import model.FamilyMember;
import model.Gender;

import java.util.LinkedHashMap;
import java.util.List;

public class InLawsServiceImpl implements InLawsService {

    @Override
    public String findAllSisterInLaws(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {

        if(allFamilyMembers.get(memberName).getGender().equals(Gender.FEMALE)) {
            if(allFamilyMembers.get(memberName).getHusbandName()!=null) {
                String husbandName = allFamilyMembers.get(memberName).getHusbandName();
                List<String> allSisterInLaws = allFamilyMembers.get(husbandName).getSistersName();
                List<String> allBrothers = allFamilyMembers.get(memberName).getBrothersName();
                for(String brother : allBrothers) {
                    String sisterInLaw = allFamilyMembers.get(brother).getWifeName();
                    if(sisterInLaw!=null) {
                        allSisterInLaws.add(sisterInLaw);
                    }
                }
                if(allSisterInLaws.isEmpty()) {
                    return FamilyTreeConstants.PersonNotFound ;
                } else {
                    return String.join(" ", allSisterInLaws);
                }
            } else {
                return FamilyTreeConstants.PersonNotFound;
            }
        } else {
            if(allFamilyMembers.get(memberName).getGender().equals(Gender.MALE)) {
                if(allFamilyMembers.get(memberName).getWifeName()!=null) {
                    String wifeName = allFamilyMembers.get(memberName).getWifeName();
                    List<String> allSisterInLaws = allFamilyMembers.get(wifeName).getSistersName();
                    List<String> allBrothers = allFamilyMembers.get(memberName).getBrothersName();
                    for(String brother : allBrothers) {
                        String sisterInLaw = allFamilyMembers.get(brother).getWifeName();
                        if(sisterInLaw!=null) {
                            allSisterInLaws.add(sisterInLaw);
                        }
                    }
                    if(allSisterInLaws.isEmpty()) {
                        return FamilyTreeConstants.PersonNotFound;
                    } else {
                        return String.join(" ", allSisterInLaws);
                    }
                } else {
                    return FamilyTreeConstants.PersonNotFound;
                }
            }else {
                return FamilyTreeConstants.PersonNotFound;
            }
        }
    }

    @Override
    public String findAllBrotherInLaws(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {

        if(allFamilyMembers.get(memberName).getGender().equals(Gender.FEMALE)) {
            if(allFamilyMembers.get(memberName).getHusbandName()!=null) {
                String husbandName = allFamilyMembers.get(memberName).getHusbandName();
                List<String> allBrotherInLaws = allFamilyMembers.get(husbandName).getBrothersName();
                List<String> allSisters = allFamilyMembers.get(memberName).getSistersName();
                for(String sister : allSisters) {
                    String brotherInLaw = allFamilyMembers.get(sister).getHusbandName();
                    if(brotherInLaw!=null) {
                        allBrotherInLaws.add(brotherInLaw);
                    }
                }
                if(allBrotherInLaws.isEmpty()) {
                    return FamilyTreeConstants.PersonNotFound;
                } else {
                    return String.join(" ", allBrotherInLaws);
                }
            } else {
                return FamilyTreeConstants.PersonNotFound;
            }
        } else {
            if(allFamilyMembers.get(memberName).getGender().equals(Gender.MALE)) {
                if(allFamilyMembers.get(memberName).getWifeName()!=null) {
                    String wifeName = allFamilyMembers.get(memberName).getWifeName();
                    List<String> allBrotherInLaws = allFamilyMembers.get(wifeName).getBrothersName();
                    List<String> allSisters = allFamilyMembers.get(memberName).getSistersName();
                    for(String sister : allSisters) {
                        String brotherInLaw = allFamilyMembers.get(sister).getHusbandName();
                        if(brotherInLaw!=null) {
                            allBrotherInLaws.add(brotherInLaw);
                        }
                    }
                    if(allBrotherInLaws.isEmpty()) {
                       return FamilyTreeConstants.PersonNotFound;
                    } else {
                        return String.join(" ", allBrotherInLaws);
                    }
                } else {
                    return FamilyTreeConstants.PersonNotFound;
                }
            }else {
                return FamilyTreeConstants.PersonNotFound;
            }
        }
    }

}
