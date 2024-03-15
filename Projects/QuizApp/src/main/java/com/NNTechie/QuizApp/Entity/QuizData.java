package com.NNTechie.QuizApp.Entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_Data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizData implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_score", nullable = false)
    private String userScore;

    @Column(name = "user_logintime", nullable = false)
    private String loginTime;

    @Column(name = "user_logouttime", nullable = false)
    private String logoutTime;

   

}