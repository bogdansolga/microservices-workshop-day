package com.microservices.training.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "order_item_sequence_generator")
    @SequenceGenerator(name = "order_item_sequence_generator", sequenceName = "order_item_sequence", allocationSize = 1)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "price", nullable = false, length = 10)
    private double price;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    protected OrderItem() {}

    public OrderItem(final String name) {
        this.name = name;
    }

    public OrderItem(final int id, final String name) {
    	this.id = id;
        this.name = name;
    }

    public OrderItem(final String name, final double price, final Order order) {
        this.name = name;
        this.price = price;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public Order getSection() {
        return order;
    }

    public void setSection(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id &&
                Objects.equals(name, orderItem.name) &&
                Objects.equals(price, orderItem.price) &&
                Objects.equals(order, orderItem.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, order);
    }

    @Override
    public String toString() {
        return id + ", " + name + " [" + price + "]";
    }
}
