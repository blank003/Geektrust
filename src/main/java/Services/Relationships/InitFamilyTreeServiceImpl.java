package Services.Relationships;


import constants.FamilyTreeConstants;
import model.FamilyMember;
import model.Gender;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class InitFamilyTreeServiceImpl implements InitFamilyTreeService {

    @Override
    public String addFirstAncestor(String memberName, String gender, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails) {

        FamilyMember newFamilyMember = new FamilyMember(memberName,null,null,null,null,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),getGender(gender));
        allFamilyMemberDetails.put(memberName, newFamilyMember);
        return FamilyTreeConstants.AncestorAdditionSucceeded;
    }

    private Gender getGender(String gender) {
        if(gender.equals("Female")){
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }
}
