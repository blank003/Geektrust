package parser;

import controller.FamilyTreeController;
import model.FamilyMember;
import model.QueryRequest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class InputParser {

    FamilyTreeController familyTreeController = new FamilyTreeController();
    LinkedHashMap<String, FamilyMember> allFamilyMembers = new LinkedHashMap<>();

    public void parseViaFile(BufferedReader br) throws IOException{
        init();
        System.out.println("THE OUTPUT FOR THE PROVIDED FILE INPUT STARTS FROM BELOW :");
        String query;
        while((query = br.readLine())!=null) {
            checkForErrorAndExecute(query);
        }
    }

    private void checkForErrorAndExecute(String input) {
        QueryRequest queryRequest = new QueryRequest(input);
        if(queryRequest.getErrorMessage()==null) {
            parseQuery(queryRequest);
        } else {
            System.out.println("INVALID_ARGUMENTS");
        }
    }

    public void parseViaCommandLine() throws IOException {
        init();
        System.out.println("Enter commands");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if(input.contains("Exit"))break;
            checkForErrorAndExecute(input);

        }
    }

    private void parseQuery(QueryRequest queryRequest) {
        if(queryRequest.getAddQuery()) {
            String output = familyTreeController.addMemberToFamilyTree(queryRequest, allFamilyMembers);
            System.out.println(output);
        } else  {
            String output = familyTreeController.getRelationshipBetweenMembers(queryRequest, allFamilyMembers);
            System.out.println(output);
        }
    }

    private void init() throws IOException {
        File inFile = new File("/Users/Kartikeya 1/Documents/Important_Data/IdeaProjects/MeetTheFamily/src/main/java/parser/defaultInput.txt");
        if(inFile!=null) {
            BufferedReader br = new BufferedReader(new FileReader(inFile));
            String query;
            while((query = br.readLine())!=null) {
                checkForErrorAndExecute(query);

            }
        }
    }
}
