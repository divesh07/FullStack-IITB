package techBlog.service;

import org.springframework.stereotype.Service;
import techBlog.model.User;

@Service
public class UserService {
    public boolean login(User user){
         if ( user.getUsername().equalsIgnoreCase("admin")){
             return true;
         }
         return false;
    }
}
