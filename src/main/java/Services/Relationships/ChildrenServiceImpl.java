package Services.Relationships;
import constants.FamilyTreeConstants;
import model.FamilyMember;
import model.Gender;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ChildrenServiceImpl implements ChildrenService {

    @Override
    public String addChild(String mothersName, String childName, String gender, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails) {
        FamilyMember mother = allFamilyMemberDetails.get(mothersName);
        if(mother == null) {
            return FamilyTreeConstants.ChildAdditionFailed;
        }
        String fatherName = mother.getHusbandName();
        FamilyMember father = new FamilyMember();
        if(!fatherName.isEmpty()) {
            father = allFamilyMemberDetails.get(fatherName);
        }
        FamilyMember child = new FamilyMember(childName,fatherName,mothersName,null,null,mother.getSonsName(),mother.getDaughtersName(),new ArrayList<>(),new ArrayList<>(),getGender(gender));
        allFamilyMemberDetails.put(childName, child);
        mother.addChild(childName,gender);
        if(father != null){
            father.addChild(childName,gender);
        }
        return FamilyTreeConstants.ChildAdditionSucceeded;
    }

    private Gender getGender(String gender) {
        if(gender.equals("Female")){
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }

}
