(function () {
angular.module('zkngdemo').controller('DemoCtl', ['$scope', '$element', '$binder', '$location',
          function($scope, $element, $binder, $location) {
	var shortpath = decodeURI($location.path()).replace(zk.contextURI+'/', '');
	$binder.$init($scope, $element);
	$scope.title = 'Introduction';
	$scope.navItems = [{
		id: 'introduction',
		title: 'Introduction',
		path: 'docs/introduction.md',
		sourceItems: [{
			name: 'index.xhtml',
			path: 'docs/source/intro-xhtml.md'
		},{
			name: 'script.js',
			path: 'docs/source/intro-js.md'
		},{
			name: 'BasicViewModel.java',
			path: 'docs/source/intro-java.md'
		},{
			name: 'Demo',
			path: 'include/basic/basic.xhtml'
		}]
	},{
		id: 'getting_started',
		title: 'Getting Started',
		path: 'docs/getting_started.md',
		sourceItems: [{
			name: 'Demo',
			path: 'include/basic/basic.xhtml'
		}]
	},{
		id: 'one_way',
		title: 'One-way Data Binding',
		path: 'docs/one_way.md'
	},{
		id: 'two_way',
		title: 'Two-way Data Binding',
		path: 'docs/two_way.md'
	},{
		id: 'commands',
		title: 'Send Server Side Commands',
		path: 'docs/commands.md'
	},{
		id: 'validation',
		title: 'Server Side Validation',
		path: 'docs/server_validation.md',
		sourceItems: [{
			name: 'index.xhtml',
			path: 'docs/source/validation-xhtml.md'
		},{
			name: 'script.js',
			path: 'docs/source/validation-js.md'
		},{
			name: 'ValidationViewModel.java',
			path: 'docs/source/validation-java.md'
		},{
			name: 'Demo',
			path: 'include/basic/validation.xhtml'
		}]
	},{
		id: 'master_detail',
		title: 'Demo - Master Detail',
		path: 'docs/master_detail.md',
		sourceItems: [{
			name: 'Demo',
			path: 'include/master_detail/demo.xhtml'
		},{
			name: 'index.xhtml',
			path: 'docs/source/master-xhtml.md'
		},{
			name: 'edit.html',
			path: 'docs/source/master-edit-html.md'
		},{
			name: 'list.html',
			path: 'docs/source/master-list-html.md'
		},{
			name: 'script.js',
			path: 'docs/source/master-js.md'
		},{
			name: 'SearchViewModel.java',
			path: 'docs/source/master-java.md'
		}]
	},{
		id: 'chat_room',
		title: 'Demo - Chat Room (Server Push)',
		path: 'docs/chat.md',
		sourceItems: [{
			name: 'Demo',
			path: 'include/chat/demo.xhtml'
		},{
			name: 'index.xhtml',
			path: 'docs/source/chat-xhtml.md'
		},{
			name: 'script.js',
			path: 'docs/source/chat-js.md'
		},{
			name: 'ChatRoomViewModel.java',
			path: 'docs/source/chat-java.md'
		}]
	}];
	// init
	function initItem(path) {
		$scope.doc = $scope.navItems[0];
		if (path) {
			jq($scope.navItems).each(function () {
				if (this.id == path) {
					$scope.doc = this;
				}
			});
		}
		$scope.demoActiveTabIndex = 0;
	}
	initItem(shortpath);
	$scope.setSelectedItem = function (item) {
		if (typeof item == "string") {
			initItem(item);
			if (!zk.ie || zk.ie > 9)
				$location.path(zk.contextURI +'/' + $scope.doc.id); 
		} else {
			$scope.doc = item || $scope.navItems[0];
			var id = $scope.doc.id;
			if (!zk.ie || zk.ie > 9)
				$location.path(zk.contextURI + '/' + id);
			$scope.demoActiveTabIndex = 0;
		}
	}
	
	$scope.setTab = function ($index, scrollIntoView) {
		$scope.demoActiveTabIndex = $index;
		if (scrollIntoView) {
			$('html, body').animate({
		        scrollTop:jq('a[data-anchor="'+scrollIntoView+'"]').offset().top - jq('header').height() - 10
		    }, 500);
		}
		
	}
		
	if (!zk.ie || zk.ie > 9) {
		$(window).bind('popstate', function(event) {
			var path = $location.path();
			if (path) {
				var end = path.lastIndexOf('/');
				if (end >= 0)
					path = path.substring(end + 1);
				$scope.$apply(function () {
					initItem(path);
				});
			}
		});
	}
}]);
// init the zk-angular app
zk.afterMount(function () {
	angular.bootstrap(document, [ 'zkngdemo']);
});
})();