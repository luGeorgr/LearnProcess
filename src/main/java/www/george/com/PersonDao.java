package www.george.com;

public interface PersonDao
{
    public Person fetchPerson( Integer personID );
    public void update( Person person );
}