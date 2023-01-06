package Pack.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.core.ExchangeTypes;

import Pack.dao.UserDao;
import Pack.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	@RabbitListener(
			bindings = @QueueBinding(
				exchange = @Exchange(
					name="signUp",
					type=ExchangeTypes.FANOUT
				),
				value= @Queue(name="signUpQueue2")
			)
	)
	public void signUp(UserDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println(dto.getName());
		dao.signUp(dto);
	}
}
