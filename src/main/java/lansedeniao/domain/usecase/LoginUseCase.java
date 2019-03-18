package lansedeniao.domain.usecase;

import lansedeniao.data.repository.UserRepositoryImpl;
import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.AuthException;
import lansedeniao.domain.exception.UserLoggedInException;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.repository.UserRepository;

public class LoginUseCase {

    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    public User login(String username, String password) throws UserNotFoundException, AuthException, UserLoggedInException {
        if (userRepository.hasLoggedInUser()) {
            throw new UserLoggedInException();
        }
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (!user.getPassword().equals(password)) {
            throw new AuthException();
        }
        userRepository.setLoggedInUser(user);
        return user;
    }
}
