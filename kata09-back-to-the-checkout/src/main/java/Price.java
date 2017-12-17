public final class Price {
    private final Money amount;
    private final ItemQuantities itemQuantities;

    public Price() {
        this(Money.of(0), new ItemQuantities());
    }

    public Price(Money amount, ItemSku sku, int quantity) {
        this(amount, new ItemQuantities(sku, quantity));
    }

    public Price(Money amount, ItemQuantities itemQuantities) {
        this.amount = amount;
        this.itemQuantities = itemQuantities.copy();
    }

    public Price plus(Price another) {
        return new Price(amount.plus(another.amount), itemQuantities.plus(another.itemQuantities));
    }

    public ItemQuantities itemQuantities() {
        return itemQuantities.copy();
    }

    public Money amount() {
        return amount;
    }

    public Price subtract(Money money) {
        return new Price(amount.subtract(money), itemQuantities);
    }
}
