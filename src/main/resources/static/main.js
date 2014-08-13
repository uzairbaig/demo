var app = angular.module('bookingModule',[]);

	app.controller('HelloCtrl', function ($scope, $http) {
		$http.get('http://localhost:8080/bookings').
	       success(function(data) {
	       	console.log(data);
	           $scope.booking = data;
	         });
		
		$scope.sayHello = function(id) {
			alert(id);
			var bookingUrl = '/booking/'+id;
			alert(bookingUrl);
			 $http({method: 'GET', url: bookingUrl}).
			    success(function(data, status, headers, config) {
			    	console.log('Status: '+status);
			    	console.log(data);
			    }).
			    error(function(data, status, headers, config) {
			      // called asynchronously if an error occurs
			      // or server returns response with an error status.
			    });
		};
	
});