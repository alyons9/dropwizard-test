'use strict';

/**
 * @ngdoc overview
 * @name sportsAppApp
 * @description
 * # sportsAppApp
 *
 * Main module of the application.
 */
angular.module('sportsAppApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      }).when('/nfl', {
        templateUrl: 'views/nfl.html'
      }).when('/nba', {
        templateUrl: 'views/nba.html'
      }).when('/nhl', {
        templateUrl: 'views/nhl.html'
      }).when('/fifa', {
        templateUrl: 'views/fifa.html'
      }).when('/ncaab', {
        templateUrl: 'views/ncaab.html'
      }).when('/ncaaf', {
        templateUrl: 'views/ncaaf.html'
      }).when('/mlb', {
        templateUrl: 'views/mlb.html'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
