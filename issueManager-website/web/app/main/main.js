angular.module('templates', []);
var app = angular.module('app', ['ngRoute', 'ngCookies', 'ngStorage', 'templates']);

app.config(['$routeProvider', '$locationProvider', '$httpProvider', //
  function($routeProvider, $locationProvider, $httpProvider) {

  /* Register error provider that shows message on failed requests or redirects to login page on
  * unauthenticated requests */
  $httpProvider.interceptors.push(['$q', '$rootScope', '$location',//
  function ($q, $rootScope, $location) {
    return {
      'responseError': function(rejection) {
        var status = rejection.status;
        var method = rejection.config.method;
        var url = rejection.config.url;
        if (status == 401) {
          $location.path( "/login" );
        } else {
          $rootScope.error = method + " on " + url + " failed with status " + status;
        }         
        return $q.reject(rejection);
      }
    };   
  }]);
        
  /* Registers auth token interceptor, auth token is either passed by header 
  * or by query parameter as soon as there is an authenticated user */
  $httpProvider.interceptors.push(['$q', '$rootScope', '$location', '$cookieStore',//
  '$localStorage', function ($q, $rootScope, $location, $cookieStore, $localStorage) {
    return {
      'request': function(config) {

        var userToken = $localStorage.userToken;
        console.log(userToken);

        if (angular.isDefined(userToken)) {
          config.headers['X-AUTH-TOKEN'] = JSON.stringify(userToken);
        }
        if (angular.isDefined(userToken) && $location.path() === '/login') {
          $location.path('/');  
        }

        return config;
      }
    };
  }]);  
}]);

app.run(['$rootScope', '$location', '$cookieStore', 'UserService', '$localStorage', //
  function($rootScope, $location, $cookieStore, UserService, $localStorage) {
    
  /* Reset error when a new view is loaded */
  $rootScope.$on('$viewContentLoaded', function() {
    delete $rootScope.error;
  });
  
  $rootScope.hasRole = function(role) {     
    if ($rootScope.user === undefined) {
      return false;
    }   
    if ($rootScope.user.roles[role] === undefined) {
      return false;
    }    
    return $rootScope.user.roles[role];
  };
  
  $rootScope.logout = function() {
    delete $rootScope.user;
    delete $rootScope.userToken;
    $cookieStore.remove('userToken');
    $location.path("/login");
  };

  // Go to home page when the url is invalid
  $rootScope.$on('$stateNotFound', function(event, unfoundState, fromState, fromParams){ 
    //event.preventDefault();
    console.log('cccccc');
    if (angular.isDefined($localStorage.userToken) && $localStorage.userToken!== null) {
      $location.path('/');
    }
  });

  $rootScope.$on('$routeChangeStart', function(next, current) { 
    console.log('heyyyyy');
  });
   
  $rootScope.initialized = true;
}]);
