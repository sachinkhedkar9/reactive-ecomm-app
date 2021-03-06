ShoppingApp.controller('merchantDashboardController',['$scope','getAbsUrl', '$rootScope', function($scope, getAbsUrl, $rootScope){
  $scope.user_id = $rootScope.user.username;

  $scope.getListOfProducts = function(){

    var ws = new WebSocket($rootScope.wsBaseUrl + "/products");
    ws.onopen = function()
    {
       ws.send(JSON.stringify({"username": $scope.user_id}));
    };

    ws.onmessage = function (evt)
    {
       var items = angular.copy(JSON.parse(evt.data));
       $scope.items = items;
       console.log("products : ", $scope.items);
       $scope.$apply();
       ws.close();
    };

    ws.onclose = function(){
      console.log("closing the connection");
    };
  }

  $scope.getListOfProducts();

  $scope.top_sellers = top_sellers;
  $scope.yearly_revenues = yearly_revenues;

  var donut = c3.generate({
    bindto: '#top-sellers-donut',
    data: {
      // x: 'x',
      columns: $scope.top_sellers,
      type: 'donut'
    },
    donut:{
      title: 'Top Selling Products'
    }
  });

  var bar = c3.generate({
    bindto: '#yearly-sales-revenue',
    data: {
      x: 'x',
      columns: $scope.yearly_revenues,
      type: 'bar'
    },
    axis:{
      x: {
        type: 'category'
      }
    }
  });

  var historyObj = window.history;

    $scope.addNewItem = function(){
    console.log("Adding new item");
    // var user_id = $location.url().split('/')[1];
    // $location.path("/user-id="+user_id+"/add-item/");
    getAbsUrl.navigateTo("/user-id="+$rootScope.user.username+"/add-item/");
  }

  $scope.reload = function(){
    getAbsUrl.reload();
  }
  // console.log(" browser history : ",historyObj);
}]);



ShoppingApp.controller('bulkUploadController', ['$scope', '$location', 'fileUpload', '$rootScope', function($scope, $location, fileUpload, $rootScope){

    $scope.uploadFile = function(){
        var file = $scope.myFile;
        console.log('file is ' );
        console.dir(file);
        var absUrl = $location.absUrl().split('#');
        var uploadUrl = $rootScope.appBaseUrl + "/uploadProducts";
        console.log("uploadUrl : ",uploadUrl);
        fileUpload.uploadFileToUrl(file, uploadUrl);
        $('#notification-success').modal('show');
    };

}]);

ShoppingApp.controller('buyerDashboardController',['$scope', 'getAbsUrl', '$rootScope', 'dataTransfer', function($scope, getAbsUrl, $rootScope, dataTransfer){
  // currently accepting the items as the products for the buyer. need to have all the items from all the merchants in all items
  // $scope.user_id = $location.url().split('/')[1];
  $scope.user_id = $rootScope.user.username;

  $scope.getRecommendedProducts = function(){
    var ws = new WebSocket($rootScope.wsBaseUrl + "/searchProducts");
    ws.onopen = function()
    {
       ws.send(JSON.stringify({"search_string": ""}));
    };

    ws.onmessage = function (evt)
    {
       var items = angular.copy(JSON.parse(evt.data));
       $scope.items = items;
       $scope.recommendations = ($scope.items) ? $scope.items.slice(0,5) : [];
       console.log("recommended products : ", $scope.items);
       $scope.$apply();
       ws.close();
    };

    ws.onclose = function(){
      console.log("closing the connection");
    };
  }

  $scope.getRecommendedProducts();

  console.log("recommendations ", $scope.recommendations  );

  $scope.goToProduct = function(obj){
    dataTransfer.set(obj);
    getAbsUrl.navigateTo("/user-id=" + $rootScope.user.username + "/buyer/id="+obj._id+"/");
  }


  $scope.search = function(){
    // $scope.searchResults = items;

    var ws = new WebSocket($rootScope.wsBaseUrl + "/searchProducts");
    ws.onopen = function()
    {
       ws.send(JSON.stringify({"search_string": $scope.searchProduct}));
    };

    ws.onmessage = function (evt)
    {
       $scope.searchResults = angular.copy(JSON.parse(evt.data));
       console.log("search products : ", $scope.items);
       $scope.$apply();
       ws.close();
    };

    ws.onclose = function(){
      console.log("closing the connection");
    };

    var search = document.getElementById('search-results');
    search.style.display = 'block';
  }


}]);
