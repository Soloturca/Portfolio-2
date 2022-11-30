
package api.paytionPojo;

import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactionId",
    "transactionGroupId",
    "reconDate",
    "ipAddress",
    "companyId",
    "institutionId",
    "productId",
    "bankId",
    "transactionDate",
    "description",
    "originatorInfo",
    "paymentMethod",
    "customerReferenceType",
    "sun",
    "customerCode",
    "card",
    "secure3DInfo",
    "amount",
    "installment"
})

public class Paytion {

    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("transactionGroupId")
    private String transactionGroupId;
    @JsonProperty("reconDate")
    private String reconDate;
    @JsonProperty("ipAddress")
    private String ipAddress;
    @JsonProperty("companyId")
    private Integer companyId;
    @JsonProperty("institutionId")
    private Integer institutionId;
    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("bankId")
    private Integer bankId;
    @JsonProperty("transactionDate")
    private String transactionDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("originatorInfo")
    private OriginatorInfo originatorInfo;
    @JsonProperty("paymentMethod")
    private String paymentMethod;
    @JsonProperty("customerReferenceType")
    private String customerReferenceType;
    @JsonProperty("sun")
    private String sun;
    @JsonProperty("customerCode")
    private String customerCode;
    @JsonProperty("card")
    private Card card;
    @JsonProperty("secure3DInfo")
    private Secure3DInfo secure3DInfo;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("installment")
    private Integer installment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("transactionGroupId")
    public String getTransactionGroupId() {
        return transactionGroupId;
    }

    @JsonProperty("transactionGroupId")
    public void setTransactionGroupId(String transactionGroupId) {
        this.transactionGroupId = transactionGroupId;
    }

    @JsonProperty("reconDate")
    public String getReconDate() {
        return reconDate;
    }

    @JsonProperty("reconDate")
    public void setReconDate(String reconDate) {
        this.reconDate = reconDate;
    }

    @JsonProperty("ipAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("ipAddress")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("companyId")
    public Integer getCompanyId() {
        return companyId;
    }

    @JsonProperty("companyId")
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @JsonProperty("institutionId")
    public Integer getInstitutionId() {
        return institutionId;
    }

    @JsonProperty("institutionId")
    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    @JsonProperty("productId")
    public Integer getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @JsonProperty("bankId")
    public Integer getBankId() {
        return bankId;
    }

    @JsonProperty("bankId")
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    @JsonProperty("transactionDate")
    public String getTransactionDate() {
        return transactionDate;
    }

    @JsonProperty("transactionDate")
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("originatorInfo")
    public OriginatorInfo getOriginatorInfo() {
        return originatorInfo;
    }

    @JsonProperty("originatorInfo")
    public void setOriginatorInfo(OriginatorInfo originatorInfo) {
        this.originatorInfo = originatorInfo;
    }

    @JsonProperty("paymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("paymentMethod")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("customerReferenceType")
    public String getCustomerReferenceType() {
        return customerReferenceType;
    }

    @JsonProperty("customerReferenceType")
    public void setCustomerReferenceType(String customerReferenceType) {
        this.customerReferenceType = customerReferenceType;
    }

    @JsonProperty("sun")
    public String getSun() {
        return sun;
    }

    @JsonProperty("sun")
    public void setSun(String sun) {
        this.sun = sun;
    }

    @JsonProperty("customerCode")
    public String getCustomerCode() {
        return customerCode;
    }

    @JsonProperty("customerCode")
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @JsonProperty("card")
    public Card getCard() {
        return card;
    }

    @JsonProperty("card")
    public void setCard(Card card) {
        this.card = card;
    }

    @JsonProperty("secure3DInfo")
    public Secure3DInfo getSecure3DInfo() {
        return secure3DInfo;
    }

    @JsonProperty("secure3DInfo")
    public void setSecure3DInfo(Secure3DInfo secure3DInfo) {
        this.secure3DInfo = secure3DInfo;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @JsonProperty("installment")
    public Integer getInstallment() {
        return installment;
    }

    @JsonProperty("installment")
    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
