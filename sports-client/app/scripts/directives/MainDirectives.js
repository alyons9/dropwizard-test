angular.module('sportsAppApp')
.directive('articlePreview', function(){

  return {
    restrict: 'E',
    templateUrl: 'scripts/directives/articlePreview.html',
    scope: {
      articleInfo: '=info'
    }
  };
});
