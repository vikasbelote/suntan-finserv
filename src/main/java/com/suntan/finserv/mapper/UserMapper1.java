package com.suntan.finserv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.suntan.finserv.dto.CreateUserDTO;
import com.suntan.finserv.entity.UserDetail;

@Mapper(componentModel = "spring")
public interface UserMapper1 {
	
	@Mappings({
      @Mapping(target="userId", source="userId"),
      @Mapping(target="userName", source="userName"),
      @Mapping(target="userPassword", source="password"),
      @Mapping(target="person.firstName", source="firstName"),
      @Mapping(target="person.lastName", source="lastName")
    })
	UserDetail createUserDtoToUserDeatil(CreateUserDTO createUserDTO);
	
	@Mappings({
      @Mapping(target="userId", source="userId"),
      @Mapping(target="userName", source="userName"),
      @Mapping(target="password", source="userPassword"),
      @Mapping(target="firstName", source="person.firstName"),
      @Mapping(target="lastName", source="person.lastName")
    })
	CreateUserDTO userDetailToCreateUserDto(UserDetail userDetail);

}
