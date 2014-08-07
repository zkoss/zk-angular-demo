package demo.chat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

public class ChatRoomViewModel {
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

	private List<Message> chatList = new LinkedList<Message>();
	private static String LEAVING = "Leaving";
	private int users = 0;
	
	public void setUsers(int users) {
		this.users = users;
	}
	
	public int getUsers() {
		return this.users;
	}

	public List<Message> getChatList() {
		return chatList;
	}
	
	@NotifyChange("chatList")
	public void setChatList(List<Message>chatList) {
		this.chatList = chatList;
	}

	@GlobalCommand
	@NotifyChange({"chatList", "users"})
	public void send(@BindingParam("username") String username, @BindingParam("message") String message) {
		updateMessage(username, message);
	}
	
	private void updateMessage(String username, String message) {
		if (chatList.size() > 30)
			chatList.clear();
		chatList.add(new Message(username, message, sdf.format(new Date())));
		
		Set<String> u = new HashSet<String>();
		for (Message m : chatList) {
			if (LEAVING.equals(m.getText()))
				u.remove(m.getUsername());
			else
				u.add(m.getUsername());
		}
		users = u.size();
		
		if (users == 0)
			chatList.clear();
	}
	
	@GlobalCommand
	@NotifyChange({"chatList", "users"})
	public void resetVM(@BindingParam("username") String username) {
		updateMessage(username, LEAVING);
	}
}
