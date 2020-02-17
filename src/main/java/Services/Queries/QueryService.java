package Services.Queries;

import model.FamilyMember;
import model.QueryRequest;

import java.util.LinkedHashMap;

public interface QueryService {


    String addMemberToFamilyTree(QueryRequest queryRequest, LinkedHashMap<String, FamilyMember> allFamilyMembers);

    String getRelationshipBetweenFamilyMembers(QueryRequest queryRequest, LinkedHashMap<String, FamilyMember> allFamilyMembers);
}
