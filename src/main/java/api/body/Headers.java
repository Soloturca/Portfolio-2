package api.body;

import io.restassured.http.Header;

public class Headers {
    static Header header1 = new Header("Content-Type", "application/json");
    static Header header2 = new Header("User-Agent", "PostmanRuntime/7.28.4");
    static  Header header3 = new Header("Accept", "*/*");
    static Header header4 = new Header("Accept-Encoding", "gzip, deflate, br");
    static Header header5 = new Header("Connection", "keep-alive");
    static io.restassured.http.Headers headers = new io.restassured.http.Headers(header1, header2, header3, header4, header5);
}
