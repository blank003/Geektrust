package Services.Relationships;

import model.FamilyMember;
import java.util.LinkedHashMap;

public interface SpouseService {

    String addHusband(String memberName, String spouseName, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails);
    String addWife(String memberName, String spouseName, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails);
}
