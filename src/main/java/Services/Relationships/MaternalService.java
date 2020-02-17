package Services.Relationships;

import model.FamilyMember;
import java.util.LinkedHashMap;

public interface MaternalService {

    String findAllMaternalUncles(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
    String findAllMaternalAunt(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);

}
