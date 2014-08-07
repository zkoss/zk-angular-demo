<markdown><!-- 
``` html
<div>
	<div class="bs-callout bs-callout-info" ng-show="selectedCar">
		<image ng-src="{{selectedCar.preview|encodeURL}}" style="padding:10px" />
		<div class="item-group">
			Model : <span style="font-weight: bold">{{selectedCar.model}}</span>
		</div>
		<div class="item-group">
			Make : <span style="font-weight: bold">{{selectedCar.make}}</span>
		</div>
		<div class="item-group">
			Price : <span>$ <span style="font-weight: bold">{{selectedCar.price}}</span></span>
		</div>
		<p class="text-warning" style="font-style: italic">{{selectedCar.description}}</p>
		<button ng-click='edit(selectedCar);' class="btn btn-primary">Edit</button>
	
	</div>
	<div class="bs-callout bs-callout-info" ng-hide="selectedCar">
		Select car from list</div>
</div>
```
 --></markdown>