/** ValidationViewModel.java.

	Purpose:
		
	Description:
		
	History:
		5:29:02 PM Jul 30, 2014, Created by jumperchen

Copyright (C) 2014 Potix Corporation. All Rights Reserved.
*/
package demo.basic;

import javax.validation.constraints.Size;
import org.zkoss.bind.annotation.NotifyChange;

/**
 * @author jumperchen
 *
 */
public class ValidationViewModel {
	private String firstName;
	
	@NotifyChange("fullName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Size(min=3,message = "First name is too short (minimum is 3 characters)")
	public String getFirstName() {
		return firstName;
	}
	
	public String getFullName() {
		return (firstName == null ? "" : firstName) + " Potter";
	}
}
