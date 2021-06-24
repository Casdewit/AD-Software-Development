public class HistoryListmodel extends Listmodel
{
    public HistoryListmodel()
    {

    }

    @Override
    public void addToList(Route route)
    {
        try
        {
            if (this.size() > 15)
            {
                int i = this.size() - 1;
                this.removeElementAt(i);
            }
            int i = 0;
            this.add(i, route);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void printRouteCount()
    {
        int a = this.size();
        System.out.println("Number of routes in Historylistmodel: " + a);
    }
}
