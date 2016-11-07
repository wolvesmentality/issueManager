app.config(['$routeProvider',function($routeProvider) {
  $routeProvider
  .when("/hello", {
    templateUrl : "features/hello/hello.html"
  })
}]);
app.controller('HelloCtrl', ['$scope', '$http', function($scope, $http) {
  var self = $scope;
  self.hello = 'hello world';
  self.version = null;

  var getVersion = function() {
  	$http.get('http://127.0.0.1:8080/issueManager-services/appSetting/version').then(function(response) {
      self.version = response.data;
  	});
  };

  //getVersion();

  $(document).ready(function() {
    var table =  $('#example').DataTable({
      autoFill: false
    });
  });

}]);
