<markdown><!-- 
``` html
<html xmlns:ng="http://angularjs.org" xmlns="native" xmlns:u="zul">
	<head>
		// put your JS library and CSS library here, if any
	</head>
	<body>
		<u:div id="myDiv" apply="org.zkoss.angular.AngularComposer"
			binder="@init(value='org.zkoss.angular.AngularBinder')"
			viewModel="@id('vm') @init('demo.basic.ValidationViewModel')"
			validationMessages="@id('vmsgs')"
			ng:controller="MyBasicCtl">
			<label>First Name:</label>
			<input type="text" ng:model="@save(vm.firstName) @validator('beanValidator')"
				placeholder="Enter a name here" />
			<label class="label label-danger" ng:bind="@load(vmsgs[myDiv])"/>
			<hr />
			<h1>
				Hello <label ng:bind="@load(vm.fullName)" /> !
			</h1>
		</u:div>
	</body>
</html>
```
 --></markdown>