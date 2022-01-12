package api.model.SOAP;

public class Body {
    public Request getRequest() {
        return this.Request;
    }

    public void setRequest(Request Request) {
        this.Request = Request;
    }

    Request Request;

    public ResetSGSNV1 getResetSGSNV1() {
        return this.ResetSGSNV1;
    }

    public void setResetSGSNV1(ResetSGSNV1 ResetSGSNV1) {
        this.ResetSGSNV1 = ResetSGSNV1;
    }

    ResetSGSNV1 ResetSGSNV1;
}
