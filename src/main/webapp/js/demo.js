var app = angular.module('zkngdemo', ['zk']);
app.config(['$controllerProvider', '$locationProvider',
            function ($controllerProvider, $locationProvider) {
	app.$controllerProvider = $controllerProvider;
	if (!zk.ie || zk.ie > 9)
		$locationProvider.html5Mode(true);
}]);
app.directive('markdown', ['$compile', function ($compile) {

    var converter = new Showdown.converter();
    return {
      restrict: 'AE',
      link: function (scope, element, attrs) {
    	 if (attrs.markdown) {
	         var html = converter.makeHtml(element.text());
	         element.html(html);
	         element.find('pre code').each(function(i, block) {
   			  hljs.highlightBlock(block);
   			});
    	 } else {
    		 var cnt = element.contents()[0];
    		 if (cnt.nodeType == 8) {
    			 cnt = cnt.nodeValue;
    		 } else {
    			 cnt = element.text();
    		 }
	         var html = converter.makeHtml(cnt);
    		 var e =$compile(html)(scope);
    		 var parent = element.parent();
    		 element.html(e);
    		 parent.find('pre code').each(function(i, block) {
			  hljs.highlightBlock(block);
			});
    	 }
      }
    };
}]);