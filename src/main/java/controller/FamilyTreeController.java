package controller;

import Services.Queries.QueryService;
import Services.Queries.QueryServiceImpl;
import model.FamilyMember;
import model.QueryRequest;

import java.util.LinkedHashMap;

public class FamilyTreeController {


    private QueryService queryService = new QueryServiceImpl();

    public String addMemberToFamilyTree(QueryRequest queryRequest, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        return queryService.addMemberToFamilyTree(queryRequest, allFamilyMembers);

    }

    public String getRelationshipBetweenMembers(QueryRequest queryRequest, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        return queryService.getRelationshipBetweenFamilyMembers(queryRequest, allFamilyMembers);
    }
}
