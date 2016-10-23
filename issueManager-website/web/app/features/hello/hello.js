app.config(['$routeProvider',function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "features/hello/hello.html"
  })
}]);
app.controller('HelloCtrl', ['$scope', function($scope) {
  var self = $scope;
  self.hello = 'hello world';
}]);
