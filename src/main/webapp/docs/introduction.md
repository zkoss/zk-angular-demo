<markdown><!--
# Introduction of the ZK Angular Project

This project aims to provide a convenient way for Java developers to bind data from the server to client and vice versa.
ZK Angular contains both the powers of [AngularJS][angularjs] and [ZK MVVM][mvvm]. __AngularJS__ 
is a structural framework for building dynamic web applications and provides a complete client-side solution. On the other hand, 
__ZK MVVM__ is a data binder to synchronize data between the View (__ZUL Page__) and ViewModel (__Java Object__) where 
in this project the View will be __AngularJS__'s template (HTML & CSS). The following figure illustrates the whole concept of this project.

<img class="diagram" src="img/zk-ng-architecture.png" width="740" height="600" alt="ZK Angular Architecture">

As you can see from the diagram above, we utilize __AngularJS__'s template engine and client side data binding to
generate the HTML result to the browser, and communicate with __ZK MVVM__'s data binding to
receive and store the data back to the server side. This way, the developer can define their
HTML as a UI template and make-up the page as any kind of web page with a library, such as [Twitter Bootstrap][bootstrap].
The role of [ZK][zk] in this case is a server side data binder (communicator) that help developers save development time
to communicate the data from server to client and client to server.

## The basic demo
<div class="runnable-example" ng-show="doc.sourceItems">
	<nav class="runnable-example-tabs">
		<a class="btn" ng-repeat="source in doc.sourceItems" ng-class="{active:demoActiveTabIndex==$index}" ng-click="setTab($index)" data-anchor="{{source.name}}">{{source.name}}</a>
	</nav>
	<div class="runnable-example-file" ng-show="demoActiveTabIndex==$index" ng-repeat="source in doc.sourceItems"
		zk-ng-include="source.path"/>
</div>

As you can see from the above, we define a tag ```<u:div>```, a ZK component, to be a client-server communicator, and then use a angularjs's namespace ```ng="http://angularjs.org"```
to define which html element is to be loaded or bound from server side.

The following explains how it works:

1. Specify Angular controller with ```ng:controller="MyCtl"```
2. Enable it to connect to ZK data binder with ``` $binder.$init($scope, $element);``` For example,

		var app = angular.module('basic', ['zk']);
		app.controller('MyCtl', ['$scope', '$element', '$binder', function($scope, $element, $binder) {
			// init ZK Binder
			$binder.$init($scope, $element);
		}]);
	
	the ```$binder``` variable is provided by ```zk``` module.
	
3. Define ```@bind``` two-way data binding (load from and save to server)
	
 		<input type="text" ng:model="@bind(vm.firstName)"
 		
	
4. Define ```@load``` one-way data binding (only load from server)

		<label ng:bind="@load(vm.fullName)"></label>
	
5. Define ```@NotifyChange("fullName")``` in _BasicViewModel.java_ to notify that the value of the fullname has changed when ```firstName``` has been called upon. 
Since vm.fullName was used in the template (step 4), it will also be notified. 
6. Now, we can run with <a class="btn btn-default" ng-click="setTab(3, 'Demo')">the demo</a>
[angularjs]: https://angularjs.org/
[zk]: http://www.zkoss.org
[mvvm]: http://books.zkoss.org/wiki/ZK%20Developer's%20Reference/MVVM
[bootstrap]: http://getbootstrap.com/
--></markdown>