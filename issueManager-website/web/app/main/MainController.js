app.controller('MainController', ['$scope', '$cookieStore', //
'UserService', '$location', '$rootScope', '$localStorage', //
function ($scope, $cookieStore, UserService, $location, $rootScope, $localStorage) {

  $scope.isAuthenticated = function() {
    var userToken = $localStorage.userToken;
    return (angular.isDefined(userToken) && userToken !== null);
  };

  $scope.logout = function() {
    UserService.logout().then(function (response) {
      delete $rootScope.userToken;
      delete $localStorage.userToken;
      $location.path("/login");      
    });
  };
}]);