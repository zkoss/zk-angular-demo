<markdown><!-- 
``` html
<html xmlns:ng="http://angularjs.org" xmlns="native" xmlns:u="zul">
	<head>
		// put your JS library and CSS library here, if any
	</head>
	<body>
		<u:div apply="org.zkoss.angular.AngularComposer"
			binder="@init(value='org.zkoss.angular.AngularBinder')"
			viewModel="@id('vm') @init('demo.basic.BasicViewModel')"
			ng:controller="MyCtl">
			<label>First Name:</label> <input type="text" ng:model="@bind(vm.firstName)"
				placeholder="Enter a name here"/>
			<hr/>
			<h1>Hello <label ng:bind="@load(vm.fullName)"/> !</h1>
		</u:div>
	</body>
</html>
```
 --></markdown>