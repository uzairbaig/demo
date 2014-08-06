angular.module('bookingModule',[])

.controller('HelloCtrl', function ($scope, $http) {
	$http.get('http://localhost:8080/bookings').
       success(function(data) {
       	console.log(data);
           $scope.booking = data;
         });
	
});