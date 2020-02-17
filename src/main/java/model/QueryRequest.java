package model;
import constants.FamilyTreeConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.QueryType.*;
import static model.Relationship.*;

public class QueryRequest {

    private QueryType queryType;
    private Relationship relationship;
    private String oldMember;
    private String newMember;
    private Boolean isAddQuery;
    private String gender;
    private String errorMessage;


    public QueryRequest(String input) {
        this.isAddQuery = false;
        List<String> commandList = new ArrayList<>(Arrays.asList(input.split(" ")));
        this.queryType = getQueryType(input);
        if (!isCorrectQuery(commandList,queryType)){
            this.errorMessage = FamilyTreeConstants.InvalidQuery;
        }
        setUpQuery(commandList);
    }

    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNewMember(String newMember) {
        this.newMember = newMember;
    }

    public void setOldMember(String oldMember) {
        this.oldMember = oldMember;
    }

    public void setAddQuery(Boolean addQuery) {
        isAddQuery = addQuery;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }


    public QueryType getQueryType() {
        return queryType;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public String getOldMember() {
        return oldMember;
    }

    public String getNewMember() {
        return newMember;
    }

    public Boolean getAddQuery() {
        return isAddQuery;
    }

    public String getGender() {
        return gender;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private QueryType getQueryType(String inputCommands) {
        List<String> commandList = new ArrayList<>(Arrays.asList(inputCommands.split(" ")));
            switch (commandList.get(0)) {
                case "ADD_FIRST_ANCESTOR" :
                    return ADD_FIRST_ANCESTOR;
                case "ADD_CHILD":
                    return ADD_CHILD;
                case "ADD_HUSBAND":
                    return ADD_HUSBAND;
                case "ADD_WIFE":
                    return ADD_WIFE;
                case "GET_RELATIONSHIP":
                    return GET_RELATIONSHIP;
                default:
                    return QueryType.Unknown;
            }
    }

    private Relationship setRelationshipObject(List<String> commandList) {
        switch (commandList.get(2)) {
            case "Father" :
                return Father;
            case "Mother":
                return Mother;
            case "Siblings":
                return Siblings;
            case "BrotherInLaw":
                return BrotherInLaw;
            case "SisterInLaw":
                return SisterInLaw;
            case "PaternalAunt":
                return PaternalAunt;
            case "MaternalAunt":
                return MaternalAunt;
            case "MaternalUncle":
                return MaternalUncle;
            case "PaternalUncle":
                return PaternalUncle;
            case "Son":
                return Son;
            default:
                return Relationship.Unknown;
        }
    }

    private static boolean isCorrectQuery(List<String> commandList, QueryType queryType) {

        switch (queryType){
            case ADD_WIFE :
            case GET_RELATIONSHIP:
            case ADD_HUSBAND:
            case ADD_FIRST_ANCESTOR:
                return  commandList.size() == 3;
            case ADD_CHILD:
                return commandList.size() == 4;
            default:
                return false;
        }
    }

    private void setUpQuery(List<String> commandList) {
        if (this.queryType == GET_RELATIONSHIP) {

            this.relationship = setRelationshipObject(commandList);
            this.oldMember = commandList.get(2);
        } else {
                this.isAddQuery = true;
            switch (this.queryType){
                case ADD_WIFE:
                    this.newMember = commandList.get(1);
                    this.oldMember = commandList.get(2);
                    this.gender = FamilyTreeConstants.Female;
                    break;
                case ADD_HUSBAND:
                    this.newMember = commandList.get(1);
                    this.oldMember = commandList.get(2);
                    this.gender = FamilyTreeConstants.Male;
                    break;
                case ADD_FIRST_ANCESTOR:
                    this.newMember = commandList.get(1);
                    this.gender = commandList.get(2);
                    break;
                case ADD_CHILD:
                    this.oldMember = commandList.get(1);
                    this.newMember = commandList.get(2);
                    this.gender = commandList.get(3);
                    break;
                default:
                    this.errorMessage = FamilyTreeConstants.InvalidQuery;
            }

        }
    }
}
