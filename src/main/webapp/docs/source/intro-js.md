<markdown>
```js
// import zk module	
var app = angular.module('basic', ['zk']);

app.controller('MyCtl', ['$scope', '$element', '$binder', function($scope, $element, $binder) {
	// init ZK Binder
	$binder.$init($scope, $element);
}]);

// init the zk-angular app
zk.afterMount(function() {
	angular.bootstrap(document, [ 'basic']);
});
```
</markdown>