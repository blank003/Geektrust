package Services.Queries;

import Services.Relationships.*;
import constants.FamilyTreeConstants;
import model.FamilyMember;
import model.QueryRequest;

import java.util.LinkedHashMap;



public class QueryServiceImpl implements QueryService {


    private ParentalService getParentalRelationship = new ParentalServiceImpl();
    private PaternalService getPaternalRelationship = new PaternalServiceImpl();
    private MaternalService getMaternalRelationships = new MaternalServiceImpl();
    private SiblingsService getSiblingRelationships = new SiblingsServiceImpl();
    private InLawsService getInLawsRelationships = new InLawsServiceImpl();
    private InitFamilyTreeService initFamilyTreeService = new InitFamilyTreeServiceImpl();
    private SpouseService spouseService = new SpouseServiceImpl();
    private ChildrenService childrenService = new ChildrenServiceImpl();

    @Override
    public String addMemberToFamilyTree(QueryRequest queryRequest, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        switch (queryRequest.getQueryType()) {
            case ADD_CHILD:
                if(checkIfMemberExist(queryRequest.getOldMember(),allFamilyMembers)){
                    return childrenService.addChild(queryRequest.getOldMember(),queryRequest.getNewMember(),queryRequest.getGender(), allFamilyMembers);
                }
                return FamilyTreeConstants.PersonNotFound;
            case ADD_FIRST_ANCESTOR:
                return initFamilyTreeService.addFirstAncestor(queryRequest.getNewMember(), queryRequest.getGender(), allFamilyMembers);
            case ADD_WIFE:
                if(checkIfMemberExist(queryRequest.getOldMember(), allFamilyMembers)) {
                    return spouseService.addWife(queryRequest.getNewMember(), queryRequest.getOldMember(), allFamilyMembers);
                }
                return FamilyTreeConstants.PersonNotFound;
            case ADD_HUSBAND:
                if(checkIfMemberExist(queryRequest.getOldMember(), allFamilyMembers)) {
                    return spouseService.addHusband(queryRequest.getNewMember(), queryRequest.getOldMember(), allFamilyMembers);
                }
                    return FamilyTreeConstants.PersonNotFound;
            default:
                return FamilyTreeConstants.InvalidQuery;

        }
    }

    @Override
    public String getRelationshipBetweenFamilyMembers(QueryRequest queryRequest, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        if(allFamilyMembers.containsKey(queryRequest.getOldMember())) {
            String oldMember = queryRequest.getOldMember();
            switch (queryRequest.getRelationship()) {
                case PaternalUncle:
                    return getPaternalRelationship.findAllPaternalUncles(oldMember, allFamilyMembers);
                case MaternalUncle:
                    return getMaternalRelationships.findAllMaternalUncles(oldMember, allFamilyMembers);
                case PaternalAunt:
                    return getPaternalRelationship.findAllPaternalAunt(oldMember, allFamilyMembers);
                case MaternalAunt:
                    return getMaternalRelationships.findAllMaternalAunt(oldMember, allFamilyMembers);
                case SisterInLaw:
                    return getInLawsRelationships.findAllSisterInLaws(oldMember, allFamilyMembers);
                case BrotherInLaw:
                    return getInLawsRelationships.findAllBrotherInLaws(oldMember, allFamilyMembers);
                case Son:
                    return getParentalRelationship.findAllSons(oldMember, allFamilyMembers);
                case Daughter:
                    return getParentalRelationship.findAllDaughters(oldMember, allFamilyMembers);
                case Siblings:
                    return getSiblingRelationships.findAllSiblings(oldMember, allFamilyMembers);
                case Father:
                    return getParentalRelationship.findFather(oldMember, allFamilyMembers);
                case Mother:
                    return getParentalRelationship.findMother(oldMember, allFamilyMembers);
                default:
                    return FamilyTreeConstants.PersonNotFound;
            }

        }
        else {
            return FamilyTreeConstants.PersonNotFound;
        }
    }

    private boolean checkIfMemberExist(String member, LinkedHashMap<String, FamilyMember> allFamilyMembers) {
        return allFamilyMembers.containsKey(member);
    }
}
