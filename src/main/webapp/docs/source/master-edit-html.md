<markdown><!-- 
``` html
<form name="editForm" novalidate="true">
	<div class="bs-callout bs-callout-info" ng-show="editCar">
		<image ng-src="{{editCar.preview | encodeURL}}" style="padding:10px" />
		<div class="form-group">
			<label>Model :</label> <input type="text" class="form-control"
				ng-required="true" ng-model="editCar.model" />
		</div>
		<div class="form-group">
			<label>Make :</label> <input type="text" class="form-control"
				ng-required="true" ng-model="editCar.make" />
		</div>
		<div class="form-group">
			<label>Price :</label>
			<div class="input-group">
				<span class="input-group-addon">$</span><input type="number"
					class="form-control" ng-required="true" max="2147483647"
					ng-model="editCar.price" />
			</div>
		</div>
		<div class="form-group">
			<label>Description :</label>
			<textarea ng-model="editCar.description" class="form-control"
				rows="5" />
		</div>
	</div>
	<button ng-click="cancel()" class="btn">Cancel</button>
	<button ng-click="@command('update', {car:editCar}); finish(editCar)"
		ng-disabled="!editForm.$dirty || editForm.$invalid"
		class="btn btn-primary">Update</button>
</form>
```
 --></markdown>