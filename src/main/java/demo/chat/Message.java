/** Message.java.

	Purpose:
		
	Description:
		
	History:
		2:39:55 PM Aug 4, 2014, Created by jumperchen

Copyright (C) 2014 Potix Corporation. All Rights Reserved.
*/
package demo.chat;

/**
 * @author jumperchen
 */
public class Message {
	private String username;
	private String text;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Message() {}
	public Message(String username, String text, String time) {
		this.username = username;
		this.text = text;
		this.time = time;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
