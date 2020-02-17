package Services.Relationships;

import constants.FamilyTreeConstants;
import model.FamilyMember;
import model.Gender;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SpouseServiceImpl implements SpouseService {

    @Override
    public String addHusband(String husbandName, String wifeName, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails) {
        FamilyMember wife = allFamilyMemberDetails.get(wifeName);
        if(wife == null) {
            return FamilyTreeConstants.PersonNotFound;
        }

        if(allFamilyMemberDetails.get(wifeName).getGender() == Gender.MALE) {
            return FamilyTreeConstants.HusbandAdditionFailed;
        }

        wife.addHusband(husbandName);
        FamilyMember husband = new FamilyMember(husbandName,null,null,null,wifeName,new ArrayList<>(),new ArrayList<>(),wife.getSonsName(),wife.getDaughtersName(),Gender.MALE);
        allFamilyMemberDetails.put(husbandName,husband);
        return FamilyTreeConstants.HusbandAdditionSucceeded;
    }

    @Override
    public String addWife(String wifeName, String husbandName, LinkedHashMap<String, FamilyMember> allFamilyMemberDetails) {
        FamilyMember husband = allFamilyMemberDetails.get(husbandName);
        if(husband == null) {
            return FamilyTreeConstants.PersonNotFound;
        }

        if(allFamilyMemberDetails.get(husbandName).getGender() == Gender.FEMALE) {
            return FamilyTreeConstants.WifeAdditionFailed;
        }

        husband.addWife(wifeName);
        FamilyMember wife = new FamilyMember(wifeName,null,null,husbandName,null,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),Gender.FEMALE);
        allFamilyMemberDetails.put(wifeName,wife);
        return FamilyTreeConstants.WifeAdditionSucceeded;

    }

}
