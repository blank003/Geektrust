package Services.Relationships;

import model.FamilyMember;
import java.util.LinkedHashMap;

public interface ParentalService {
    String findFather(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
    String findMother(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
    String findAllSons(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
    String findAllDaughters(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);

}
