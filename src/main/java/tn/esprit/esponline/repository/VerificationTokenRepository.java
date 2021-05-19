package tn.esprit.esponline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.esponline.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
