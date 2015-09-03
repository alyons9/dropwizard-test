'use strict';

/**
 * @ngdoc function
 * @name sportsAppApp.controller:MainCtrl
 * @description
 * # SpoertsService
 * Controller of the sportsAppApp
 */
angular.module('sportsAppApp')
.factory('sportsSrv', function($http){
    return {
      getSports: function(){
        return $http.get("http://localhost:8080/sports");
      },
      getSportsArticles: function(){
        return $http.get("http://localhost:8080/sports/article");
      }
    };
  });
