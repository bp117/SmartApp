import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class SampleMismo {
	 public static void main(String[] args) throws JSONException {
         
         System.out.println("Input.... ");
        
         String borrower = "{\"#\":\"a\",\"ALIASES\": {\"ALIAS\": {\"ALIAS_DETAIL\": {\"AliasAccountIdentifier\": null,\"AliasCreditorName\": null,\"AliasTaxReturnIndicator\": null,\"AliasType\": null,\"AliasTypeOtherDescription\": null},\"NAME\": {\"EducationalAchievementsDescription\": null,\"FirstName\": null,\"FullName\": null,\"FunctionalTitleDescription\": null,\"IndividualTitleDescription\": null,\"LastName\": null,\"MiddleName\": null,\"PrefixName\": null,\"SuffixName\": null}}},\"BORROWER_DETAIL\": {\"AutomobilesOwnedCount\": null,\"BorrowerAgeAtApplicationYearsCount\": null,\"BorrowerApplicationSignedDate\": null,\"BorrowerBankruptcyIndicator\": null,\"BorrowerBirthDate\": null,\"BorrowerCharacteristicType\": null,\"BorrowerCharacteristicTypeOtherDescription\": null,\"BorrowerClassificationType\": null,\"BorrowerIsAnIndividualPersonIndicator\": null,\"BorrowerMailToAddressSameAsPropertyIndicator\": null,\"BorrowerQualifyingIncomeAmount\": null,\"BorrowerRelationshipTitleType\": null,\"BorrowerRelationshipTitleTypeOtherDescription\": null,\"BorrowerSameAsBuilderIndicator\": null,\"BorrowerTotalMortgagedPropertiesCount\": null,\"CommunityPropertyStateResidentIndicator\": null,\"CreditFileBorrowerAgeYearsCount\": null,\"CreditReportAuthorizationIndicator\": null,\"CreditReportIdentifier\": null,\"DependentCount\": null,\"DomesticRelationshipIndicator\": null,\"DomesticRelationshipStateCode\": null,\"DomesticRelationshipType\": null,\"DomesticRelationshipTypeOtherDescription\": null,\"EmploymentStateType\": null,\"EmploymentStateTypeOtherDescription\": null,\"HousingCounselingRequiredIndicator\": null,\"IntentToProceedWithLoanTransactionIndicatedDate\": null,\"JointAssetLiabilityReportingType\": null,\"MaritalStatusType\": null,\"MaritalStatusTypeOtherDescription\": null,\"SchoolingYearsCount\": null,\"SelfDeclaredMilitaryServiceIndicator\": null,\"SignedAuthorizationToRequestTaxRecordsIndicator\": null,\"SpousalVABenefitsEligibilityIndicator\": null,\"TaxRecordsObtainedIndicator\": null},\"NAME\": {\"EducationalAchievementsDescription\": null,\"FirstName\": null,\"FullName\": null,\"FunctionalTitleDescription\": null,\"IndividualTitleDescription\": null,\"LastName\": null,\"MiddleName\": null,\"PrefixName\": null,\"SuffixName\": null}}";
         String output1 = validateOrModifyJson(borrower);
         String output2 = buildMismoXml(output1);
        
         // System.out.println(output1);
         System.out.println(output2);
}

/**
* We can modify json before sending it to buildMismoXml
* @param jsonData
* @return
 * @throws JSONException 
*/
public static String validateOrModifyJson(String jsonData) throws JSONException {
        
         JSONObject jsonObj = new JSONObject(jsonData);

         jsonObj.remove("#");
         jsonObj.remove("@xmlns:0");
         jsonObj.remove("?0");
         jsonObj.remove("@xsi:1");
         jsonObj.remove("@SequenceNumber");
        
         return jsonObj.toString();
        
        
}


public static String buildMismoXml(String jsonData ) throws JSONException {
        
         String outputXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                                         + "<BORROWER xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                                         + "xsi:noNamespaceSchemaLocation=\"BORROWER.xsd\">";
        
         JSONObject jsonObj = new JSONObject(jsonData);
        
         outputXml = outputXml + XML.toString(jsonObj) + "</BORROWER>";

         return outputXml;
}
}
