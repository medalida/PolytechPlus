package com.server.cinemaepul.utilisateur;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Integer user_id, User user) {
        if (userRepository.existsById(user_id)) {
            user.setId(user_id);
            return userRepository.save(user);
        }
        return null;
    }

    public Integer delete(Integer utilisateurId) {
        User user = this.getByIdOrThrow(utilisateurId);
        userRepository.delete(user);
        return utilisateurId;
    }

    public User getByIdOrThrow(Integer utilisateurId) {
        return this.userRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
    }

    public Optional<User> loadByLogin(String login) {
        if(this.userRepository.existsByUsername(login)) {
            return this.userRepository.findUserByUsername(login);
        }
        return null;
    }

    public UtilisateurDTO getConnectedUtilisateurDTO() {
        User user = this.getConnectedUtilisateur();
        return UtilisateurDTO.builder()
                .id(user.getId())
                .login(user.getUsername())
                .build();
    }

    public User getConnectedUtilisateur() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return loadByLogin(authentication.getName()).get();
    }
}
