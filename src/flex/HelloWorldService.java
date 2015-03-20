package flex;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
@RemotingDestination
public class HelloWorldService {
	
	@RemotingInclude
	@Secured("ROLE_USER")
	public String sayHello(String name){
		return "howdy, " + name;
	}

}
