package Services.Relationships;

import constants.FamilyTreeConstants;
import model.FamilyMember;

import java.util.LinkedHashMap;
import java.util.List;

public class PaternalServiceImpl implements PaternalService {

    @Override
    public String findAllPaternalUncles(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if( allFamilyMembers.get(memberName).getMemberFatherName()!= null) {
            String memberFather = allFamilyMembers.get(memberName).getMemberFatherName() ;
            List<String> allPaternalUncles = allFamilyMembers.get(memberFather).getBrothersName();
            if(allPaternalUncles.isEmpty()) {
                return FamilyTreeConstants.PersonNotFound;
            } else {
                return String.join(" ",allPaternalUncles);
            }
        }
        else {
            return FamilyTreeConstants.PersonNotFound;
        }
    }

    @Override
    public String findAllPaternalAunt(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if( allFamilyMembers.get(memberName).getMemberFatherName()!= null) {
            String memberFather = allFamilyMembers.get(memberName).getMemberFatherName() ;
            List<String> allPaternalAunts = allFamilyMembers.get(memberFather).getSistersName();
            if(allPaternalAunts.isEmpty()) {
                return FamilyTreeConstants.PersonNotFound;
            } else {
                return String.join(" ", allPaternalAunts);
            }
        }
        else {
            return FamilyTreeConstants.PersonNotFound;
        }
    }

}
