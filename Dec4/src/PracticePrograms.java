interface UserView{
    String getFormattedNumber(String unmaskedNumber);
}

class ClientUserView implements UserView{
    @Override
    public String getFormattedNumber(String unmaskedPhone){
        if(unmaskedPhone == null || unmaskedPhone.length() < 6){
            return "******";
        }
        String mask = "******";
        String unmasked = unmaskedPhone.substring(unmaskedPhone.length() - 4);
        return mask + unmasked;
    }
}

class AdminView implements UserView{
    @Override
    public String getFormattedNumber(String unmaskedPhone){
        return unmaskedPhone;
    }
}
class User{
    String firstName;
    String lastName;
    String phoneNumber;
    String address;

    public User(String firstName,String lastName,String phoneNumber,String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber(UserView view) {
        return view.getFormattedNumber(phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class PracticePrograms {
    static void main(String [] args){
        User user1 = new User("Rishav","Raj","9311571439","New Delhi");
        User user2 = new User("Balaji","Patil","7028495650","Pune");
        User user3 = new User("Abhinav","Upadhyay","7536036894","Agra");

        UserView clientView = new ClientUserView();
        UserView adminView = new AdminView();

        System.out.println("### Client Access (Restricted) ###");
        System.out.println("Name: " + user1.getFirstName() + " " + user1.getLastName()
        + " Address: " + user1.getAddress() +" phone number: " + user1.getPhoneNumber(clientView)
        );

        System.out.println("### Admin Access (Non-Restricted) ###");
        System.out.println("Name: " + user1.getFirstName() + " " + user1.getLastName()
        + " Address: " + user1.getAddress() +" phone number: " + user1.getPhoneNumber(adminView)
        );
    }

}
