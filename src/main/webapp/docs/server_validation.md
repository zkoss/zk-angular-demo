<markdown><!--
# Server Side Validation

[AngularJS's Form](https://docs.angularjs.org/guide/forms) provides some validation services 
in which users are notified of invalid input at the client side to do a dirty check of the form.
ZK Angular also provides a validation way with or without [JSR 303](http://docs.oracle.com/javaee/6/tutorial/doc/gircz.html) at server side.

### Validation Demo with JSR 303
<div class="runnable-example" ng-show="doc.sourceItems">
	<nav class="runnable-example-tabs">
		<a class="btn" ng-repeat="source in doc.sourceItems" ng-class="{active:demoActiveTabIndex==$index}" ng-click="setTab($index)" data-anchor="{{source.name}}">{{source.name}}</a>
	</nav>
	<div class="runnable-example-file" ng-show="demoActiveTabIndex==$index" ng-repeat="source in doc.sourceItems"
		zk-ng-include="source.path"/>
</div>
* __`index.xhtml`__ :

	We declare `validationMessages="@id('vmsgs')"` to a ZK component (`u:div`)
	and then add an annotation to the input element with `ng:model="@save(vm.firstName) @validator('beanValidator')"`
	to tell the server that we need a _JSR 303_ validator here, and then specify the
	error message bound with a label with the expression `ng:bind="@load(vmsgs[myDiv])"`. (_myDiv_ is the ID of `u:div`)
	
* __`ValidationViewModel.java`__:

	Here we use the class `javax.validation.constraints.Size` to check if the returned
	value after invoking `getFirstName()` is less than 3 characters, and
	then show the message with _"First name is too short (minimum is 3 characters)"_
	
### Summary

For a secure application, validations of both the client and the server are necessary. Depending on what suits a particular user experience better, the developer can 
choose which validation is used on what. For example if the validation needs an instant feedback such as password strength, the developer may choose to use client validation. 
If the validation may take some time for example checking a username, then it is probably more suitable to use server validation.  

## Related Topics

* [ZK MVVM Validator](http://books.zkoss.org/wiki/ZK_Developer's_Reference/MVVM/Data_Binding/Validator)
--></markdown>