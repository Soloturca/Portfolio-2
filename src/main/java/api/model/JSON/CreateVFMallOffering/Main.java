package api.model.JSON.CreateVFMallOffering;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "barcode",
        "brand",
        "cargoCompanyId",
        "alternativeCargoCompanyId",
        "categoryId",
        "deliveryDuration",
        "description",
        "displayName",
        "images",
        "listPrice",
        "name",
        "quantity",
        "cargoPaymentFlag",
        "salePrice",
        "stockCode",
        "title",
        "variantCode",
        "dimensionalWeight",
        "vatRate",
        "maxSaleCount",
        "maturityAmount",
        "maturityCount",
        "parameters"
})

public class Main {

    @JsonProperty("barcode")
    private int barcode;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("cargoCompanyId")
    private String cargoCompanyId;
    @JsonProperty("alternativeCargoCompanyId")
    private String alternativeCargoCompanyId;
    @JsonProperty("categoryId")
    private String categoryId;
    @JsonProperty("deliveryDuration")
    private Integer deliveryDuration;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("images")
    private List<String> images = null;
    @JsonProperty("listPrice")
    private Integer listPrice;
    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("cargoPaymentFlag")
    private String cargoPaymentFlag;
    @JsonProperty("salePrice")
    private Integer salePrice;
    @JsonProperty("stockCode")
    private String stockCode;
    @JsonProperty("title")
    private String title;
    @JsonProperty("variantCode")
    private String variantCode;
    @JsonProperty("dimensionalWeight")
    private String dimensionalWeight;
    @JsonProperty("vatRate")
    private Integer vatRate;
    @JsonProperty("maxSaleCount")
    private Integer maxSaleCount;
    @JsonProperty("maturityAmount")
    private Integer maturityAmount;
    @JsonProperty("maturityCount")
    private Integer maturityCount;
    @JsonProperty("parameters")
    private List<Parameter> parameters = null;

    @JsonProperty("barcode")
    public int getBarcode() {
        return barcode;
    }

    @JsonProperty("barcode")
    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("cargoCompanyId")
    public String getCargoCompanyId() {
        return cargoCompanyId;
    }

    @JsonProperty("cargoCompanyId")
    public void setCargoCompanyId(String cargoCompanyId) {
        this.cargoCompanyId = cargoCompanyId;
    }

    @JsonProperty("alternativeCargoCompanyId")
    public String getAlternativeCargoCompanyId() {
        return alternativeCargoCompanyId;
    }

    @JsonProperty("alternativeCargoCompanyId")
    public void setAlternativeCargoCompanyId(String alternativeCargoCompanyId) {
        this.alternativeCargoCompanyId = alternativeCargoCompanyId;
    }

    @JsonProperty("categoryId")
    public String getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("deliveryDuration")
    public Integer getDeliveryDuration() {
        return deliveryDuration;
    }

    @JsonProperty("deliveryDuration")
    public void setDeliveryDuration(Integer deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("images")
    public List<String> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<String> images) {
        this.images = images;
    }

    @JsonProperty("listPrice")
    public Integer getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("cargoPaymentFlag")
    public String getCargoPaymentFlag() {
        return cargoPaymentFlag;
    }

    @JsonProperty("cargoPaymentFlag")
    public void setCargoPaymentFlag(String cargoPaymentFlag) {
        this.cargoPaymentFlag = cargoPaymentFlag;
    }

    @JsonProperty("salePrice")
    public Integer getSalePrice() {
        return salePrice;
    }

    @JsonProperty("salePrice")
    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    @JsonProperty("stockCode")
    public String getStockCode() {
        return stockCode;
    }

    @JsonProperty("stockCode")
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("variantCode")
    public String getVariantCode() {
        return variantCode;
    }

    @JsonProperty("variantCode")
    public void setVariantCode(String variantCode) {
        this.variantCode = variantCode;
    }

    @JsonProperty("dimensionalWeight")
    public String getDimensionalWeight() {
        return dimensionalWeight;
    }

    @JsonProperty("dimensionalWeight")
    public void setDimensionalWeight(String dimensionalWeight) {
        this.dimensionalWeight = dimensionalWeight;
    }

    @JsonProperty("vatRate")
    public Integer getVatRate() {
        return vatRate;
    }

    @JsonProperty("vatRate")
    public void setVatRate(Integer vatRate) {
        this.vatRate = vatRate;
    }

    @JsonProperty("maxSaleCount")
    public Integer getMaxSaleCount() {
        return maxSaleCount;
    }

    @JsonProperty("maxSaleCount")
    public void setMaxSaleCount(Integer maxSaleCount) {
        this.maxSaleCount = maxSaleCount;
    }

    @JsonProperty("maturityAmount")
    public Integer getMaturityAmount() {
        return maturityAmount;
    }

    @JsonProperty("maturityAmount")
    public void setMaturityAmount(Integer maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    @JsonProperty("maturityCount")
    public Integer getMaturityCount() {
        return maturityCount;
    }

    @JsonProperty("maturityCount")
    public void setMaturityCount(Integer maturityCount) {
        this.maturityCount = maturityCount;
    }

    @JsonProperty("parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

}