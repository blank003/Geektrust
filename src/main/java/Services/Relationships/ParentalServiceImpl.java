package Services.Relationships;

import constants.FamilyTreeConstants;
import model.FamilyMember;

import java.util.LinkedHashMap;
import java.util.List;

public class ParentalServiceImpl implements ParentalService {

    @Override
    public String findFather(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if(allFamilyMembers.get(memberName).getMemberFatherName()!=null) {
            return allFamilyMembers.get(memberName).getMemberFatherName();
        }
        else {
            return FamilyTreeConstants.PersonNotFound;
        }
    }

    @Override
    public String findMother(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if(allFamilyMembers.get(memberName).getMemberMotherName()!=null) {
            return allFamilyMembers.get(memberName).getMemberMotherName();
        }
        else{
            return FamilyTreeConstants.PersonNotFound;
        }
    }

    @Override
    public String findAllSons(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        List<String> allSons = allFamilyMembers.get(memberName).getSonsName();
        if(allSons.isEmpty()){
            return FamilyTreeConstants.PersonNotFound;
        } else {
            return String.join(" ", allSons);
        }
    }

    @Override
    public String findAllDaughters(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {

        List<String> allDaughters = allFamilyMembers.get(memberName).getDaughtersName();
        if(allDaughters.isEmpty()){
            return FamilyTreeConstants.PersonNotFound;
        }
        else {
            return String.join(" ", allDaughters);
        }
    }
}
