package flex;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RemotingDestination
public class FriendService {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void  setSessionFactory(SessionFactory factory){
		this.sessionFactory = factory;
	}
	
	@SuppressWarnings("unchecked")
	@RemotingInclude
	@Transactional(readOnly = true)
	public  List<Friend> getFriends(){
		return this.sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}
	
	@RemotingInclude
	@Transactional
	public void createFriend(String name){
		Friend f = new Friend();
		f.setName(name);
		this.sessionFactory.getCurrentSession().save(f);
	}
	

}
