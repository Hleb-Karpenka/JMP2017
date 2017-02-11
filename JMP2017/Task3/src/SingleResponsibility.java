
public class SingleResponsibility {
    public void calculateTotalSum(){/*...*/}
    public void getItems(){/*...*/}
    public void getItemCount(){/*...*/}
    public void addItem(Object item){/*...*/}
    public void deleteItem( Object item){/*...*/}

    public void printOrder(){/*...*/}
    public void showOrder(){/*...*/}

    public void load(){/*...*/}
    public void save(){/*...*/}
    public void update(){/*...*/}
    public void delete(){/*...*/}
}

//should be 3 classes with one responsibility at each:

class Order
{
    public void calculateTotalSum(){/*...*/}
    public void getItems(){/*...*/}
    public void getItemCount(){/*...*/}
    public void addItem(Object item){/*...*/}
    public void deleteItem(Object item){/*...*/}
}

class OrderRepository
{
    public void load(Object orderID){/*...*/}
    public void save(Object order){/*...*/}
    public void update(Object order){/*...*/}
    public void delete(Object order){/*...*/}
}

class OrderViewer
{
    public void printOrder(Object order){/*...*/}
    public void showOrder(Object order){/*...*/}
}
