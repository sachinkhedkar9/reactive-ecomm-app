ShoppingApp.controller('addNewItemController', ['$scope', '$http', 'getAbsUrl', '$rootScope', function($scope, $http, getAbsUrl, $rootScope) {

  console.log("in addNewItemController");

  $scope.addItem = function(){
    $scope.product.username = $rootScope.user.username;
    console.log('Adding item : ',$scope.product);
    $http.post($rootScope.appBaseUrl + '/addProduct', $scope.product,{
        headers: { 'Content-Type': 'application/json; charset=UTF-8'
        		}
    }).success(function(responseData) {
        // var absUrl = $location.absUrl().split('#')[0];
        // $window.location = absUrl+"#/"+$rootScope.user.username+"/dashboard/"+$rootScope.user.role+"/";
        getAbsUrl.navigateTo("/"+$rootScope.user.username+"/dashboard/"+$rootScope.user.role+"/")
        console.log("successfully added product");
    });
  }

}]);
