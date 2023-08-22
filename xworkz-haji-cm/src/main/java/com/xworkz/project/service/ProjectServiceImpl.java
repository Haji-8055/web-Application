package com.xworkz.project.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.entity.ProjectEntity;
import com.xworkz.project.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableAsync
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository repo;

	@Autowired
	PasswordEncoder encoder;

	public ProjectServiceImpl() {
		log.info("created " + getClass().getSimpleName());
	}
	
	@Async
	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	@Override
	public void expireOTP() {

		repo.expireOTP();

	}

	@Override
	public Set<ConstraintViolation<ProjectDTO>> validateAndSave(ProjectDTO dto) {
		log.info("running validateAndSave in ProjectServiceImpl.........");

		Set<ConstraintViolation<ProjectDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations present......invalid data");

			return violations;
		}

		log.info("no violations present,data can be saved");
		ProjectEntity entity = new ProjectEntity();
		
		BeanUtils.copyProperties(dto, entity);
		
		entity.setCreatedBy(dto.getUserId());
		String encodedPassword = encoder.encode(dto.getPassword());
		entity.setPassword(encodedPassword);
		entity.setOtpExpired(false);
		
		boolean saved = repo.save(entity);
		log.info("data saved : " + saved);
		boolean mailSent = sendMail(dto.getEmail(), "registration completed", "thanks for registering!!!..");
		log.info("mail sent ?" + mailSent);
		return Collections.emptySet();
	}

	@Override
	public List<ProjectDTO> fetchAllEntities() {

		log.info("running fetchAllEntities in ProjectServiceImpl.........");

		List<ProjectEntity> entities = repo.fetchAllEntities();

		List<ProjectDTO> dtos = new ArrayList<ProjectDTO>();

		for (ProjectEntity entity : entities) {

			ProjectDTO dto = new ProjectDTO();
			BeanUtils.copyProperties(entity, dto);

			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public String SignIn(String userId, String password) {
		log.info("running SignIn in ProjectServiceImpl.........");

		ProjectEntity entity = repo.findByUserID(userId);

		if (entity != null) {

			if (entity.getSignInCount() >= 3) {
				return "account locked reset password";
			}

			if (entity.getOtpExpired() == true) {
				return "otp expired please resend otp";
			}

			boolean passwordMatch = encoder.matches(password, entity.getPassword());
			log.info("password matched ??" + passwordMatch);

			if (passwordMatch == true) {
				entity.setSignInCount(0);
				repo.updateEntity(entity);
				return "";
			} else {
				Integer count = entity.getSignInCount();
				count++;
				entity.setSignInCount(count);
				repo.updateEntity(entity);

				return "user not found ,invalid userName or password";
			}
		} else {
			return "user not found ,invalid userName or password";

		}
	}

	@Override
	public boolean sendMail(String email, String subject, String msg) {

		log.info("running sendMail in ProjectServiceImpl.........");

		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "murtuza662@outlook.com";
		String password = "Haji@7019";
		String to = email;

		Properties prop = System.getProperties();
		log.info("properties" + prop);
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocal", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject(subject);
			message.setText(msg);

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent successfully");
			return true;

		}

		catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean sendRandomPassWord(String email) {

		log.info("running sendRandomPassWord in ProjectServiceImpl.........");

		List<ProjectEntity> entities = repo.fetchAllEntities();

		for (ProjectEntity entity : entities) {

			if (entity.getEmail().equalsIgnoreCase(email)) {

				String randomPassword = generateRandomPassword();
				log.info("randomly generated password ===========****************************" + randomPassword);

				boolean emailSent = sendMail(email, "your temporary password for forgot password", randomPassword);
				log.info("Email sent to user ??" + emailSent);

				entity.setPassword(encoder.encode(randomPassword));
				entity.setUpdatedBy("SYSTEM");
				entity.setUpdatedDate(LocalDateTime.now());
				entity.setResetPassword(true);
				entity.setSignInCount(0);
				entity.setOtpRequestedTime(LocalTime.now().plusSeconds(60));
				entity.setOtpExpired(false);

				boolean updated = repo.updateEntity(entity);

				log.info("password updated in database ??" + updated);

				return true;
			}
		}
		log.info("email not found ");

		return false;
	}

	@Override
	public boolean UpdateEntity(ProjectDTO dto) {
		log.info("running UpdateEntity in ProjectServiceImpl.........");

		log.info("updated password by user in ProjectServiceImpl........." + dto.getPassword());

		String encodedPass = encoder.encode(dto.getPassword());

		ProjectEntity entity = new ProjectEntity();

		BeanUtils.copyProperties(dto, entity);

		entity.setUpdatedBy(dto.getUserId());
		entity.setResetPassword(false);
		entity.setPassword(encodedPass);
		entity.setCreatedBy(dto.getUserId());
		entity.setUpdatedDate(LocalDateTime.now());
		entity.setOtpExpired(false);
		entity.setOtpRequestedTime(null);

		repo.updateEntity(entity);
		return true;
	}

	@Override
	public ProjectDTO findByUserId(String userId) {
		log.info("running findByUserId in ProjectServiceImpl for ........."+userId);

		ProjectEntity entity = repo.findByUserID(userId);

		ProjectDTO dto = new ProjectDTO();

		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

	public String generateRandomPassword() {

		PasswordGenerator passGen = new PasswordGenerator();

		CharacterRule lcr = new CharacterRule(EnglishCharacterData.LowerCase);
		lcr.setNumberOfCharacters(2);

		CharacterRule dr = new CharacterRule(EnglishCharacterData.Digit);
		dr.setNumberOfCharacters(2);

		String randomPassword = passGen.generatePassword(8, lcr, dr);
		return randomPassword;

	}

	

	@Override
	public ProjectDTO findByEmailId(String email) {

		ProjectEntity entity=repo.findByEmailId(email);
		ProjectDTO dto = new ProjectDTO();

		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public boolean UpdateProfile(ProjectDTO dto) {
		log.info("running UpdateEntity in ProjectServiceImpl.........");

		ProjectEntity entity = new ProjectEntity();

		BeanUtils.copyProperties(dto, entity);

		entity.setUpdatedBy(dto.getUserId());
		entity.setResetPassword(false);
		entity.setCreatedBy(dto.getUserId());
		entity.setUpdatedDate(LocalDateTime.now());
		entity.setOtpExpired(false);
		entity.setOtpRequestedTime(null);

		repo.updateEntity(entity);
		
		return true;
	}

}
