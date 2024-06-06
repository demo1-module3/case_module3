package org.example.bai_case_module3.entity;

public class Cart {
    private int cartId;
    private User userId;
    private int quantityProduct;
    private Double totalPrice;

    public Cart() {
    }

    public Cart(User userId, int quantityProduct, Double totalPrice) {
        this.userId = userId;
        this.quantityProduct = quantityProduct;
        this.totalPrice = totalPrice;
    }

    public Cart(int cartId, User userId, int quantityProduct, Double totalPrice) {
        this.cartId = cartId;
        this.userId = userId;
        this.quantityProduct = quantityProduct;
        this.totalPrice = totalPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
