package api.model.SOAP;

public class ResetSGSN_v1 {
    public Header getHeader() {
        return this.Header;
    }

    public void setHeader(Header Header) {
        this.Header = Header;
    }

    Header Header;

    public Body getBody() {
        return this.Body;
    }

    public void setBody(Body Body) {
        this.Body = Body;
    }

    Body Body;
}
