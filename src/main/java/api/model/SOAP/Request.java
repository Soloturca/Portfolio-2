package api.model.SOAP;

public class Request {
    public Object getIMSI() {
        return this.IMSI;
    }

    public void setIMSI(Object IMSI) {
        this.IMSI = IMSI;
    }

    Object IMSI;

    public long getMSISDN() {
        return this.MSISDN;
    }

    public void setMSISDN(long MSISDN) {
        this.MSISDN = MSISDN;
    }

    long MSISDN;

    public Object getSGSN() {
        return this.SGSN;
    }

    public void setSGSN(Object SGSN) {
        this.SGSN = SGSN;
    }

    Object SGSN;
}
