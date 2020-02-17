Commands to Run the Project:

To compile the program:

1->  javac --class-path src/ src/com/company/Index.java -d ./out/

/* {scr/} is the path to the project directory and /out is the directory for the build */

To Run the program:

1->java -cp out/ src/com/company/Index.java


About the Project:-

1:>  The program supports the following input types:

    a. File Input
    b. CommandLine Input

    For the File Input pass the input file path along with the run command given above.
    For CommandLine Input just run the above command.

    (Note: To Exit from commandline enter "Exit" as input )

2:> Program Features:

    The Program Supports the following features:
    a. ADD_CHILD
    b. ADD_FIRST_ANCESTOR
    c. ADD_HUSBAND
    d. ADD_WIFE
    e. GET_RELATIONSHIP

    The first 4 commands are used to add new member in the familyTree and the 5th command is used to fetch the relationship between the family Members

    Input Pattern:
    a. ADD_CHILD
        To add a child the following command structure is used:
        ADD_CHILD "MOTHER_NAME" "CHILD_NAME" "GENDER"          Example:  ADD_CHILD ANYA MONTY Male

    b. ADD_FIRST_ANCESTOR
        To Add the first ancestor in the tree the following command is used:
        ADD_FIRST_ANCESTOR "MemberName" "Gender"    Example: ADD_FIRST_ANCESTOR Anya Female

        (Note: The can only be a single ancestor in a family tree)

    c. ADD_HUSBAND
        To add a husband relation the following command is used:
        ADD_HUSBAND "MemberName" "SpouseName" ADD_HUSBAND SHANKS ANYA

    d. ADD_WIFE
        To add a wife relation the following command is used:
        ADD_WIFE "MemberName" "SpouseName" ADD_WIFE ANYA SHANKS

    e.GET_RELATIONSHIP
        To find a relationship the following command is used:
        GET_RELATIONSHIP ”Name” “Relationship”      Example: GET_RELATIONSHIP MONTY Mother


    The output of the generated result will be displayed onto the console.