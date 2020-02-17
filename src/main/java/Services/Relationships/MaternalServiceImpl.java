package Services.Relationships;

import constants.FamilyTreeConstants;
import model.FamilyMember;
import java.util.LinkedHashMap;
import java.util.List;

public class MaternalServiceImpl implements MaternalService {

    @Override
    public String findAllMaternalUncles(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if( allFamilyMembers.get(memberName).getMemberMotherName()!= null) {
            String memberMother = allFamilyMembers.get(memberName).getMemberMotherName() ;
            List<String> allMaternalUncles = allFamilyMembers.get(memberMother).getBrothersName();
            if(allMaternalUncles.isEmpty()) {
                return FamilyTreeConstants.PersonNotFound ;
            } else {
                return String.join(" ", allMaternalUncles);
            }
        }
        else {
            return FamilyTreeConstants.PersonNotFound;
        }
    }


    @Override
    public String findAllMaternalAunt(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if( allFamilyMembers.get(memberName).getMemberMotherName()!= null) {
            String memberMother = allFamilyMembers.get(memberName).getMemberMotherName() ;
            List<String> allMaternalAunt = allFamilyMembers.get(memberMother).getSistersName();
            if(allMaternalAunt.isEmpty()) {
                return FamilyTreeConstants.PersonNotFound;
            } else {
                return String.join(" ", allMaternalAunt);
            }
        }
        else {
            return FamilyTreeConstants.PersonNotFound;
        }
    }

}
