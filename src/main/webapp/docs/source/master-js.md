<markdown>
```js
// import zk module	
var app = angular.module('basic', ['zk']);

app.controller('MyCtl', ['$scope', '$element', '$binder', '$filter', function($scope, $element, $binder, $filter) {

	$binder.$init($scope, $element);
	
	function _getPath(src) {
		return $filter('encodeURL')(src, $scope);
	}
	$scope.setSelected = function(selectedCar) {
	    $scope.selectedCar = selectedCar;
	    $scope.view = _getPath('list.html');
	}
	
	$scope.isSelected = function(selectedCar) {
	    return $scope.selectedCar ? $scope.selectedCar.id === selectedCar.id : false;
	}
	
	$scope.edit = function (selectedCar) {
		$scope.editCar = angular.copy(selectedCar);
	    $scope.view = _getPath('edit.html');
	}
	
	$scope.cancel = function () {
		$scope.editCar = null;
		$scope.view = _getPath('list.html');
	}
	
	$scope.finish = function(editCar) {
		$scope.editCar = null;
		$scope.selectedCar = editCar;
		$scope.view = _getPath('list.html');
	}
	
	// reset server's vm state
	$scope.$on('$destroy', function() {
		$scope.$command('resetVM');
	});
}]);

// init the zk-angular app
zk.afterMount(function() {
	angular.bootstrap(document, [ 'basic']);
});
```
</markdown>