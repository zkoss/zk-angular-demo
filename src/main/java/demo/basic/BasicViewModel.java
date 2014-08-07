/** BasicViewModel.java.

	Purpose:
		
	Description:
		
	History:
		5:29:02 PM Jul 30, 2014, Created by jumperchen

Copyright (C) 2014 Potix Corporation. All Rights Reserved.
*/
package demo.basic;

import org.zkoss.bind.annotation.NotifyChange;

/**
 * @author jumperchen
 *
 */
public class BasicViewModel {
	private String firstName;
	
	@NotifyChange("fullName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getFullName() {
		return (firstName == null ? "" : firstName) + " Potter";
	}
}
