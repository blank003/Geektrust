package Services.Relationships;

import model.FamilyMember;

import java.util.LinkedHashMap;

public interface ChildrenService {

    String addChild(String mothersName, String memberName, String gender, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails);

}
