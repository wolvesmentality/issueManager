app.config(['$routeProvider',function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "features/home/home.html"
  })
}]);
app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  var self = $scope;
}]);