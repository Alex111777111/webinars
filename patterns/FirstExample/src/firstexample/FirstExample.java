package firstexample;

public class FirstExample
{
    public static void main(String[] args) {
        
        ContactDAO dao = new ContactDAO();
        dao.connectToDb("serverDB", "login", "password");
        
        Contact[] list = dao.getContactList();
        
        ContactDAO dao2 = new ContactDAO();
        dao2.connectToDb("serverDB", "login", "password");
        
        Contact[] list2 = dao2.getContactList();
        
    }    
    
    
}
