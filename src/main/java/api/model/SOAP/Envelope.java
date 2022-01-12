package api.model.SOAP;

public class Envelope {
    public Object getHeader() {
        return this.Header;
    }

    public void setHeader(Object Header) {
        this.Header = Header;
    }

    Object Header;

    public Body getBody() {
        return this.Body;
    }

    public void setBody(Body Body) {
        this.Body = Body;
    }

    Body Body;

    public String getSoapenv() {
        return this.Soapenv;
    }

    public void setSoapenv(String Soapenv) {
        this.Soapenv = Soapenv;
    }

    String Soapenv;

    public String getHlr() {
        return this.Hlr;
    }

    public void setHlr(String Hlr) {
        this.Hlr = Hlr;
    }

    String Hlr;

    public String getHead() {
        return this.Head;
    }

    public void setHead(String Head) {
        this.Head = Head;
    }

    String Head;

    public String getV1() {
        return this.V1;
    }

    public void setV1(String V1) {
        this.V1 = V1;
    }

    String V1;

    public String getText() {
        return this.Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    String Text;
}
