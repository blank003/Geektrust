package Services.Relationships;
import model.FamilyMember;

import java.util.LinkedHashMap;

public interface InLawsService {

    String findAllSisterInLaws(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
    String findAllBrotherInLaws(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
}
