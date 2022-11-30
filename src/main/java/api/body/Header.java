package api.body;

import base.AutomationConstants;

public class Header {
    static io.restassured.http.Header header1 = new io.restassured.http.Header("Content-Type", "application/json");
    static io.restassured.http.Header header2 = new io.restassured.http.Header("User-Agent", "PostmanRuntime/7.28.4");
    static io.restassured.http.Header header3 = new io.restassured.http.Header("Accept", "*/*");
    static io.restassured.http.Header header4 = new io.restassured.http.Header("Accept-Encoding", "gzip, deflate, br");
    static io.restassured.http.Header header5 = new io.restassured.http.Header("Connection", "keep-alive");

    static io.restassured.http.Header header6 = new io.restassured.http.Header("Authorization", "Bearer" + AutomationConstants.token);
    static io.restassured.http.Headers headers = new io.restassured.http.Headers(header1, header2, header3, header4, header5, header6);
}
