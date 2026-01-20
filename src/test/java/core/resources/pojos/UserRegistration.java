package core.resources.pojos;

import java.util.List;

public class UserRegistration {

    private List<Users> user;

    public List<Users> getUser() {
        return user;
    }

    public UserRegistration(List<Users> user){
        this.user = user;
    }
}
