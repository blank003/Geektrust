package Services.Relationships;

import constants.FamilyTreeConstants;
import model.FamilyMember;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SiblingsServiceImpl implements SiblingsService {

    @Override
    public String findAllSiblings(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        String motherName = allFamilyMembers.get(memberName).getMemberMotherName();
        List<String> allBrothers = allFamilyMembers.get(motherName).getSonsName();
        List<String> allSisters = allFamilyMembers.get(motherName).getDaughtersName();
        List<String> allSiblings = new ArrayList<>();
        if(allBrothers.isEmpty() && allSisters.isEmpty()) {
            System.out.println(FamilyTreeConstants.PersonNotFound);
        }
        else {
            for(String brother : allBrothers) {
                if(!brother.equals(memberName)){
                    allSiblings.add(brother);
                }
            }
            for (String sister : allSisters) {
                if(!sister.equals(memberName)){
                    allSiblings.add(sister);
                }
            }
            return String.join(" ", allSiblings);
        }
        return motherName;
    }
}
