package com.pfe.AllTheTps.services;


import com.pfe.AllTheTps.DTOs.UserDto;
import com.pfe.AllTheTps.Mappers.UserMapper;
import com.pfe.AllTheTps.entities.RoleEntity;
import com.pfe.AllTheTps.entities.UserEntity;
import com.pfe.AllTheTps.repositories.UserRepository;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl   implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDto addUser(UserDto userDto) {

           return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));

    }
    @Override
    public UserDto updateUser(UserDto userDto) {
        return
                userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<UserDto> selectUsers() {
        return
                userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        UserEntity userEntity =
                userRepository.findByEmail(email);
        if (userEntity == null)
            throw new UsernameNotFoundException("User not found ! ");
        return User.builder()
                .password(userEntity.getPassword())
                .username(userEntity.getEmail())
                .roles(userEntity.getRoles().stream().map(RoleEntity::getLabel).toArray(String[]::new))
                .build();
    }
}
