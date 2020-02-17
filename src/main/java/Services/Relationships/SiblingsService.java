package Services.Relationships;

import model.FamilyMember;
import java.util.LinkedHashMap;

public interface SiblingsService {

    String findAllSiblings(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);

}
