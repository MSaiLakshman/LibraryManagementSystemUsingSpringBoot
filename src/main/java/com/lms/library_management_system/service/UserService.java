package com.lms.library_management_system.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.library_management_system.dao.AddressDao;
import com.lms.library_management_system.dao.UserDao;
import com.lms.library_management_system.dto.UserDto;
import com.lms.library_management_system.entity.Address;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.exception.NotFoundExceeption;
import com.lms.library_management_system.exception.UserIdNotFoundExceeption;
import com.lms.library_management_system.exception.UserNotFoundException;
import com.lms.library_management_system.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper mapper;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(UserDto dto, int addressID){
		Address addressById=addressDao.findByAddressId(addressID);
		User user=mapper.map(dto, User.class);
		user.setAddress(addressById);
		dao.saveUser(user);
		
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("User Object saved");
		responseStructure.setData(user);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
	}
	
	  public ResponseEntity<ResponseStructure<User>> findByUserId(int userId) {
	        User dbUser = dao.findByUserId(userId);
	        ResponseStructure<User> responseStructure = new ResponseStructure<>();
	        if (dbUser != null) {
	            responseStructure.setStatusCode(HttpStatus.OK.value());
	            responseStructure.setMessage("User Found");
	            responseStructure.setData(dbUser);
	            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	        } else {
	            throw new UserNotFoundException("Not Found");
	        }
	    }

	    public ResponseEntity<ResponseStructure<User>> updateUser(int userId, UserDto userDto) {
	        User user = mapper.map(userDto, User.class);
	        User dbUser = dao.updateUser(userId, user);
	        ResponseStructure<User> responseStructure = new ResponseStructure<>();
	        if (dbUser != null) {
	            responseStructure.setStatusCode(HttpStatus.OK.value());
	            responseStructure.setMessage("User Updated");
	            responseStructure.setData(dbUser);
	            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	        } else {
	           throw new UserIdNotFoundExceeption("Not found");
	        }
	    }
	    public ResponseEntity<ResponseStructure<String>> deleteUser(int userId) {
	        ResponseStructure<String> responseStructure = new ResponseStructure<>();
	        User deletedUser = dao.deleteUser(userId);
	        if (deletedUser != null) {
	            responseStructure.setStatusCode(HttpStatus.OK.value());
	            responseStructure.setMessage("User Deleted Successfully");
	            responseStructure.setData("User with ID " + userId + " was deleted.");
	            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	        } else {
	        	throw new NotFoundExceeption("Not found");
	        }
	    }

	    public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
	        List<User> users = dao.fetchAllUsers();
	        ResponseStructure<List<User>> responseStructure = new ResponseStructure<>();
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        responseStructure.setMessage("Users Retrieved");
	        responseStructure.setData(users);
	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    }
}
