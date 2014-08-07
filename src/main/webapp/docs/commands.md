<markdown><!--
# Send Server Side Commands

Sometimes the developer wants to send a command from client to server to do something,
then he can use the syntax `@command` and `@global-command`.

* `@command(expression)` (send a commnd to server)
	 - **Usage:** The expression can be applied to *ng-BrowserEvents*, such as (`ng-click`, `ng-change`, `ng-mousedown`, and so on.)
	 
	 For example,
	
	 __`HTML`:__
			
			<span>
				Keyword: <input type="text" ng:model="@bind(vm.keyword)"
							ng:change="@command('search')" class="form-control"
							placeholder="Enter a name here" />
			</span>
		
	 __`Java`:__

			public class SearchViewModel {
				private String keyword;
				//omitted
				@Command
				@NotifyChange("carList")
				public void search() {
					carList = carService.search(keyword);
				}
			}

	 or with an argument
	
	 __`HTML`:__
			
			<button ng-click="@command('update', {car:editCar});"
					class="btn btn-primary">Update</button>
		
	 __`Java`:__

			public class SearchViewModel {
				private String keyword;
				//omitted
				@Command
				@NotifyChange("carList")
				public void update(@BindingParam("car") Car car) {
					//omitted
				}
			}
	 
	 As you can see, we pass the __editCar__ argument within the __update__ command
	 and then it will automatically be converted from a JavaScript Object to the Java Object `Car`, which
	 is received from `@BindingParam("car")`
	 
	 For more details about the `@command(expression)`, please refer to the document. <a href="http://books.zkoss.org/wiki/ZK%20Developer's%20Reference/MVVM/Syntax/Data%20Binding/@command" target="_blank">ZK MVVM @Command</a>

* `@global-command(expression)` (send a global scope commnd to server)
	 - **Usage:** The expression can be used as the same as `@command`, the only different
	 is that the `global-command` will send through the ZK global scope (cross different ViewModels) not only within a local scope (single ViewModel).
	 
	 For example,
	
	 __`HTML`:__
			
			<button ng-click="@global-command('show');"
					class="btn btn-primary">Show All</button>
		
	 __`Java`:__

			public class SearchViewModel {
				private String keyword;
				//omitted
				@GlobalCommand
				@NotifyChange("carList")
				public void show() {
					//omitted
				}
			}
	 
	 For more details about the `@global-command(expression)`, please refer to the document. <a href="http://books.zkoss.org/wiki/ZK%20Developer's%20Reference/MVVM/Syntax/Data%20Binding/@global-command" target="_blank">ZK MVVM @GlobalCommand</a>
## Related Topics

* [ZK MVVM Commands](http://books.zkoss.org/wiki/ZK_Developer's_Reference/MVVM/ViewModel/Commands)
* <a ng-click="setSelectedItem('one_way')">One-way Data Binding</a>
* <a ng-click="setSelectedItem('two_way')">Two-way Data Binding</a>
	
--></markdown>