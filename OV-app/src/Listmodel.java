import javax.swing.*;

public abstract class Listmodel extends DefaultListModel<Route>
{
    public abstract void addToList(Route route);

    public void printRouteCount()
    {
        int a = this.size();
        System.out.println("Number of routes in listmodel: " + a);
    }
}
