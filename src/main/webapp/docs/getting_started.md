<markdown><!--

# Getting Started

### Install ZK Angular

* Download the jar files into your web project.
	* [Download 7.0.3.FL.20140801 and later version](http://www.zkoss.org/download/zk)
	* [Download ZK Angular](https://github.com/zkoss/zk-angular/releases)

* Or using Maven project

	1. Run the following command to generate a ZK web app with [Maven](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
				
			mvn archetype:generate \
				-DgroupId=org.zkoss.angular \
				-DartifactId=zkangulardemo \
				-Dversion=1.0-SNAPSHOT \
				-DpackageName=demo.basic \
				-DarchetypeGroupId=org.zkoss \
				-DarchetypeArtifactId=zk-archetype-webapp \
				-DarchetypeVersion=7.0.2 \
				-Dzk-version-since=7.0.3.FL.20140801 \
				-DinteractiveMode=false
	
	2. Make sure the following dependencies are in the _pom.xml_ file
	
		__`ZK Maven`__
		
			<dependency>
				<groupId>org.zkoss.zk</groupId>
				<artifactId>zkbind</artifactId>
				<version>7.0.3.FL.20140801</version>
			</dependency>
			<dependency>
				<groupId>org.zkoss.zk</groupId>
				<artifactId>zul</artifactId>
				<version>7.0.3.FL.20140801</version>
			</dependency>
			<dependency>
				<groupId>org.zkoss.zk</groupId>
				<artifactId>zhtml</artifactId>
				<version>7.0.3.FL.20140801</version>
			</dependency>
			<dependency>
				<groupId>org.zkoss.zk</groupId>
				<artifactId>zkplus</artifactId>
				<version>7.0.3.FL.20140801</version>
			</dependency>
	
		__`ZK Angular Maven`__	
				
			<dependency>
				<groupId>org.zkoss.angular</groupId>
				<artifactId>zk-angular</artifactId>
				<version>0.8.0</version>
			</dependency>
	
For more details about how to install Eclipse with ZK, please refer to this [ZK Installation Guide](http://books.zkoss.org/wiki/ZK%20Installation%20Guide/Setting%20up%20IDE)

### Declaring Domain Class

__`BasicViewModel.java`__
	
	package demo.basic;
	import org.zkoss.bind.annotation.NotifyChange;
	
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

As you can see the above, we declare the annotation __@NotifyChange__ for the `setFirstName(String firstName)` to
notify the variable of __fullName__ has changed, while the method `setFirstName(String firstName)` being invoked.
And then the view area of that variable binding `vm.fullName` will also get up to date.
	
### Declaring HTML template

__`basic.zhtml`__

	<html xmlns:ng="http://angularjs.org" xmlns="native" xmlns:u="zul">
	<head>
		<title>Basic Demo</title>
	</head>
	<body class="ng-cloak">
		<u:div apply="org.zkoss.angular.AngularComposer"
			binder="@init(value='org.zkoss.angular.AngularBinder')"
			viewModel="@id('vm') @init('demo.basic.BasicViewModel')"
			ng:controller="MyCtl">
			<label>First Name:</label> <input type="text" ng:model="@bind(vm.firstName)"
				placeholder="Enter a name here"/>
			<hr/>
			<h1>Hello <label ng:bind="@load(vm.fullName)"/> !</h1>
		</u:div>
		<script src="App.js"/>
	</body>
	</html>

Here we used is a HTML template with the three namespace as follows:

* __angular__: `xmlns:ng="http://angularjs.org"`

	The namespace is the same as that of Angularjs and will be handled by ZK Angular parser.
* __native__: `xmlns="native"`

	The namespace is used to be interpreted as a native tag that will be sent to the browser directly, rather than becoming a ZK component.
* __zul__: `xmlns:u="zul"`

	The namespace is used to be interpreted as a ZK component.
	
And we use two-way data binding for the input element with `ng:model="@bind(vm.firstName)"` to synchronize the data _vm.firstName_ from server to client and vise versa.
And then use one-way data binding for the fullName with `<label ng:bind="@load(vm.fullName)"></label>` to
load once the _fullName_ of the ViewModel has changed.
### Declaring JavaScript controller

__`App.js`__

	var app = angular.module('basic', ['zk']);
	app.controller('MyCtl', ['$scope', '$element', '$binder', function($scope, $element, $binder) {
		// init ZK Binder
		$binder.$init($scope, $element);
	}]);
	// init the zk-angular app
	zk.afterMount(function() {
		angular.bootstrap(document, [ 'basic']);
	});
		
All you need to do is to include the `zk` module by the following command `angular.module('basic', ['zk'])`
and then initial the ZK Binder within the controller code `$binder.$init($scope, $element);`
and then bootstrap the angular app in the function `zk.afterMount` that will be invoked after ZK mounted.
### Running the Demo
After start with the web server, you can visit the page `http://localhost:8080/zkangulardemo/index.zhtml` to see the following result.
<div class="runnable-example" ng-show="doc.sourceItems">
	<div class="runnable-example-file" ng-show="demoActiveTabIndex==$index" ng-repeat="source in doc.sourceItems"
		zk-ng-include="source.path"/>
</div>

### Download the basic sample
Clone the ZK-Angular-Sample repository located at GitHub by running the following command:
	
	git clone https://github.com/jumperchen/ZK-Angular-Sample.git
--></markdown>