import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EditIssueTests {
    String sessionId = "";
    String projectId = "10502";
    String issueType = "13561";

    @BeforeTest(groups = {"CRITICAL,HTTP"})
    public void authentication(){
        RestAssured.baseURI = "http://jira.hillel.it:8080";
        String credentialsJSON = "{" +
                "\"username\": \"qa_auto_5_team_1\"," +
                "\"password\": \"qa_auto_5_team_1\"" +
                "} "
                ;

        /* HTTP Requests for login*/
        sessionId = given().
            header("Content-Type", "application/json").
            body(credentialsJSON).
            when().
            post("/rest/auth/1/session").
            then().
            extract().
            path("session.value");

        System.out.printf("\nSESSION: "+ sessionId);
}


    @Test(groups = {"Regression, HTTP"},dependsOnGroups = {"CRITICAL,HTTP"})
    public void commentCRUD(){
        RestAssured.baseURI = "http://jira.hillel.it:8080";
        ValidatableResponse response;

         /* test data and parameters */

        String jsonForAddComment = "JSON for your test";
        String jsonForUpdateComment = "";

        // TO DO your test

    }

    @Test(groups = {"Regression, HTTP"},dependsOnGroups = {"CRITICAL,HTTP"})
    public void descriptionCRUD(){
        RestAssured.baseURI = "http://jira.hillel.it:8080";
        ValidatableResponse response;

         /* test data and parameters */

        String jsonForAddDescription = "JSON for your test";


        // TO DO your test
    }


}
