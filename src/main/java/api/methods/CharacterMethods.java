package api.methods;


public class CharacterMethods {

//  public boolean getAllCharacter(String desiredPath) {
//      boolean status = false;
//      try {
//          Response response = ResponseBody.getResponse("", "",AutomationConstants.apiURL + desiredPath);
//
//          AllCharacter allCharacter = CommonLib.getResponse(response.asPrettyString(), AllCharacter.class);
//
//          AutomationConstants.responseData = response.asPrettyString();
//
//          if (!Objects.requireNonNull(allCharacter).info.getCount().toString().isEmpty()) {
//              status = true;
//              CommonLib.allureReport("PASS", "All characters appear to arrive correctly.");
//          } else {
//              CommonLib.allureReport("FAIL", "It has been seen that the characters do not come up properly.");
//
//          }
//      } catch (Exception e) {
//          CommonLib.allureReport("FAIL", "There was an error in the arrival of all the characters.");
//      }
//      return status;
//  }
//
//  public boolean controlAllCharacterForName(String desiredData) {
//      boolean status = false;
//      try {
//          AllCharacter allCharacter = CommonLib.getResponse(AutomationConstants.responseData, AllCharacter.class);
//
//          for (Result data : Objects.requireNonNull(allCharacter).results) {
//              if (CommonLib.controlText(data.getName(), desiredData)) {
//                  status = true;
//                  CommonLib.allureReport("PASS", "Desired character name appear to arrive correctly.");
//              }
//          }
//      } catch (Exception e) {
//          CommonLib.allureReport("FAIL", "An error was encountered while checking all characters.");
//      }
//      return status;
//  }
//
//  public boolean getSpesificCharacterWithFilterParameter(String desiredPath, String name, String status, String species, String type, String gender) {
//      boolean bool = false;
//      try {
//
//          Map<String, String> map = CommonLib.queryMap(name, status, species, type, gender);
//
//          Response response = ResponseBody.getResponse("", "",
//                  AutomationConstants.apiURL + desiredPath, map);
//
//          JsonPath js = new JsonPath(response.asPrettyString());
//
//          String result = js.getString("results.name");
//
//          if (result.contains("Rick Sanchez")) {
//              bool = true;
//              CommonLib.allureReport("PASS", "All characters appear to arrive correctly.");
//          } else {
//              CommonLib.allureReport("FAIL", "It has been seen that the characters do not come up properly.");
//
//          }
//      } catch (Exception e) {
//          CommonLib.allureReport("FAIL", "There was an error in the arrival of all the characters.");
//      }
//      return bool;
//  }
}
