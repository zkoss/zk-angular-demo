<markdown><!--

# Chat Room Demo

This chat room demo demonstrates how to use ZK Angular to build a server push demo.

You can use two browsers to chat with each other using different usernames.
 
 <div class="runnable-example" ng-show="doc.sourceItems">
	<nav class="runnable-example-tabs">
		<a class="btn" ng-repeat="source in doc.sourceItems" ng-class="{active:demoActiveTabIndex==$index}" ng-click="setTab($index)" data-anchor="{{source.name}}">{{source.name}}</a>
	</nav>
	<div class="runnable-example-file auto-height" ng-show="demoActiveTabIndex==$index" ng-repeat="source in doc.sourceItems"
		zk-ng-include="source.path"/>
</div>

--></markdown> 