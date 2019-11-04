package com.company.RESTWebServiceGroupProject.viewModels;

import com.company.RESTWebServiceGroupProject.dto.Item;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {
    private int invoiceItemId;
    private int invoiceId;
    private Item item;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
        InvoiceItemViewModel that = (InvoiceItemViewModel) o;
        return invoiceItemId == that.invoiceItemId &&
                invoiceId == that.invoiceId &&
                quantity == that.quantity &&
                Objects.equals(item, that.item) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, invoiceId, item, quantity, unitPrice, discount);
    }

    @Override
    public String toString() {
        return "InvoiceItemViewModel{" +
                "invoiceItemId=" + invoiceItemId +
                ", invoiceId=" + invoiceId +
                ", item=" + item +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", discount=" + discount +
                '}';
    }
}
