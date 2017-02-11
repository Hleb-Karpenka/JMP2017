
public class OpenClosed {

        public void load(Object orderID)
        {
            // load data from orderID
        }
        public void save(Object order){/*...*/}
        public void update(Object order){/*...*/}
        public void delete(Object order){/*...*/}

}

// should use interface and multiply extensions:

class OrderRepository1
{
    private Object source;

    public void setSource(IOrderSource source)
    {
        this.source = source;
    }

    public void load(Object orderID)
    {
        this.source = orderID;
    }
    public void save(Object order){/*...*/}
    public void update(Object order){/*...*/}
}

interface IOrderSource
{
    public void load(Object orderID);
    public void save(Object order);
    public void update(Object order);
    public void delete(Object order);
}

class MySQLOrderSource implements IOrderSource
{
    public void load(Object orderID){/*...*/}
    public void save(Object order){/*...*/}
    public void update(Object order){/*...*/}
    public void delete(Object order){/*...*/}
}

class ApiOrderSource implements IOrderSource
{
    public void load(Object orderID){/*...*/}
    public void save(Object order){/*...*/}
    public void update(Object order){/*...*/}
    public void delete(Object order){/*...*/}
}