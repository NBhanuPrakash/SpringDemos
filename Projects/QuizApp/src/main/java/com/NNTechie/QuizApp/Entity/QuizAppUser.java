package com.NNTechie.QuizApp.Entity;




import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_AppUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAppUser implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;

	
    @Column(name = "user_name", nullable = false)
    private String userName;

    

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_phNumber", unique = true, nullable = false)
    private String phNumber;
    
    @Column(name = "user_role",nullable = false)
    private String userRole;
    
    @Autowired
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private QuizData quizData;

}