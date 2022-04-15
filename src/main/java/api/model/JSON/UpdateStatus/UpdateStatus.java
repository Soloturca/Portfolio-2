package api.model.JSON.UpdateStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UpdateStatus {

    @JsonProperty("changedBy")
    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    String changedBy;

    @JsonProperty("newStatus")
    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    String newStatus;

    @JsonProperty("orderStatusRequests")
    public List<OrderStatusRequest> getOrderStatusRequests() {
        return orderStatusRequests;
    }

    public void setOrderStatusRequests(List<OrderStatusRequest> orderStatusRequests) {
        this.orderStatusRequests = orderStatusRequests;
    }

    List<OrderStatusRequest> orderStatusRequests;


    @JsonProperty("returnOrders")
    public Boolean getReturnOrders() {
        return returnOrders;
    }

    public void setReturnOrders(Boolean returnOrders) {
        this.returnOrders = returnOrders;
    }

    Boolean returnOrders;
}
