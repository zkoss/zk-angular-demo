<markdown>
```js
// import zk module	
var app = angular.module('basic', ['zk']);

app.controller('MyCtl', [ '$scope', '$element', '$binder',
	function($scope, $element, $binder) {
		$binder.$init($scope, $element);
		$scope.message = 'Hi, everybody!';
		
		// sync the scrollbar to the end of the list
		$scope.$watchCollection('chatList', function () {
			setTimeout(function () {
				var $id = jq('#scrollBottom');
				$id.scrollTop($id[0].scrollHeight);
			});
		});
		// reset server's vm state
		$scope.$on('$destroy', function() {
			if ($scope.myForm.hasUserName) {
				$scope.$globalCommand('resetVM', {username: $scope.myForm.username.$viewValue});
			}
		});
	}]);

// init the zk-angular app
zk.afterMount(function() {
	angular.bootstrap(document, [ 'basic']);
});
```
</markdown>