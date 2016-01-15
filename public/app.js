var ShoppingApp = angular.module("ShoppingApp",['ngRoute']);

ShoppingApp.config(['$routeProvider', function($routeProvider){
  $routeProvider.
  when("/signup/",{
    templateUrl: 'views/signup.html',
    // controller: 'signupController'
  }).
  when("/login/",{
    templateUrl: 'views/login.html',
    // controller: 'loginController'
  }).
  when("/:id/dashboard/seller/",{
    templateUrl: 'views/merchant-dashboard.html',
    // controller: 'merchantDashboardController'
  }).
  when("/:id/dashboard/buyer/",{
    templateUrl: 'views/buyer-dashboard.html',
    // controller: 'buyerDashboardController'
  }).
  when("/user-id=:id/edit-item/item-id=:id/",{
    templateUrl: 'views/edit-item.html',
    // controller: 'editItemController'
  }).
  when("/user-id=:id/add-item/",{
    templateUrl: 'views/add-Product.html',
    // controller: 'addNewItemController'
  }).
  otherwise({
    redirectTo: '/login/'
  })
}]);

ShoppingApp.controller('masterController', ['$scope', '$rootScope', '$location', '$window' , function($scope, $rootScope, $location, $window){
  $rootScope.user = {};
  $scope.userLoggedIn = $scope.userLoggedIn || false;


  $scope.logout = function(){
    var absUrl = $location.absUrl().split('#');
    $rootScope.user = {};
    $scope.userLoggedIn = false;
    $window.location.replace(absUrl[0] + '#/login/');
  }

  $rootScope.authenticated = function(user){
      $scope.user = user;
      console.log("user : ",user);
      $scope.userLoggedIn = true;
  }
}]);
