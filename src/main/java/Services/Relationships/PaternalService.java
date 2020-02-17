package Services.Relationships;

import model.FamilyMember;

import java.util.LinkedHashMap;

public interface PaternalService {

    String findAllPaternalUncles(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
    String findAllPaternalAunt(String memberName, LinkedHashMap<String, FamilyMember> allFamilyMembers);
}
