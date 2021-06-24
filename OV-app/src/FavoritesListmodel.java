public class FavoritesListmodel extends Listmodel
{
    public FavoritesListmodel()
    {

    }

    @Override
    public void addToList(Route route)
    {
        try
        {
            int i = 0;
            this.add(i, route);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException exception)
        {
            exception.printStackTrace();
        }
    }
}
