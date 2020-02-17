package Services.Relationships;

import model.FamilyMember;

import java.util.LinkedHashMap;

public interface InitFamilyTreeService {

    String addFirstAncestor(String memberName, String gender, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails);

}
