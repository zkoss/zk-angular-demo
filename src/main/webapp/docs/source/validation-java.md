<markdown>
```java
import javax.validation.constraints.Size;
import org.zkoss.bind.annotation.NotifyChange;

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
```
</markdown>