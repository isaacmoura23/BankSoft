package com.BankSoft.Bank.service;

import com.BankSoft.Bank.dto.UserRequestDTO;
import com.BankSoft.Bank.dto.UserResponseDTO;
import com.BankSoft.Bank.model.User;
import com.BankSoft.Bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO findById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    public List<UserResponseDTO> findAll(){
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public UserResponseDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());

        User saved = userRepository.save(user);
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

    public UserResponseDTO deleteUser (Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        userRepository.delete(user);
        return null;
    }

}
