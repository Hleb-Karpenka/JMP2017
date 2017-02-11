
public interface InterfaceSegregation {

        public void applyDiscount(Object applyDiscount);
        public void applyPromocode(Object promocode);

        public void setColor(Object color);
        public void setSize(Object size);

        public void setCondition(Object condition);
        public void setPrice(Object $price);

}

interface IItem
{
    public void setCondition(Object condition);
    public void setPrice(Object price);
}

interface IClothes
{
    public void setColor(Object color);
    public void setSize(Object size);
    public void setMaterial(Object material);
}

interface IDiscountable
{
    public void applyDiscount(Object discount);
    public void applyPromocode(Object promocode);
}
