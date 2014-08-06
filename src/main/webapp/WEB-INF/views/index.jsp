<!doctype html>
<html ng-app="bookingModule">
	<head>
		<title>Hello AngularJS</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script src="main.js"></script>
	</head>

	<body ng-controller="HelloCtrl">
		<div>
		<ul ng-repeat="book in booking">
			<li>The ID is {{book.id}} and booking name is {{book.bookingName}}</li>
		</p>
		</div>
	</body>
</html>