package api.body;

import api.model.SOAP.*;

public class RequestBody {
    public void testAdsatGetimsi() {
        Envelope envelope = new Envelope();
        Header header=new Header();
        envelope.setHlr("");
        envelope.setHead("");
        envelope.setV1("");
        Body body=new Body();
        ResetSGSN_v1 resetSGSN_v1= new ResetSGSN_v1();
        header.setRequestId("test_adsat_Getimsi");
        header.setSourceSystem("Siebel");
        header.setReplyExpected("Now");
        header.setQoS("R");
        header.setPriority(3);

        //Credentials
        Credentials credentials= new Credentials();
        credentials.setUser("IBM_SADMIN");
        credentials.setApplicationId("SBL");
        header.setCredentials(credentials);

        //Attributes
        Attributes attributes= new Attributes();
        Attribute attribute=new Attribute();
        attribute.setName("OriginalSourceSyste");
        attribute.setValue("Siebel");
        attributes.setAttribute(attribute);
        header.setAttributes(attributes);

        //Add header
        resetSGSN_v1.setHeader(header);

        //Request
        Request request=new Request();
        request.setIMSI("");
    }
}
