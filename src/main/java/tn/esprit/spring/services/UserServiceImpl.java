package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() {
		l.info("In retrieveAllUsers()");
		List<User> users = null;
		try {
			users = userRepository.findAll();
			l.info("Out retrieveAllUsers()");
		} catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		l.info("In addUser()");
		User utilisateur = null;
		try {
			utilisateur = userRepository.save(u);
			l.info("Out addUser()");
		} catch (Exception e) {
			l.error("Error in addUser() : " + e);
		}
		return utilisateur;
	}

	@Override
	public User updateUser(User u) {
		l.info("In updateUser()");
		User userUpdated = null;
		try {
			userUpdated = userRepository.save(u);
			l.info("Out updateUser()");
		} catch (Exception e) {
			l.error("Error in updateUser() : " + e);
		}
		return userUpdated;
	}

	@Override
	public void deleteUser(String id) {
		l.info("In deleteUser()");
		try {
			userRepository.deleteById(Long.parseLong(id));
			l.info("Out deleteUser()");
		} catch (Exception e) {
			l.error("Error in deleteUser() : " + e);
		}
	}

	@Override
	public User retrieveUser(String id) {
		l.info("In retrieveUser()");
		User u = null;
		try {
			Optional<User> optionalUser = userRepository.findById(Long.parseLong(id));
			if (optionalUser.isPresent()) {
				u = optionalUser.get();
			}
			l.info("Out retrieveUser()");
		} catch (Exception e) {
			l.error("Error in retrieveUser() : " + e);
		}
		return u;
	}
}
