<markdown><!--
# One-way Data Binding

The ZK Angular provides two kinds of one-way data binding as follows:

* `@load(expression)` (Load from server)
	 - **Usage:** The expression can be applied to `ng:bind` with the angular namespace `xmlns:ng="http://angularjs.org`.
	 
	 For example,
	 	 
	 		<label ng:bind="@load(vm.fullName)"/>
	 	
	 or an indirect way
	 
	 		<div ng:myFullName="@load(vm.fullName)">
	 			<label ng-bind="myFullName"/>
	 		</div>
	 
	 For more details about the `@load(expression)`, please refer to the document <a href="http://books.zkoss.org/wiki/ZK%20Developer's%20Reference/MVVM/Syntax/Data%20Binding/@load" target="_blank">ZK MVVM @Load</a>
	 
* `@save(expression)` (Save to server)
	 - **Usage:** The expression is only used when the data has to be sent to the server.
	 
	 For example,
	 
	 		<input type="text" ng:model="@save(vm.firstName)"
				placeholder="Enter a name here"/>

	In this case, we use `@save` for `ng:model` to save the change to server,
	not load from server. Most of the cases, you should use `@bind(expression)` the two-way data binding instead.
	
	For more details about the `@save(expression)`, please refer to the document <a href="http://books.zkoss.org/wiki/ZK%20Developer's%20Reference/MVVM/Syntax/Data%20Binding/@save" target="_blank">ZK MVVM @Save</a>

## Related Topics

* <a ng-click="setSelectedItem('two_way')">Two-way Data Binding</a>
* <a ng-click="setSelectedItem('commands')">Send Server Side Commands</a>

--></markdown>