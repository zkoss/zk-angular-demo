<markdown><!--
# Two-way Data Binding

Two-way data binding means that data will always synchronize from client to server and vice versa.

* `@bind(expression)` (Load from and save to server)
	 - **Usage:** The expression can be applied to `ng:model` with the angular namesapce `xmlns:ng="http://angularjs.org`.
	 
	 For example,
			
			<input type="text" ng:model="@bind(vm.firstName)"
						placeholder="Enter a name here"/>
			
	 or an indirect way
	
			<div ng:myFirstName="@load(vm.firstName)">
	 			<input type="text" ng:model="myFirstName"
						placeholder="Enter a name here"/>
	 		</div>
	 		
	  For more details about the `@bind(expression)`, please refer to the document <a href="http://books.zkoss.org/wiki/ZK%20Developer's%20Reference/MVVM/Syntax/Data%20Binding/@bind" target="_blank">ZK MVVM @Bind</a>
	 
	 
## Related Topics

* <a ng-click="setSelectedItem('one_way')">One-way Data Binding</a>
* <a ng-click="setSelectedItem('commands')">Send Server Side Commands</a>
	
--></markdown>