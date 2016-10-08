package firstexample;

public class ContactDAO
{
    Connect con;
            
    void connectToDb(String host, String login, String password) {
        con = new Connect();
    }
    
    Contact[] getContactList() {
        con.host = "";
        return null;
    }
    
    Contact getContact(long contactId) {
        return null;
    }
    
    void addContact(Contact contact) {
        
    }
    
    void updateContact(Contact contact) {
        
    }    
    
    void deleteContact(long contactId) {
        
    }
}
