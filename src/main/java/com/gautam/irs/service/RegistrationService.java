package com.gautam.irs.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gautam.irs.entity.UserEntity;
import com.gautam.irs.exception.HappyGoException;
import com.gautam.irs.exception.InvalidCityException;
import com.gautam.irs.exception.InvalidEmailException;
import com.gautam.irs.exception.InvalidNameException;
import com.gautam.irs.exception.InvalidPasswordException;
import com.gautam.irs.exception.InvalidPhoneException;
import com.gautam.irs.exception.InvalidUserIdException;
import com.gautam.irs.exception.UserIdAlreadyPresentException;
import com.gautam.irs.model.User;
import com.gautam.irs.repository.UserRepository;

@Service
public class RegistrationService {
	@Autowired
	private UserRepository userRepository;
	String regex1 = "^[a-zA-Z0-9]{4,15}+$";
	public String registerUser(User user) throws HappyGoException {
		validateUser(user);
		boolean b = userRepository.existsById(user.getUserId());
		if (b)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
		UserEntity userEntity = new UserEntity();
		userEntity.setCity(user.getCity());
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhone());
		userEntity.setUserId(user.getUserId());
		userRepository.saveAndFlush(userEntity);
		return "UserRespository.REGISTRATION_SUCCESS";
	}
	public void validateUser(User user) throws HappyGoException {
		if (!isValidUserId(user.getUserId()))
			throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
		if (!isValidPassword(user.getPassword()))
			throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");
		if (!isValidName(user.getName()))
			throw new InvalidNameException("RegistrationService.INVALID_NAME");
		if (!isValidCity(user.getCity()))
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		if (!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		if (!isValidPhoneNumber(user.getPhone()))
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
	}
	public Boolean isValidUserId(String userid) {
		Boolean b1 = false;
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(userid);
		if (matcher1.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidPassword(String password) {
		Boolean b1 = false;
		String regex2 = "^[a-zA-Z0-9]{8,15}+$";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(password);
		if (matcher2.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidName(String name) {
		Boolean b1 = false;
		Pattern pattern3 = Pattern.compile(regex1);
		Matcher matcher3 = pattern3.matcher(name);
		if (matcher3.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidCity(String city) {
		Boolean b1 = false;
		Pattern pattern4 = Pattern.compile(regex1);
		Matcher matcher4 = pattern4.matcher(city);
		if (matcher4.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidEmail(String email) {
		Boolean b1 = false;
		String regex5 = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern5.matcher(email);
		if (matcher5.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidPhoneNumber(String number) {
		Boolean b1 = false;
		String regex6 = "[0-9]{10}";
		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(number);
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
}
