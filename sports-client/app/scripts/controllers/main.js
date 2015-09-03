'use strict';

/**
 * @ngdoc function
 * @name sportsAppApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sportsAppApp
 */
angular.module('sportsAppApp')
.controller('MainCtrl', function ($scope, sportsSrv) {
    $scope.sports = '';
    $scope.articles = '';

    sportsSrv.getSports().success(function(response){
      console.log(response);
      $scope.sports = response;
    });

    sportsSrv.getSportsArticles().success(function(response){
      $scope.articles = response;
    });

    console.log($scope.sports);
  console.log($scope.sports);
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
