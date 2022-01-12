package api.model.SOAP;

public class Header {
    public String getRequestId() {
        return this.RequestId;
    }

    public void setRequestId(String RequestId) {
        this.RequestId = RequestId;
    }

    String RequestId;

    public String getSourceSystem() {
        return this.SourceSystem;
    }

    public void setSourceSystem(String SourceSystem) {
        this.SourceSystem = SourceSystem;
    }

    String SourceSystem;

    public String getReplyExpected() {
        return this.ReplyExpected;
    }

    public void setReplyExpected(String ReplyExpected) {
        this.ReplyExpected = ReplyExpected;
    }

    String ReplyExpected;

    public String getQoS() {
        return this.QoS;
    }

    public void setQoS(String QoS) {
        this.QoS = QoS;
    }

    String QoS;

    public int getPriority() {
        return this.Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    int Priority;

    public Credentials getCredentials() {
        return this.Credentials;
    }

    public void setCredentials(Credentials Credentials) {
        this.Credentials = Credentials;
    }

    Credentials Credentials;

    public Attributes getAttributes() {
        return this.Attributes;
    }

    public void setAttributes(Attributes Attributes) {
        this.Attributes = Attributes;
    }

    Attributes Attributes;
}
