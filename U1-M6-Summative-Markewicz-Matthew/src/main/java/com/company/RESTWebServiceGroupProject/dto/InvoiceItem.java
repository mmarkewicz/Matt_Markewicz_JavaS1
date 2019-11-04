package com.company.RESTWebServiceGroupProject.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {

    private int invoiceItemId;

    @NotNull(message = "Please enter a valid invoice ID.")
    private Integer invoiceId;

    @NotNull(message = "Please enter a valid item ID.")
    private Integer itemId;

    @NotNull(message = "Please enter a valid quantity.")
    @Min(value = 0, message = "Please enter a valid quantity.")
    private Integer quantity;

    @DecimalMin(value = "0.00", inclusive = true, message = "Please enter a valid unit price.")
    @Digits(integer = 7, fraction = 2, message = "Please enter a valid unit price.")
    private BigDecimal unitPrice;

    @DecimalMin(value = "0.00", inclusive = true, message = "Please enter a valid unit price.")
    @Digits(integer = 7, fraction = 2, message = "Please enter a valid unit price.")
    private BigDecimal discount;

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return invoiceItemId == that.invoiceItemId &&
                Objects.equals(invoiceId, that.invoiceId) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, invoiceId, itemId, quantity, unitPrice, discount);
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "invoiceItemId=" + invoiceItemId +
                ", invoiceId=" + invoiceId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", discount=" + discount +
                '}';
    }
}
