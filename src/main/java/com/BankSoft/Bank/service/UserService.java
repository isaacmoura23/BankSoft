package com.BankSoft.Bank.service;

import com.BankSoft.Bank.dto.UserRequestDTO;
import com.BankSoft.Bank.dto.UserResponseDTO;
import com.BankSoft.Bank.model.User;
import com.BankSoft.Bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        Optional<User> user = userRepository.findByEmail(userRequestDTO.email());

        if (user.isPresent()){
            throw new RuntimeException("Já existe um usuário com esse e-mail");
        }

        User user1 = User.builder()
                .name(userRequestDTO.name())
                .email(userRequestDTO.email())
                .password(userRequestDTO.password())
                .build();

        User saved = userRepository.save(user1);
        return toResponseDTO(saved);
    }

    public UserResponseDTO updateUser (Long id, UserRequestDTO userRequestDTO){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());

        User saved = userRepository.save(user);
        return toResponseDTO(saved);
    }

    public UserResponseDTO deleteUser ( Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        userRepository.delete(user);
        return null;
    }

}
